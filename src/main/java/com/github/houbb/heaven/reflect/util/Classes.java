package com.github.houbb.heaven.reflect.util;

import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.reflect.exception.ReflectRuntimeException;
import com.github.houbb.heaven.reflect.handler.SimpleFieldHandler;
import com.github.houbb.heaven.support.cache.impl.ClassFieldListCache;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 类工具类
 * 不同于 jdk 自带的模块，专门用来处理自定义反射模块相关的类。
 *
 * 注意：这里类似于在 java 的基础上又封装了一层，性能多少会打折扣。
 * @author binbin.hou
 * @since 0.1.5
 */
public final class Classes {

    private Classes(){}

    /**
     * 获取所有的字段信息
     * @param clazz 类
     * @return iField 信息列表
     */
    public static List<IField> getFields(final Class clazz) {
        ArgUtil.notNull(clazz, "clazz");

        List<Field> fieldList = ClassFieldListCache.getInstance().get(clazz);
        List<IField> resultList = Guavas.newArrayList(fieldList.size());

        final SimpleFieldHandler handler = new SimpleFieldHandler();
        for(Field field : fieldList) {
            IField result = handler.handle(field);
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 初始化字段值
     * @param target 目标对象
     * @param fieldList 字段列表
     */
    public static void initFieldValue(final Object target,
                                final List<IField> fieldList) {
        if(CollectionUtil.isNotEmpty(fieldList)) {
            try {
                for(IField field : fieldList) {
                    final Object value = field.field().get(target);
                    field.value(value);
                }
            } catch (IllegalAccessException e) {
                throw new ReflectRuntimeException(e);
            }
        }
    }

}
