package com.github.houbb.heaven.util.time;

import com.github.houbb.heaven.annotation.CommonEager;

/**
 * 时间工具类
 * （1）便于后期拓展，可以使用统一的时钟服务。
 * @author binbin.hou
 * @since 0.1.37
 */
public interface Time {

    /**
     * 获取当前时间
     * @return 当前时间
     * @since 0.0.6
     */
    long time();

}
