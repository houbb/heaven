/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 反射注解工具类
 *
 * @since 0.1.31
 * @author bbhou
 */
public final class ReflectAnnotationUtil {

    private ReflectAnnotationUtil() {}


    /**
     * 更新值信息
     * @param annotation 注解
     * @param method 方法
     * @param value 属性值
     * @since 0.1.31
     */
    @SuppressWarnings("unchecked")
    public static void updateValue(final Annotation annotation,
                                   final String method,
                                   final Object value) {
        // 获取 memberValues
        Map<String, Object> memberValues = getAnnotationMap(annotation);

        // 修改 value 属性值
        memberValues.put(method, value);
    }

    /**
     * 获取值信息
     * @param annotation 注解
     * @param method 方法
     * @since 0.1.31
     */
    @SuppressWarnings("unchecked")
    public static Object getValue(final Annotation annotation,
                                   final String method) {
        // 获取 memberValues
        Map<String, Object> memberValues = getAnnotationMap(annotation);

        // 修改 value 属性值
        return memberValues.get(method);
    }

    /**
     * 获取值信息-字符串形式
     * @param annotation 注解
     * @param method 方法
     * @since 0.1.31
     */
    @SuppressWarnings("unchecked")
    public static String getValueStr(final Annotation annotation,
                                  final String method) {
        // 获取 memberValues
        Map<String, Object> memberValues = getAnnotationMap(annotation);

        // 修改 value 属性值
        Object object = memberValues.get(method);
        return ObjectUtil.objectToString(object);
    }

    /**
     * 获取对应的注解属性 map
     * https://segmentfault.com/a/1190000011213222?utm_source=tag-newest
     * @param annotation 直接
     * @return map
     * @since 0.1.31
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> getAnnotationMap(final Annotation annotation) {
        try {
            //获取 annotation 这个代理实例所持有的 InvocationHandler
            InvocationHandler h = Proxy.getInvocationHandler(annotation);
            // 获取 AnnotationInvocationHandler 的 memberValues 字段
            Field hField = h.getClass().getDeclaredField("memberValues");
            // 因为这个字段事 private final 修饰，所以要打开权限
            hField.setAccessible(true);

            // 获取 memberValues
            return (Map<String, Object>) hField.get(h);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前字段被指定注解标注的注解
     * @param annotation 注解
     * @param annotationClass 标注注解类型
     * @return 注解信息
     */
    public static Optional<Annotation> getAnnotation(final Annotation annotation,
                                                     final Class<? extends Annotation> annotationClass) {
        if(ObjectUtil.isNull(annotation)
            || ObjectUtil.isNull(annotationClass)) {
            return Optional.empty();
        }

        Annotation atAnnotation = annotation.annotationType().getAnnotation(annotationClass);
        if (ObjectUtil.isNotNull(atAnnotation)) {
            return Optional.of(atAnnotation);
        }

        return Optional.empty();
    }

}
