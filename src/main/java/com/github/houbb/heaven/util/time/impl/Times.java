package com.github.houbb.heaven.util.time.impl;

/**
 * 时间工具类
 * @author binbin.hou
 * @since 0.0.7
 */
public final class Times {

    private Times(){}

    /**
     * 获取系统时间
     * @return 时间
     * @since 0.1.37
     */
    public static long systemTime() {
        return DefaultSystemTime.getInstance().time();
    }

}
