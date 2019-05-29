package com.github.houbb.heaven.reflect.bean;

import java.lang.reflect.Field;

/**
 * @author binbin.hou
 * @since 0.0.5
 */
public class FieldBean {

    private Field field;

    private Object target;

    public Field field() {
        return field;
    }

    public FieldBean field(Field field) {
        this.field = field;
        return this;
    }

    public Object target() {
        return target;
    }

    public FieldBean target(Object target) {
        this.target = target;
        return this;
    }
}
