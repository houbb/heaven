/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.MapUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Object 工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class ObjectUtil {

    private ObjectUtil() {
    }

    /**
     * 判断两个对象是否为同一对象
     * instanceof
     * isInstance
     * isAssignableFrom
     *
     * 注意：任何一个元素为 null，则认为是不同类型。
     * @param one 第一个元素
     * @param two 第二个元素
     * @return 是否为同一对象
     */
    public static boolean isSameType(Object one, Object two) {
        if(ObjectUtil.isNull(one)
            || ObjectUtil.isNull(two)) {
            return false;
        }
        Class clazzOne = one.getClass();

        return clazzOne.isInstance(two);
    }

    /**
     * 不是同一个类型
     *
     * @param one 第一个元素
     * @param two 第二个元素
     * @return 是否为不同对象
     */
    public static boolean isNotSameType(Object one, Object two) {
        return !isSameType(one, two);
    }


    /**
     * 判断当前对象是否为空
     * - 对象为空
     * - 空字符串
     * - 空集合/map
     * - 空数组
     * - 自定义空类型
     *
     * @param object 对象
     * @return 是否为空
     */
    public static boolean isNull(Object object) {
        return null == object;
    }

    /**
     * 判断对象是否非null
     *
     * @param object 元素
     * @return {@code true} 非空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 判断内容是否为空
     * - 空字符串
     * - 空集合/map
     * - 空数组
     * - 自定义空类型
     *
     * @param object 对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object object) {
        if (isNull(object)) {
            return true;
        }

        if (object instanceof String) {
            String string = (String) object;
            return StringUtil.isEmpty(string);
        }
        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            return CollectionUtil.isEmpty(collection);
        }
        if (object instanceof Map) {
            Map map = (Map) object;
            return MapUtil.isEmpty(map);
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }

        return false;
    }

    /**
     * 判断对象是否非空
     *
     * @param object 对象
     * @return 是否非空
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }


    /**
     * 判断两个对象是否相同
     * 1.如果不是同一种类型,则直接返回false
     *
     * @param except 期望值
     * @param real   实际值
     * @return 两个对象是否相同
     */
    public static boolean isEquals(Object except, Object real) {
        //1. 不是同一种类型
        if (isNotSameType(except, real)) {
            return false;
        }

        final Class exceptClass = except.getClass();
        final Class realClass = except.getClass();

        //2. 基本类型
        if (exceptClass.isPrimitive()
                && realClass.isPrimitive()
                && except != real) {
            return false;
        }

        //3. 数组
        if (ClassTypeUtil.isArray(exceptClass)
                && ClassTypeUtil.isArray(realClass)) {
            Object[] exceptArray = (Object[]) except;
            Object[] realArray = (Object[]) real;
            return Arrays.equals(exceptArray, realArray);
        }

        //3. Collection

        //4. map
        if (ClassTypeUtil.isMap(exceptClass) && ClassTypeUtil.isMap(realClass)) {
            Map exceptMap = (Map) except;
            Map realMap = (Map) real;
            return exceptMap.equals(realMap);
        }

        return except.equals(real);
    }

    /**
     * 判断两个对象是否不相同
     * 1.如果不是同一种类型,则返回true
     *
     * @param except 期望值
     * @param real   实际值
     * @return 两个对象是否不同
     */
    public static boolean isNotEquals(Object except, Object real) {
        return !isEquals(except, real);
    }

    /**
     * 对象转字符串
     * @param object 对象
     * @return 结果
     * @since 0.1.18
     */
    public static String objectToString(final Object object) {
        return objectToString(object, null);
    }

    /**
     * 对象转字符串
     * @param object 对象
     * @param defaultValue 默认值，原始对象为 null 时返回。
     * @return 结果
     * @since 0.1.18
     */
    public static String objectToString(final Object object,
                                        final String defaultValue) {
        if(ObjectUtil.isNull(object)) {
            return defaultValue;
        }
        return object.toString();
    }

    /**
     * 判断所有参数皆为null
     * @param object 对象
     * @param others 其他参数
     * @return 是否都为空
     * @since 0.1.29
     * @see #isNull(Object) 增强版本
     */
    public static boolean isNull(final Object object, final Object... others) {
        if(ObjectUtil.isNull(object)) {
            // 其他列表不为空，则遍历
            if(ArrayUtil.isNotEmpty(others)) {
                for(Object other : others) {
                    if(ObjectUtil.isNotNull(other)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

}
