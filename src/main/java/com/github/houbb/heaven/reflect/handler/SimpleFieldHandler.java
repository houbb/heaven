package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.bean.FieldBean;
import com.github.houbb.heaven.reflect.exception.ReflectRumtionException;
import com.github.houbb.heaven.reflect.simple.SimpleClass;
import com.github.houbb.heaven.reflect.simple.SimpleField;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleFieldHandler implements IHandler<FieldBean, SimpleField> {

    @Override
    public SimpleField handle(FieldBean fieldBean) {
        try {
            final Field field = fieldBean.field();
            final Object target = fieldBean.target();

            SimpleField simpleField = new SimpleField();
            simpleField.name(field.getName());
            simpleField.fullName(field.getName());
            simpleField.type(field.getType());
            simpleField.annotations(Arrays.asList(field.getAnnotations()));
            simpleField.access(field.getModifiers());

            if(ObjectUtil.isNotNull(target)) {
                field.setAccessible(true);
                simpleField.value(field.get(target));
            }

            return simpleField;
        } catch (IllegalAccessException e) {
            throw new ReflectRumtionException(e);
        }
    }

}
