/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射构造器工具类
 *
 * @author bbhou
 * @since 0.0.2
 */
public final class ReflectConstructorUtil {

    private ReflectConstructorUtil() {
    }

    /**
     * 根据构造器初始化对象实例
     * @param constructor 构造器
     * @param args 参数
     * @param <T> 泛型
     * @return 结果
     * @since 0.1.39
     */
    public static <T> T newInstance(final Constructor<T> constructor,
                             final Object... args) {
        ArgUtil.notNull(constructor, "constructor");

        try {
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
