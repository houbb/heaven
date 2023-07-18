package com.github.houbb.heaven.util.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * spi 工具类
 * @since 0.2.10
 */
public final class SpiUtil {

    private SpiUtil(){}

    /**
     * 通过 spi 获取类实现列表
     * @param tClass 类
     * @param <T> 泛型
     * @since 0.2.10
     * @return 结果列表
     */
    public static <T> List<T> getClassImplList(Class<T> tClass) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        return getClassImplList(tClass, classLoader);
    }

    /**
     * 通过 spi 获取类实现列表
     * @param tClass 类
     * @param classLoader 类加载器
     * @param <T> 泛型
     * @since 0.2.10
     * @return 结果列表
     */
    public static <T> List<T> getClassImplList(Class<T> tClass,
                                               final ClassLoader classLoader) {
        List<T> resultList = new ArrayList<>();
        ServiceLoader<T> loader = ServiceLoader.load(tClass, classLoader);

        for (T t : loader) {
            resultList.add(t);
        }

        return resultList;
    }

}
