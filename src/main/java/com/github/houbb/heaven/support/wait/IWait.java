package com.github.houbb.heaven.support.wait;

import java.util.concurrent.TimeUnit;

/**
 * 等待接口
 * @author binbin.hou
 * @since 0.1.8
 */
public interface IWait {

    /**
     * 等待时间
     * @param time 时间
     * @param timeUnit 单位
     */
    void waits(final long time, final TimeUnit timeUnit);

}
