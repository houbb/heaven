package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleField;
import com.github.houbb.heaven.reflect.simple.SimpleMethod;
import com.github.houbb.heaven.support.handler.IHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleMethodHandler implements IHandler<Method, SimpleMethod> {

    @Override
    public SimpleMethod handle(Method method) {
        return null;
    }
}
