package com.github.houbb.heaven.reflect.meta.annotation;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * <p> project: heaven-AnnotationMeta </p>
 * <p> create on 2019/11/29 23:04 </p>
 *
 * @author Administrator
 * @since 0.1.52
 */
public interface IAnnotationTypeMeta {

    /**
     * Determine whether the underlying element has an annotation or meta-annotation
     * of the given type defined.
     * <p>If this method returns {@code true}, then
     * {@link #getAnnotationAttributes} will return a non-null Map.
     * @param annotationName the fully qualified class name of the annotation
     * type to look for
     * @return whether a matching annotation is defined
     * @since 0.1.52
     */
    boolean isAnnotated(String annotationName);

    /**
     * Determine whether the underlying element has an annotation or meta-annotation
     * of the given type defined.
     * @param annotationName the fully qualified class name of the annotation
     * type to look for
     * @return a matching annotation is returned
     * @since 0.1.52
     */
    Annotation getAnnotation(String annotationName);

    /**
     * 获取指定类型的所有相关注解
     * （1）排除直接注解本身
     * @param annotationName 注解名称
     * @return 注解类表
     * @since 0.1.52
     */
    List<Annotation> getAnnotationRefs(String annotationName);

    /**
     * 获取被引用的注解基本信息
     * @param annotationName 注解名称
     * @param annotationRefName 引用注解名称
     * @return 被引用的注解本身
     * @see #getAnnotationRefs(String) 首先执行这个获取引用
     */
    Annotation getAnnotationReferenced(String annotationName, final String annotationRefName);

    /**
     * Retrieve the attributes of the annotation of the given type, if any (i.e. if
     * defined on the underlying element, as direct annotation or meta-annotation),
     * also taking attribute overrides on composed annotations into account.
     * @param annotationName the fully qualified class name of the annotation
     * type to look for
     * @return a Map of attributes, with the attribute name as key (e.g. "value")
     * and the defined attribute value as Map value. This return value will be
     * {@code null} if no matching annotation is defined.
     * @since 0.1.52
     */
    Map<String, Object> getAnnotationAttributes(String annotationName);

}
