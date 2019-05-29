package com.github.houbb.heaven.util.guava;

import java.util.*;

/**
 * guava 工具类
 * 1. 只采用很少的集合创建
 * @author binbin.hou
 * @since 0.1.5
 */
public final class Guavas {

    private Guavas(){}

    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> List<E> newArrayList(final int size) {
        return new ArrayList<>(size);
    }

    public static <K,V> Map<K,V> newHashMap() {
        return new HashMap<>();
    }

    public static <K,V> Map<K,V> newHashMap(final int size) {
        return new HashMap<>(size);
    }

    public static <E> Set<E> newHashSet() {
        return new HashSet<>();
    }

    public static  <E> Set<E> newHashSet(final int size) {
        return new HashSet<>(size);
    }

}
