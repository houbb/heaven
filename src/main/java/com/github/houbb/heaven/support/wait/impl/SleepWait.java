package com.github.houbb.heaven.support.wait.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.support.wait.IWait;

import java.util.concurrent.TimeUnit;

/**
 * 沉睡等待
 * @author binbin.hou
 * @since 0.1.8
 */
@ThreadSafe
@Deprecated
public class SleepWait implements IWait {

    @Override
    public void waits(long time, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CommonRuntimeException(e);
        }
    }

}
