package com.github.houbb.heaven.reflect.meta.field.impl;

import com.github.houbb.heaven.reflect.meta.field.IFieldMeta;
import com.github.houbb.heaven.support.condition.ICondition;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectFieldUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectMethodUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 字段元数据工具类
 * <p> project: FieldMeta </p>
 * <p> create on 2019/11/9 23:08 </p>
 *
 * @author Administrator
 * @since 0.1.41
 */
public final class FieldMetas {

    private FieldMetas() {
    }

    /**
     * 构建字段元数据列表
     *
     * @param clazz 类信息
     * @param instance 实例对象
     * @return 结果列表
     * @since 0.1.41
     */
    public static List<IFieldMeta> buildFieldsMetaList(final Class clazz,
                                                       final Object instance) {
        ArgUtil.notNull(clazz, "clazz");

        final List<Field> fieldList = ClassUtil.getModifyableFieldList(clazz);
        return buildFieldsMetaList(fieldList, instance);
    }

    /**
     * 构建字段元数据列表
     *
     * @param clazz 类信息
     * @return 结果列表
     * @since 0.1.41
     */
    public static List<IFieldMeta> buildFieldsMetaList(final Class clazz) {
        return buildFieldsMetaList(clazz, null);
    }

    /**
     * 构建方法元数据列表
     *
     * @param clazz 类信息
     * @param instance 实例对象
     * @return 结果列表
     * @since 0.1.41
     */
    public static List<IFieldMeta> buildMethodsMetaList(final Class clazz,
                                                        final Object instance) {
        ArgUtil.notNull(clazz, "clazz");

        List<Method> methodList = ClassUtil.getMethodList(clazz);
        return buildMethodsMetaList(methodList, instance);
    }

    /**
     * 构建方法元数据列表
     *
     * @param clazz 类信息
     * @return 结果列表
     * @since 0.1.41
     */
    public static List<IFieldMeta> buildMethodsMetaList(final Class clazz) {
        return buildMethodsMetaList(clazz, null);
    }

    /**
     * 构建字段元数据列表
     *
     * @param fieldList 字段列表
     * @param instance 实例信息
     * @return 结果列表
     * @since 0.1.41
     */
    private static List<IFieldMeta> buildFieldsMetaList(final List<Field> fieldList,
                                                       final Object instance) {
        return CollectionUtil.toList(fieldList, new IHandler<Field, IFieldMeta>() {
            @Override
            public IFieldMeta handle(Field field) {
                IFieldMeta fieldMeta = new FieldMeta();
                fieldMeta.setName(field.getName());
                fieldMeta.setType(field.getType());
                fieldMeta.setField(field);
                fieldMeta.setComponentType(ReflectFieldUtil.getComponentType(field));

                // 设置字段的值
                if(ObjectUtil.isNotNull(instance)) {
                    fieldMeta.setValue(ReflectFieldUtil.getValue(field, instance));
                }
                return fieldMeta;
            }
        });
    }

    /**
     * 构建字段元数据列表
     * （1）只处理 get 开头的方法
     * （2）只处理无参方法
     * （3）排除 getClass 方法
     *
     * @param methodList 方法列表
     * @param instance 实例信息
     * @return 结果列表
     * @since 0.1.41
     */
    private static List<IFieldMeta> buildMethodsMetaList(final List<Method> methodList,
                                                        final Object instance) {
        //1. 方法级别的过滤，只获取以 get 开头的方法
        List<Method> getMethodList = CollectionUtil.conditionList(methodList, new ICondition<Method>() {
            @Override
            public boolean condition(Method method) {
                // 无参的 get 方法，且不等于 getClass
                final String methodName = method.getName();
                Class[] paramTypes = method.getParameterTypes();
                return methodName.startsWith("get") && ArrayUtil.isEmpty(paramTypes)
                        && !"getClass".equals(methodName);
            }
        });

        return CollectionUtil.toList(getMethodList, new IHandler<Method, IFieldMeta>() {
            @Override
            public IFieldMeta handle(Method method) {
                final String methodName = method.getName();
                String fieldName = StringUtil.firstToLowerCase(methodName.substring(3));
                FieldMeta fieldMeta = new FieldMeta();
                fieldMeta.setName(fieldName);
                fieldMeta.setType(method.getReturnType());
                fieldMeta.setComponentType(ReflectMethodUtil.getGenericReturnParamType(method, 0));

                if(ObjectUtil.isNotNull(instance)) {
                    final Object value = ReflectMethodUtil.invoke(instance, method, new Object[]{});
                    fieldMeta.setValue(value);
                }
                return fieldMeta;
            }
        });
    }

}
