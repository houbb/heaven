package com.github.houbb.heaven.reflect.meta.annotation.impl;

import com.github.houbb.heaven.reflect.meta.annotation.IAnnotationTypeMeta;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectAnnotationUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> project: heaven-AnnotationMeta </p>
 * <p> create on 2019/11/29 23:04 </p>
 *
 * @author Administrator
 * @since 0.1.52
 */
public abstract class AbstractAnnotationTypeMeta implements IAnnotationTypeMeta {

    /**
     * 注解引用 map
     * @since 0.1.52
     */
    private Map<String, Annotation> annotationRefMap;

    /**
     * 获取对应的注解信息列表
     *
     * （1）这里其实没有必要使用 {@link Map} 因为一般注解数量不会太多，只是数组性能反而更好。
     *
     * @return 注解数组
     * @since 0.1.52
     */
    protected abstract Annotation[] getAnnotations();

    protected AbstractAnnotationTypeMeta() {
        annotationRefMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isAnnotated(String annotationName) {
        Annotation annotation = this.getAnnotation(annotationName);
        return ObjectUtil.isNotNull(annotation);
    }

    @Override
    public Annotation getAnnotation(String annotationName) {
        ArgUtil.notEmpty(annotationName, "annotationName");

        Optional<Annotation> annotationOptional = getAnnotationOpt(getAnnotations(), annotationName);
        return annotationOptional.orDefault(null);
    }

    /**
     * 获取注解对应信息
     * @param annotations 注解数组
     * @param annotationName 指定注解名称
     * @return 结果信息
     * @since 0.1.52
     */
    private Optional<Annotation> getAnnotationOpt(final Annotation[] annotations, final String annotationName) {
        if(ArrayUtil.isEmpty(annotations)) {
            return Optional.empty();
        }

        for(Annotation annotation : annotations) {
            if(annotation.annotationType().getName().equals(annotationName)) {
                return Optional.ofNullable(annotation);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Annotation> getAnnotationRefs(String annotationName) {
        Set<Annotation> annotationSet = Guavas.newHashSet();

        if(ArrayUtil.isNotEmpty(getAnnotations())) {
            for(Annotation annotation : getAnnotations()) {
                Annotation[] annotationRefs = annotation.annotationType().getAnnotations();
                Optional<Annotation> annotationRefOptional = getAnnotationOpt(annotationRefs, annotationName);
                if(annotationRefOptional.isPresent()) {
                    // 添加引用属性（注解全称+引用的注解全称）
                    final String key = annotationName+annotation.annotationType().getName();
                    annotationRefMap.put(key, annotationRefOptional.get());

                    annotationSet.add(annotation);
                }
            }
        }

        return Guavas.newArrayList(annotationSet);
    }

    @Override
    public Annotation getAnnotationReferenced(String annotationName, String annotationRefName) {
        ArgUtil.notEmpty(annotationName, "annotationName");
        ArgUtil.notEmpty(annotationRefName, "annotationRefName");
        final String key = annotationName+annotationRefName;
        return annotationRefMap.get(key);
    }

    @Override
    public Map<String, Object> getAnnotationAttributes(String annotationName) {
        ArgUtil.notEmpty(annotationName, "annotationName");

        Annotation annotation = this.getAnnotation(annotationName);
        if(ObjectUtil.isNull(annotation)) {
            return null;
        }

        return ReflectAnnotationUtil.getAnnotationAttributes(annotation);
    }

}
