package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleAnnotation;
import com.github.houbb.heaven.reflect.simple.SimpleClass;
import com.github.houbb.heaven.support.handler.IHandler;

import java.lang.annotation.Annotation;

/**
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleClassHandler implements IHandler<Class, SimpleClass> {

    @Override
    public SimpleClass handle(Class aClass) {
        return null;
    }

}
