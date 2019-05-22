package com.github.houbb.heaven.support.proxy.dynamic;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.proxy.IProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理基础类
 * @author binbin.hou
 * @since 0.1.3
 */
@ThreadSafe
public class BaseDynamicProxy implements InvocationHandler, IProxy {

    /**
     * 被代理的对象
     */
    private final Object target;

    public BaseDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object proxy() {
        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new BaseDynamicProxy(target);

        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代码处理
        return method.invoke(proxy, args);
    }

}
