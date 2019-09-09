/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.support.handler.IHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组基本类型工具类
 * @author houbinbin
 * @since 0.1.25
 */
public final class ArrayPrimitiveUtil {

    public static final int[] INT_EMPTY = new int[0];

    public static final short[] SHORT_EMPTY = new short[0];

    public static final long[] LONG_EMPTY = new long[0];

    public static final float[] FLOAT_EMPTY = new float[0];

    public static final double[] DOUBLE_EMPTY = new double[0];

    public static final char[] CHAR_EMPTY = new char[0];

    public static final byte[] BYTE_EMPTY = new byte[0];

    public static final boolean[] BOOLEAN_EMPTY = new boolean[0];

    private ArrayPrimitiveUtil() {
    }

    /**
     * int 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(int[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(int[] objects) {
        return !isEmpty(objects);
    }


    /**
     * boolean 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(boolean[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * boolean 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(boolean[] objects) {
        return !isEmpty(objects);
    }

    /**
     * char 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(char[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * char 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(char[] objects) {
        return !isEmpty(objects);
    }

    /**
     * byte 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(byte[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * byte 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(byte[] objects) {
        return !isEmpty(objects);
    }

    /**
     * long 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(long[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * long 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(long[] objects) {
        return !isEmpty(objects);
    }

    /**
     * float 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(float[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(float[] objects) {
        return !isEmpty(objects);
    }

    /**
     * double 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(double[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * double 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(double[] objects) {
        return !isEmpty(objects);
    }

    /**
     * short 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isEmpty(short[] objects) {
        return null == objects
                || objects.length <= 0;
    }

    /**
     * short 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     * @since 0.1.25
     */
    public static boolean isNotEmpty(short[] objects) {
        return !isEmpty(objects);
    }

    /**
     * boolean 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final boolean[] values, IHandler<? super Boolean, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(boolean value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * char 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final char[] values, IHandler<? super Character, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(char value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * byte 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final byte[] values, IHandler<? super Byte, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(byte value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * short 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final short[] values, IHandler<? super Short, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(short value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * int 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final int[] values, IHandler<? super Integer, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(int value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * float 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final float[] values, IHandler<? super Float, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(float value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * double 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final double[] values, IHandler<? super Double, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(double value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * long 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @return 结果列表
     * @since 0.1.25
     */
    public static <K> List<K> toList(final long[] values, IHandler<? super Long, K> keyFunction) {
        if (ArrayPrimitiveUtil.isEmpty(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>(values.length);
        for(long value : values) {
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

    /**
     * 返回 c 对应的下标
     * @param chars 原始字符
     * @param c 目标
     * @return 结果
     * @since 0.1.26
     */
    public static int indexOf(final char[] chars, final char c) {
        if(ArrayPrimitiveUtil.isEmpty(chars)) {
            return -1;
        }

        for(int i = 0; i < chars.length; i++) {
            char cs = chars[i];
            if(cs == c) {
                return i;
            }
        }
        return -1;
    }

}
