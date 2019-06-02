package com.github.houbb.heaven.support.wait.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.wait.IWait;

import java.util.concurrent.TimeUnit;

/**
 * 不进行任何等待
 * @author binbin.hou
 * @since 0.1.8
 */
@ThreadSafe
public class NoWait implements IWait {

    @Override
    public void wait(long time, TimeUnit timeUnit) {

    }
    
}
