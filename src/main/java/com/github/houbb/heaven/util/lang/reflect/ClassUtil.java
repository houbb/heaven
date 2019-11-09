/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.support.filter.IFilter;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.MapUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Class 工具类
 *
 * @since 0.0.1
 * @author bbhou
 */
public final class ClassUtil {

    private ClassUtil() {}

    /**
     * 序列版本编号常量
     * @since 0.1.35
     */
    public static final String SERIAL_VERSION_UID = "serialVersionUID";

    /**
     * 获取对应类的默认变量名：
     * 1. 首字母小写
     * String=》string
     * @param className 类名称
     * @return 类的默认变量名
     */
    public static String getClassVar(final String className) {
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

    /**
     * 获取类所有的字段信息
     * ps: 这个方法有个问题 如果子类和父类有相同的字段 会不会重复
     * 1. 还会获取到 serialVersionUID 这个字段。
     * @param clazz 类
     * @return 字段列表
     */
    public static List<Field> getAllFieldList(final Class clazz) {
        List<Field> fieldList = new ArrayList<>() ;
        Class tempClass = clazz;
        while (tempClass != null) {
            fieldList.addAll(Guavas.newArrayList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }

        for(Field field : fieldList) {
            field.setAccessible(true);
        }
        return fieldList;
    }

    /**
     * 获取可变更的字段信息
     * （1）过滤掉 final 的字段信息
     * @param clazz 类信息
     * @return 0.1.35
     */
    public static List<Field> getModifyableFieldList(final Class clazz) {
        List<Field> allFieldList = getAllFieldList(clazz);
        if(CollectionUtil.isEmpty(allFieldList)) {
            return allFieldList;
        }

        // 过滤掉 final 的字段
        return CollectionUtil.filterList(allFieldList, new IFilter<Field>() {
            @Override
            public boolean filter(Field field) {
                return Modifier.isFinal(field.getModifiers());
            }
        });
    }

    /**
     * 获取类所有的字段信息 map
     * ps: 这个方法有个问题 如果子类和父类有相同的字段 会不会重复
     * 1. 还会获取到 serialVersionUID 这个字段。
     * @param clazz 类
     * @return 字段列表 map
     */
    public static Map<String, Field> getAllFieldLMap(final Class clazz) {
        List<Field> fieldList = ClassUtil.getAllFieldList(clazz);
        return MapUtil.toMap(fieldList, new IHandler<Field, String>() {
            @Override
            public String handle(Field field) {
                return field.getName();
            }
        });
    }


    /**
     * bean 转换为 map
     * @param bean 原始对象
     * @return 结果
     */
    public static Map<String, Object> beanToMap(Object bean) {
        try {
            Map<String, Object> map = new LinkedHashMap<>();
            List<Field> fieldList = ClassUtil.getAllFieldList(bean.getClass());

            for (Field field : fieldList) {
                final String fieldName = field.getName();
                final Object fieldValue = field.get(bean);
                map.put(fieldName, fieldValue);
            }
            return map;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取对象的实例化
     * @param clazz 类
     * @param <T> 泛型
     * @return 实例化对象
     */
    public static <T> T newInstance(final Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取所有字段的 read 方法列表
     * @param clazz 类信息
     * @throws IntrospectionException if any
     * @return 方法列表
     * @since 0.0.7
     */
    public static List<Method> getAllFieldsReadMethods(final Class clazz) throws IntrospectionException {
        List<Field> fieldList = getAllFieldList(clazz);
        if(CollectionUtil.isEmpty(fieldList)) {
            return Collections.emptyList();
        }

        List<Method> methods = new ArrayList<>();
        for(Field field : fieldList) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            //获得get方法
            Method getMethod = pd.getReadMethod();
            methods.add(getMethod);
        }
        return methods;
    }

    /**
     * 获取当前的 class loader
     * @return 当前的 class loader
     * @since 0.1.38
     */
    public static ClassLoader currentClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取类信息
     * @since 0.1.38
     */
    public static Class getClass(final String className) {
        ArgUtil.notEmpty(className, "className");

        try {
            return currentClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
