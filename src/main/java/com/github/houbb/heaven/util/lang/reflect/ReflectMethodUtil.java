/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 反射方法工具类
 *
 * @since 0.0.2
 * @author bbhou
 */
public final class ReflectMethodUtil {

    private ReflectMethodUtil() {}

    /**
     * 忽略的方法名称列表
     * （1）object 默认方法
     * （2）class 默认方法
     *
     * 可优化方案：
     * 将所有方法写死，放在列表中、
     * 缺点：占地方，无法动态更新。
     * @since 0.1.36
     */
    private static final List<String> IGNORE_METHOD_LIST;

    static {
        Set<String> methodNameSet = new HashSet<>(64);
        for(Method method : Object.class.getMethods()) {
            methodNameSet.add(method.getName());
        }
        for(Method method : Class.class.getMethods()) {
            methodNameSet.add(method.getName());
        }
        IGNORE_METHOD_LIST = new ArrayList<>(methodNameSet);
    }

    /**
     * 获取忽略的方法列表
     * @return 忽略方法名称列表
     * @since 0.1.36
     */
    public static List<String> getIgnoreMethodList() {
        return IGNORE_METHOD_LIST;
    }

    /**
     * 是否为应该忽略的方法名称
     * @param methodName 方法名称
     * @return 是否
     * @since 0.1.36
     */
    public static boolean isIgnoreMethod(final String methodName) {
        return getIgnoreMethodList().contains(methodName);
    }

    /**
     * 获取方法类型的名称
     * @param method 方法反射信息
     * @return 参数列表
     * @since 0.1.36
     */
    public static List<String> getParamTypeNames(final Method method) {
        ArgUtil.notNull(method, "method");

        Class<?>[] paramTypes = method.getParameterTypes();

        return ArrayUtil.toList(paramTypes, new IHandler<Class<?>, String>() {
            @Override
            public String handle(Class<?> aClass) {
                return aClass.getName();
            }
        });
    }

    /**
     * 获取方法返回值的泛型
     * @param method 方法
     * @param index 泛型的下标
     * @return 返回类型的泛型
     */
    public static Class getReturnGenericType(final Method method, final int index) {
        Type returnType = method.getGenericReturnType();
        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            return (Class) typeArguments[index];
        }
        return null;
    }

    /**
     * 获取参数的泛型
     * @param method 方法
     * @param paramIndex 方法的下标
     * @param genericIndex 泛型的下标
     * @return 对应的类型
     */
    public static Class getParamGenericType(final Method method,
                                            final int paramIndex,
                                            final int genericIndex) {
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Type genericParameterType = genericParameterTypes[paramIndex];
        if(genericParameterType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericParameterType;
            Type[] parameterArgTypes = aType.getActualTypeArguments();
            return (Class) parameterArgTypes[genericIndex];
        }
        return null;
    }

    /**
     * 获取指定注解的方法
     * @param tClass 类信息
     * @param annotationClass 注解信息
     * @return 方法的 optional 信息
     * @since 0.1.38
     */
    public static Optional<Method> getMethodOptional(final Class tClass, final Class<? extends Annotation> annotationClass) {
        final Method[] methods = tClass.getMethods();

        if(ArrayUtil.isEmpty(methods)) {
            return Optional.empty();
        }
        for(Method method : methods) {
            if(method.isAnnotationPresent(annotationClass)) {
                return Optional.of(method);
            }
        }
        return Optional.empty();
    }

    /**
     * 执行反射调用
     * @param instance 对象实例
     * @param method 方法实例
     * @param args 参数信息
     * @return 调用结果
     * @since 0.1.38
     */
    public Object invoke(final Object instance, final Method method, Object... args) {
        ArgUtil.notNull(instance, "instance");
        ArgUtil.notNull(method, "method");

        try {
            return method.invoke(instance, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
