/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.util.*;

/**
 * Map 工具类
 * @since 0.0.1
 * @author bbhou
 */
public final class MapUtil {

    private MapUtil(){}

    /**
     * 判断map为空
     * @param map map
     * @return {@code true} 为空
     */
    public static boolean isEmpty(Map<?,?> map) {
        return null == map || 0 == map.size();
    }

    /**
     * 判断map为非空
     * @param map map
     * @return {@code true} 非空
     */
    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }

    /**
     * 可遍历的结合转换为 map
     * @param values 可遍历的元素 Iterator
     * @param keyFunction 转化方式
     * @param <K> key 泛型
     * @param <V> value 泛型
     * @return map 结果
     */
    public static  <K,V> Map<K,V> toMap(Iterable<V> values, IHandler<? super V, K> keyFunction) {
        if(ObjectUtil.isNull(values)) {
            return Collections.EMPTY_MAP;
        }
        return toMap(values.iterator(), keyFunction);
    }

    /**
     * 可遍历的结合转换为 map
     * @param values 可遍历的元素 Iterator
     * @param keyFunction 转化方式
     * @param <K> key 泛型
     * @param <V> value 泛型
     * @return map 结果
     */
    public static  <K,V> Map<K,V> toMap(Iterator<V> values, IHandler<? super V, K> keyFunction) {
        if(ObjectUtil.isNull(values)) {
            return Collections.EMPTY_MAP;
        }

        Map<K,V> map = new HashMap<>();

        while (values.hasNext()) {
            V value = values.next();
            final K key = keyFunction.handle(value);
            map.put(key, value);
        }
        return map;
    }

}
