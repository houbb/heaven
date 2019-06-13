package com.github.houbb.heaven.util.guava;

import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.*;

/**
 * guava 工具类
 * 1. 只采用很少的集合创建
 * @author binbin.hou
 * @since 0.1.5
 */
public final class Guavas {

    private Guavas(){}

    /**
     * 新建数组链表
     * @param <E> 元素
     * @return 链表
     */
    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 新建数组链表
     * @param <E> 元素
     * @param size 大小
     * @return 链表
     */
    public static <E> List<E> newArrayList(final int size) {
        return new ArrayList<>(size);
    }

    /**
     * 新建数组链表
     * @param <E> 元素
     * @param elems 元素数组
     * @return 链表
     */
    public static <E> List<E> newArrayList(E ... elems) {
        List<E> list = Guavas.newArrayList(elems.length);
        list.addAll(Arrays.asList(elems));
        return list;
    }

    /**
     * 新建 hash Map
     * @param <K> key
     * @param <V> value
     * @return hash Map
     */
    public static <K,V> Map<K,V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 新建 hash Map
     * @param <K> key
     * @param <V> value
     * @param size 大小
     * @return hash Map
     */
    public static <K,V> Map<K,V> newHashMap(final int size) {
        return new HashMap<>(size);
    }

    /**
     * 新建 hash set
     * @param <E> 元素
     * @return 链表
     */
    public static <E> Set<E> newHashSet() {
        return new HashSet<>();
    }

    /**
     * 新建 hash set
     * @param <E> 元素
     * @param size 大小
     * @return 链表
     */
    public static  <E> Set<E> newHashSet(final int size) {
        return new HashSet<>(size);
    }

}
