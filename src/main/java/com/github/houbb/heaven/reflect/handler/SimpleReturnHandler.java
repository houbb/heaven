package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleParam;
import com.github.houbb.heaven.reflect.simple.SimpleReturn;
import com.github.houbb.heaven.support.handler.IHandler;

/**
 * 返回值处理类
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleReturnHandler implements IHandler<Class, SimpleReturn> {

    @Override
    public SimpleReturn handle(Class aClass) {
        return null;
    }

}
