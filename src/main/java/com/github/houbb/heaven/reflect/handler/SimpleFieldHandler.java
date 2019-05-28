package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleClass;
import com.github.houbb.heaven.reflect.simple.SimpleField;
import com.github.houbb.heaven.support.handler.IHandler;

import java.lang.reflect.Field;

/**
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleFieldHandler implements IHandler<Field, SimpleField> {

    @Override
    public SimpleField handle(Field field) {
        return null;
    }
}
