package com.github.houbb.heaven.util.time.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.util.time.Time;

/**
 * 时间工具类
 * @author binbin.hou
 * @since 0.0.7
 */
public final class Times {

    private Times(){}

    /**
     * 默认的时间策略
     * @return 时间策略
     * @since 0.1.163
     */
    public static Time defaults() {
        return DefaultSystemTime.getInstance();
    }

    /**
     * 基于调度的时间策略
     * @return 时间策略
     * @since 0.1.163
     */
    public static Time scheduled() {
        return new ScheduledSystemTime();
    }

    /**
     * 获取系统时间
     * @return 时间
     * @since 0.1.37
     */
    public static long systemTime() {
        return DefaultSystemTime.getInstance().time();
    }

    /**
     * 获取基于调度的系统时间
     * @return 时间
     * @since 0.1.163
     */
    public static long scheduledSystemTime() {
        return Instances.singleton(ScheduledSystemTime.class).time();
    }

}
