/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.support.condition.ICondition;
import com.github.houbb.heaven.support.filler.IFiller;
import com.github.houbb.heaven.support.filter.IFilter;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.*;

/**
 * 集合工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class CollectionUtil {

    /**
     * collection util
     */
    private CollectionUtil() {
    }

    /**
     * 空列表
     */
    public static final List EMPTY_LIST = Collections.emptyList();

    /**
     * 是否为空
     *
     * @param collection 集合
     * @return {@code true} 是
     */
    public static boolean isEmpty(Collection collection) {
        return null == collection
                || collection.isEmpty();    //更有可读性
    }

    /**
     * 是否不为空
     *
     * @param collection 集合
     * @return {@code true} 是
     * @since 1.1.2
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 根据数组返回对应列表
     *
     * @param array string array
     * @return string list
     */
    public static List<String> arrayToList(String[] array) {
        if (ArrayUtil.isEmpty(array)) {
            return Collections.emptyList();
        }
        return Arrays.asList(array);
    }


    /**
     * 列表转数组
     *
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
     *
     * @param targets 原始信息
     * @param handler 处理接口
     * @param <T>     入参
     * @param <R>     出参
     * @return 结果
     */
    public static <T, R> Collection<R> buildCollection(final Collection<T> targets, final IHandler<T, R> handler) {
        if (isEmpty(targets)) {
            return Collections.emptyList();
        }
        Collection<R> rList = new ArrayList<>();
        for (T t : targets) {
            R r = handler.handle(t);
            if (ObjectUtil.isNotNull(r)) {
                rList.add(r);
            }
        }
        return rList;
    }

    /**
     * 构建结果集合
     * 1. 如果转换的结果为 null，会被跳过。
     *
     * @param targets 原始信息
     * @param handler 处理接口
     * @param <T>     入参
     * @param <R>     出参
     * @return 结果
     * @since 0.0.2
     */
    public static <T, R> Collection<R> buildCollection(final T[] targets, final IHandler<T, R> handler) {
        if (ArrayUtil.isEmpty(targets)) {
            return Collections.emptyList();
        }
        Collection<R> rList = new ArrayList<>();
        for (T t : targets) {
            R r = handler.handle(t);
            if (ObjectUtil.isNotNull(r)) {
                rList.add(r);
            }
        }
        return rList;
    }

    /**
     * 将数组的内容添加到集合
     *
     * @param collection 集合
     * @param array      数组
     * @param <T>        泛型
     */
    public static <T> void addArray(final Collection<T> collection, final T[] array) {
        if (ArrayUtil.isEmpty(array)) {
            return;
        }

        collection.addAll(Arrays.asList(array));
    }

    /**
     * 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @param <V>         v 泛型
     * @return 结果列表
     */
    public static <K, V> List<K> toList(final Iterable<V> values, IHandler<? super V, K> keyFunction) {
        if (ObjectUtil.isNull(values)) {
            return Collections.emptyList();
        }
        return toList(values.iterator(), keyFunction);
    }

    /**
     * 可遍历的元素对象的某个元素，转换为列表
     *
     * @param values      遍历对象
     * @param keyFunction 转换方式
     * @param <K>         k 泛型
     * @param <V>         v 泛型
     * @return 结果列表
     */
    public static <K, V> List<K> toList(final Iterator<V> values, IHandler<? super V, K> keyFunction) {
        if (ObjectUtil.isNull(values)) {
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

    /**
     * 遍历填充对象
     *
     * @param values 遍历对象
     * @param filler 对象填充器
     * @param <E>    e 泛型
     * @return 返回类表
     * @since 0.1.10
     */
    public static <E> List<E> fillList(final List<E> values, IFiller<E> filler) {
        if (ObjectUtil.isNull(values)) {
            return values;
        }

        for (E e : values) {
            filler.fill(e);
        }

        return values;
    }


    /**
     * 按照任意空格拆分
     *
     * @param string 字符串
     * @return 拆分后的列表
     * @since 0.0.5
     */
    public static List<String> splitByAnyBlank(String string) {
        if (StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        } else {
            String pattern = "\\s+";
            String[] strings = string.split(pattern);
            return new ArrayList<>(Arrays.asList(strings));
        }
    }

    /**
     * 执行列表过滤
     *
     * @param list   原始列表
     * @param filter 过滤器
     * @param <T>    泛型
     * @return 过滤后的结果
     * @since 0.0.6
     */
    public static <T> List<T> filterList(final List<T> list, final IFilter<T> filter) {
        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (filter.filter(t)) {
                continue;
            }

            resultList.add(t);
        }
        return resultList;
    }

    /**
     * 执行列表过滤
     *
     * @param list      原始列表
     * @param condition 条件过滤器
     * @param <T>       泛型
     * @return 过滤后的结果
     * @since 0.0.6
     */
    public static <T> List<T> conditionList(final List<T> list, final ICondition<T> condition) {
        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (condition.condition(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    /**
     * 对象列表转换为 toString 列表
     * 1. 会跳过所有的 null 对象。
     * 2. 建议放在 collectUtil 下。
     *
     * @param pathList 原始对象
     * @return 结果
     * @since 0.0.6
     */
    public static List<String> toStringList(final List<?> pathList) {
        if (CollectionUtil.isEmpty(pathList)) {
            return Collections.emptyList();
        }

        List<String> stringList = new ArrayList<>(pathList.size());
        for (Object object : pathList) {
            if (ObjectUtil.isNotNull(object)) {
                stringList.add(object.toString());
            }
        }

        return stringList;
    }

    /**
     * 找到第一个不为 null 的元素
     *
     * @param list 列表
     * @param <T>  泛型
     * @return 不为 null 的元素
     * @since 0.1.6
     */
    public static <T> Optional<T> firstNotNullElem(List<T> list) {
        if (CollectionUtil.isEmpty(list)) {
            return Optional.empty();
        }

        for (T elem : list) {
            if (ObjectUtil.isNotNull(elem)) {
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }

    /**
     * 将 stringList 内容按照 connector 连接起来
     *
     * @param stringList 字符串列表
     * @param connector  连接符号
     * @return 结果
     * @since 0.1.6
     */
    public static String join(final List<String> stringList,
                              final String connector) {
        return StringUtil.join(stringList, connector);
    }

    /**
     * 循环处理集合
     *
     * @param collection 集合
     * @param handler    处理器
     * @param <E>        泛型元素
     * @since 0.1.8
     */
    public static <E> void foreach(final Collection<E> collection, IHandler<E, Void> handler) {
        if (CollectionUtil.isEmpty(collection)) {
            return;
        }

        for (E e : collection) {
            handler.handle(e);
        }
    }

    /**
     * 填充信息
     *
     * @param size 大小
     * @param elem 单个元素
     * @param <E>  泛型
     * @return 列表
     * @since 0.1.9
     */
    public static <E> List<E> fill(final int size,
                                   final E elem) {
        List<E> list = Guavas.newArrayList(size);

        for (int i = 0; i < size; i++) {
            list.add(elem);
        }
        return list;
    }

    /**
     * 获取第一个元素
     * 1. 避免 NPE
     *
     * @param list 列表
     * @param <E>  泛型
     * @return 结果
     * @since 0.1.10
     */
    public static <E> E getFirst(final List<E> list) {
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 去重集合
     *
     * @param <T>        集合元素类型
     * @param collection 集合
     * @return {@link ArrayList}
     * @since 0.1.13
     */
    public static <T> List<T> distinct(Collection<T> collection) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        } else if (collection instanceof Set) {
            return new ArrayList<>(collection);
        } else {
            return new ArrayList<>(new LinkedHashSet<>(collection));
        }
    }

    /**
     * 获取开始的下标
     * （1）默认为0
     * （2）如果为负数，或者超过 arrays.length-1，则使用 0
     * （3）正常返回 startIndex
     *
     * @param startIndex 开始下标
     * @param collection 集合信息
     * @return 尽可能安全的下标范围。如果为空，则返回 0;
     * @since 0.1.14
     */
    public static int getStartIndex(final int startIndex,
                                    final Collection<?> collection) {
        if (CollectionUtil.isEmpty(collection)) {
            return 0;
        }
        if (startIndex < 0
                || startIndex > collection.size() - 1) {
            return 0;
        }

        return startIndex;
    }

    /**
     * 获取开始的下标
     * （1）默认为0
     * （2）如果为负数，或者超过 arrays.length-1，则使用 arrays.length-1
     * （3）正常返回 endIndex
     *
     * @param endIndex   结束下标
     * @param collection 集合信息
     * @return 尽可能安全的下标范围。如果为空，则返回 0;
     * @since 0.1.14
     */
    public static int getEndIndex(final int endIndex,
                                  final Collection<?> collection) {
        if (CollectionUtil.isEmpty(collection)) {
            return 0;
        }
        final int maxIndex = collection.size() - 1;
        if (endIndex < 0
                || endIndex > maxIndex) {
            return maxIndex;
        }

        return endIndex;
    }

    /**
     * 集合的并集
     *
     * @param collectionOne 集合1
     * @param collectionTwo 集合2
     * @param <E>           泛型
     * @return 结果集合
     * @since 0.1.16
     */
    public static <E> List<E> union(final Collection<E> collectionOne,
                                          final Collection<E> collectionTwo) {
        Set<E> set = new LinkedHashSet<>();
        set.addAll(collectionOne);
        set.addAll(collectionTwo);
        return new ArrayList<>(set);
    }

    /**
     * 集合的差集
     *
     * @param collectionOne 集合1
     * @param collectionTwo 集合2
     * @param <E>           泛型
     * @return 结果集合
     * @since 0.1.16
     */
    public static <E> List<E> difference(final Collection<E> collectionOne,
                                               final Collection<E> collectionTwo) {
        Set<E> set = new LinkedHashSet<>();
        set.addAll(collectionOne);
        set.removeAll(collectionTwo);
        return new ArrayList<>(set);
    }

    /**
     * 集合的差交集
     *
     * @param collectionOne 集合1
     * @param collectionTwo 集合2
     * @param <E>           泛型
     * @return 结果集合
     * @since 0.1.16
     */
    public static <E> List<E> interSection(final Collection<E> collectionOne,
                                                 final Collection<E> collectionTwo) {
        Set<E> set = new LinkedHashSet<>();

        for (E e : collectionOne) {
            if (collectionTwo.contains(e)) {
                set.add(e);
            }
        }
        return new ArrayList<>(set);
    }

}
