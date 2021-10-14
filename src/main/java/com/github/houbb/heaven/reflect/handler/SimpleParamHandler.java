package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleMethod;
import com.github.houbb.heaven.reflect.simple.SimpleParam;
import com.github.houbb.heaven.support.handler.IHandler;

import java.lang.reflect.Method;

/**
 * 参数处理类
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleParamHandler implements IHandler<Class, SimpleParam> {

    @Override
    public SimpleParam handle(Class aClass) {
        return null;
    }

}
