/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.support.handler.IHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 集合工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class CollectionUtil {

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
        Collection<R> rList = new ArrayList<>(targets.size());
        for(T t : targets) {
            R r = handler.handle(t);
            rList.add(r);
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
}
