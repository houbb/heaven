/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射方法工具类
 *
 * @since 0.0.2
 * @author bbhou
 */
public final class ReflectMethodUtil {

    private ReflectMethodUtil() {}

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

}
