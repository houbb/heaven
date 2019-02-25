/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.util.*;

/**
 * 集合工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class CollectionUtil {

    /**    
     *  collection util    
     */    
    private CollectionUtil(){}

    /**
     * 空列表
     */
    public static final List EMPTY_LIST = Collections.emptyList();

    /**
     * 是否为空
     * @param collection    集合
     * @return {@code true} 是
     */
    public static boolean isEmpty(Collection collection) {
        return null == collection
                || collection.isEmpty();    //更有可读性
    }

    /**
     * 是否不为空
     * @param collection    集合
     * @return  {@code true} 是
     * @since 1.1.2
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 根据数组返回对应列表
     * @param array string array
     * @return string list
     */
    public static List<String> arrayToList(String[] array) {
        if(ArrayUtil.isEmpty(array)) {
            return Collections.emptyList();
        }
        return Arrays.asList(array);
    }


    /**
     * 列表转数组
     * @param stringList string list
     * @return string array
     */
    public static String[] listToArray(List<String> stringList) {
        String[] strings = new String[stringList.size()];
        return stringList.toArray(strings);
    }

    /**
     * 对字符串列表每条字符串执行trim()操作。
     * 1. 空直接返回空列表
     *
     * @param stringList 原始的列表
     * @return trim 的字符串列表
     */
    public static Collection<String> trimCollection(final Collection<String> stringList) {
        if (CollectionUtil.isEmpty(stringList)) {
            return Collections.emptyList();
        }

        Collection<String> resultList = new ArrayList<>();
        for (String original : stringList) {
            resultList.add(original.trim());
        }

        return resultList;
    }

    /**
     * 构建结果集合
     * 1. 如果转换的结果为 null，会被跳过。
     * @param targets 原始信息
     * @param handler 处理接口
     * @param <T> 入参
     * @param <R> 出参
     * @return 结果
     */
    public static <T, R> Collection<R> buildCollection(final Collection<T> targets, final IHandler<T, R> handler) {
        if(isEmpty(targets)) {
            return Collections.emptyList();
        }
        Collection<R> rList = new ArrayList<>();
        for(T t : targets) {
            R r = handler.handle(t);
            if(ObjectUtil.isNotNull(r)) {
                rList.add(r);
            }
        }
        return rList;
    }

    /**
     * 构建结果集合
     * 1. 如果转换的结果为 null，会被跳过。
     * @param targets 原始信息
     * @param handler 处理接口
     * @param <T> 入参
     * @param <R> 出参
     * @return 结果
     * @since 0.0.2
     */
    public static <T, R> Collection<R> buildCollection(final T[] targets, final IHandler<T, R> handler) {
        if(ArrayUtil.isEmpty(targets)) {
            return Collections.emptyList();
        }
        Collection<R> rList = new ArrayList<>();
        for(T t : targets) {
            R r = handler.handle(t);
            if(ObjectUtil.isNotNull(r)) {
                rList.add(r);
            }
        }
        return rList;
    }

    /**
     * 将数组的内容添加到集合
     * @param collection 集合
     * @param array 数组
     * @param <T> 泛型
     */
    public static <T> void addArray(final Collection<T> collection, final T[] array) {
        if(ArrayUtil.isEmpty(array)) {
            return;
        }

        collection.addAll(Arrays.asList(array));
    }

    /**
     * 可遍历的元素对象的某个元素，转换为列表
     * @param values 遍历对象
     * @param keyFunction 转换方式
     * @param <K> k 泛型
     * @param <V> v 泛型
     * @return 结果列表
     */
    public static <K, V> List<K> toList(final Iterable<V> values, IHandler<? super V, K> keyFunction) {
        if(ObjectUtil.isNull(values)) {
            return Collections.emptyList();
        }
        return toList(values.iterator(), keyFunction);
    }

    /**
     * 可遍历的元素对象的某个元素，转换为列表
     * @param values 遍历对象
     * @param keyFunction 转换方式
     * @param <K> k 泛型
     * @param <V> v 泛型
     * @return 结果列表
     */
    public static  <K,V> List<K> toList(Iterator<V> values, IHandler<? super V, K> keyFunction) {
        if(ObjectUtil.isNull(values)) {
            return Collections.emptyList();
        }

        List<K> list = new ArrayList<>();
        while (values.hasNext()) {
            V value = values.next();
            final K key = keyFunction.handle(value);
            list.add(key);
        }
        return list;
    }

}
