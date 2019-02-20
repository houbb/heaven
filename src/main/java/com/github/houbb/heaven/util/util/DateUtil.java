/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author bbhou
 * @since 0.0.1
 */
public final class DateUtil {

    private DateUtil(){}

    /**
     * 日期格式化
     */
    public static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * 时间戳格式化
     * 17位长度
     */
    public static final String TIMESTAMP_FORMAT_17 = "yyyyMMddHHmmssSSS";

    /**
     * 简单的时间格式化
     */
    public static final String SIMPLE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 获取日期当前字符串形式
     * @return  dateStr
     */
    public static String getCurrentDateStr() {
        Date now = new Date();
        return new SimpleDateFormat(DATE_FORMAT).format(now);
    }

    /**
     * 获取当前时间戳。
     * @return  dateStr
     */
    public static String getCurrentTimeStampStr() {
        Date now = new Date();
        return new SimpleDateFormat(TIMESTAMP_FORMAT_17).format(now);
    }

    /**
     * 获取当前时间
     * eg:  2017-11-14 16:40:52.135
     * @return dateStr
     */
    public static String getSimpleDateStr() {
        Date now = new Date();
        return new SimpleDateFormat(SIMPLE_TIME_FORMAT).format(now);
    }

}
