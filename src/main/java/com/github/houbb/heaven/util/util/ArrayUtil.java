/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组工具类
 * @author houbinbin
 * @since 0.0.1
 */
public final class ArrayUtil {

    private ArrayUtil() {
    }

    /**
     * 数组是否为空
     *
     * @param objects 数组对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] objects) {
        if (null == objects
                || objects.length <= 0) {
            return true;
        }

        return false;
    }

    /**
     * 数组是否不为空
     *
     * @param objects 数组对象
     * @return 是否为空
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * 数组转换为列表
     *
     * @param objects 数组
     * @return 列表
     */
    public static List<Object> toList(final Object[] objects) {
        if (ArrayUtil.isEmpty(objects)) {
            return Collections.emptyList();
        }

        List<Object> objectList = new ArrayList<>(objects.length);
        objectList.addAll(Arrays.asList(objects));
        return objectList;
    }

    /**
     * 转换为数组
     * @param objectList 集合
     * @return 对象数组
     */
    public static Object[] toArray(final List<?> objectList) {
        if (CollectionUtil.isEmpty(objectList)) {
            return new Object[0];
        }

        Object[] objects = new Object[objectList.size()];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = objectList.get(i);
        }
        return objects;
    }

    /**
     * 是否包含数据
     * @param array 数组信息
     * @param objectToFind 待发现的对象
     * @return 是否包含
     * @since 0.0.1
     */
    public static boolean contains(Object[] array, Object objectToFind) {
        return indexOf(array, objectToFind) != -1;
    }

    /**
     * 是否不包含数据
     * @param array 数组信息
     * @param objectToFind 待发现的对象
     * @return 是否不包含
     * @since 0.0.1
     */
    public static boolean notContains(Object[] array, Object objectToFind) {
        return !contains(array, objectToFind);
    }

    /**
     * 查询对应元素的下标
     * @param array 数组信息
     * @param objectToFind 待发现的对象
     * @return 下标
     * @since 0.0.1
     */
    public static int indexOf(Object[] array, Object objectToFind) {
        return indexOf(array, objectToFind, 0);
    }

    /**
     * 查询对应元素的下标
     * @param array 数组信息
     * @param objectToFind 待发现的对象
     * @param startIndex 开始下标
     * @return 下标
     * @since 0.0.1
     */
    public static int indexOf(Object[] array, Object objectToFind, int startIndex) {
        if (array == null) {
            return -1;
        } else {
            if (startIndex < 0) {
                startIndex = 0;
            }

            int i;
            if (objectToFind == null) {
                for (i = startIndex; i < array.length; ++i) {
                    if (array[i] == null) {
                        return i;
                    }
                }
            } else if (array.getClass().getComponentType().isInstance(objectToFind)) {
                for (i = startIndex; i < array.length; ++i) {
                    if (objectToFind.equals(array[i])) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }

}
