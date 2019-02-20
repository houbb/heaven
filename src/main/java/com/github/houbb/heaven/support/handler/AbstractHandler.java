/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.support.handler;

import com.github.houbb.heaven.util.lang.ObjectUtil;

/**
 * 抽象处理器
 * @author binbin.hou
 * @since 0.0.1
 */
public abstract class AbstractHandler<T, R> implements IHandler<T, R> {

    @Override
    public R handle(T t) {
        if(ObjectUtil.isNull(t)) {
            return null;
        }

        return this.doHandle(t);
    }

    /**
     * 执行操作
     * @param target 原始对象
     * @return 结果
     */
    protected abstract R doHandle(T target);

}
