/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 基本类型工具类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class PrimitiveUtil {

    /**
     * @since 0.1.7
     */
    private PrimitiveUtil(){}

    /**
     * 类型集合
     */
    private static final Map<Class<?>, Class<?>> TYPE_MAP = new IdentityHashMap<>(8);

    /**
     * 基本类型引用类型集合
     * @since 0.0.3
     */
    private static final Map<Class, Class> PRIMITIVE_REFERENCE_MAP = new HashMap<>();

    /**
     * 基本类型-默认值集合
     * boolean false
     * char \u0000(null)
     * byte (byte)0
     * short (short)0
     * int 0
     * long 0L
     * float 0.0f
     * double 0.0d
     * @since 0.1.37
     */
    private static final Map<Class, Object> PRIMITIVE_DEFAULT_MAP = new HashMap<>();

    static {
        /**
         * @since 0.0.3
         */
        PRIMITIVE_REFERENCE_MAP.put(int.class, Integer.class);
        PRIMITIVE_REFERENCE_MAP.put(boolean.class, Boolean.class);
        PRIMITIVE_REFERENCE_MAP.put(byte.class, Byte.class);
        PRIMITIVE_REFERENCE_MAP.put(char.class, Character.class);
        PRIMITIVE_REFERENCE_MAP.put(short.class, Short.class);
        PRIMITIVE_REFERENCE_MAP.put(long.class, Long.class);
        PRIMITIVE_REFERENCE_MAP.put(float.class, Float.class);
        PRIMITIVE_REFERENCE_MAP.put(double.class, Double.class);
        PRIMITIVE_REFERENCE_MAP.put(void.class, Void.class);

        TYPE_MAP.put(Boolean.class, Boolean.TYPE);
        TYPE_MAP.put(Byte.class, Byte.TYPE);
        TYPE_MAP.put(Character.class, Character.TYPE);
        TYPE_MAP.put(Double.class, Double.TYPE);
        TYPE_MAP.put(Float.class, Float.TYPE);
        TYPE_MAP.put(Integer.class, Integer.TYPE);
        TYPE_MAP.put(Long.class, Long.TYPE);
        TYPE_MAP.put(Short.class, Short.TYPE);

        PRIMITIVE_DEFAULT_MAP.put(int.class, 0);
        PRIMITIVE_DEFAULT_MAP.put(boolean.class, false);
        PRIMITIVE_DEFAULT_MAP.put(byte.class, (byte)0);
        PRIMITIVE_DEFAULT_MAP.put(char.class, '\u0000');
        PRIMITIVE_DEFAULT_MAP.put(short.class, (short)0);
        PRIMITIVE_DEFAULT_MAP.put(long.class, 0L);
        PRIMITIVE_DEFAULT_MAP.put(float.class, 0.0f);
        PRIMITIVE_DEFAULT_MAP.put(double.class, 0.0d);
    }

    /**
     * 获取对应的基本类型
     * @param classType class 类型
     * @return 基本类型
     */
    public static Class<?> getPrimitiveType(final Class<?> classType) {
        return TYPE_MAP.get(classType);
    }

    /**
     * 获取基础类型的引用类型
     * @param clazz 基础类型
     * @return 引用类型
     * @since 0.0.3
     */
    public static Class getReferenceType(final Class clazz) {
        if(clazz.isPrimitive()) {
            return PRIMITIVE_REFERENCE_MAP.get(clazz);
        }
        return clazz;
    }

    /**
     * 获取默认值
     * （1）8大基本类型返回默认值，其他返回 null
     * @param clazz 类型
     * @return 结果
     * @since 0.1.37
     */
    public static Object getDefaultValue(final Class clazz) {
        return PRIMITIVE_DEFAULT_MAP.get(clazz);
    }

}
