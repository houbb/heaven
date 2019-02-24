/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 基本类型工具类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class PrimitiveUtil {

    /**
     * 类型集合
     */
    private static final Map<Class<?>, Class<?>> TYPE_MAP = new IdentityHashMap<>(8);

    static {
        TYPE_MAP.put(Boolean.class, Boolean.TYPE);
        TYPE_MAP.put(Byte.class, Byte.TYPE);
        TYPE_MAP.put(Character.class, Character.TYPE);
        TYPE_MAP.put(Double.class, Double.TYPE);
        TYPE_MAP.put(Float.class, Float.TYPE);
        TYPE_MAP.put(Integer.class, Integer.TYPE);
        TYPE_MAP.put(Long.class, Long.TYPE);
        TYPE_MAP.put(Short.class, Short.TYPE);
    }

    /**
     * 获取对应的基本类型
     * @param classType class 类型
     * @return 基本类型
     */
    public static Class<?> getPrimitiveType(final Class<?> classType) {
        return TYPE_MAP.get(classType);
    }

}
