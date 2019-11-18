package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.MapUtil;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Bean 工具类
 * @author binbin.hou
 * @since 0.1.44
 */
public final class BeanUtil {

    private BeanUtil(){}

    /**
     * bean 转换为 map
     * @param bean 原始对象
     * @return 结果
     * @since 0.1.44
     */
    public static Map<String, Object> beanToMap(Object bean) {
        ArgUtil.notNull(bean, "bean");

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
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * map 中的值设置到 bean 中
     * （1）map 为空，则直接返回
     * （2）map 中有对应的 key 且 value 不为空，则进行值的设置。
     * @param map map 信息
     * @param bean 原始对象
     * @since 0.1.44
     */
    public static void mapToBean(final Map<String, Object> map, final Object bean) {
        ArgUtil.notNull(bean, "bean");
        if(MapUtil.isEmpty(map)) {
            return;
        }

        try {
            List<Field> fieldList = ClassUtil.getAllFieldList(bean.getClass());

            for (Field field : fieldList) {
                final String fieldName = field.getName();
                final Object fieldValue = map.get(fieldName);

                if(ObjectUtil.isNotNull(fieldValue)) {
                    field.set(bean, fieldValue);
                }
            }
        } catch (IllegalAccessException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
