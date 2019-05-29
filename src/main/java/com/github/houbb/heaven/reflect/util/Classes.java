package com.github.houbb.heaven.reflect.util;

import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.reflect.bean.FieldBean;
import com.github.houbb.heaven.reflect.handler.SimpleFieldHandler;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

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
     * @param object 类
     * @return iField 信息列表
     */
    public static List<IField> getFields(final Object object) {
        ArgUtil.notNull(object, "object");

        List<Field> fieldList = ClassUtil.getAllFieldList(object.getClass());
        List<IField> resultList = Guavas.newArrayList(fieldList.size());

        final SimpleFieldHandler handler = new SimpleFieldHandler();
        for(Field field : fieldList) {
            FieldBean bean = new FieldBean();
            bean.field(field).target(object);

            IField result = handler.handle(bean);
            resultList.add(result);
        }
        return resultList;
    }

}
