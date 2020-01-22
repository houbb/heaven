/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期工具类
 * @author bbhou
 * @since 0.0.1
 */
public final class DateUtil {

    private DateUtil(){}

    /**
     * 纯净日期格式化
     * @since 0.1.12
     */
    public static final String PURE_DATE_FORMAT = "yyyyMMdd";

    /**
     * 日期格式化
     * @since 0.1.12
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 纯净时间格式化
     * @since 0.1.12
     */
    public static final String PURE_TIME_FORMAT = "HHmmss";

    /**
     * 时间格式化
     * @since 0.1.12
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 简单的日期时间格式化
     * @since 0.1.12
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 时间戳格式化
     * 17位长度
     */
    public static final String TIMESTAMP_FORMAT_17 = "yyyyMMddHHmmssSSS";

    /**
     * 时间戳格式化(15 位长度)
     * 备注：因为 2019 最前面两位，在自己的有生之年，基本是不变的。
     * @since 0.1.12
     */
    public static final String TIMESTAMP_FORMAT_15 = "yyMMddHHmmssSSS";

    /**
     * 获取格式化的日期
     * @param date 日期
     * @param format 格式化
     * @return 格式化后日期信息
     * @since 0.1.12
     */
    public static String getDateFormat(final Date date, final String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 对字符串格式化为日期
     * @param dateStr 日期字符串
     * @param format 格式化
     * @return 格式化后日期信息
     * @since 0.1.12
     */
    public static Date getFormatDate(final String dateStr, final String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            throw new CommonRuntimeException(e);
        }
    }

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
     * 获取当前日期时间字符串
     * @return 日期时间字符串
     * @since 0.1.75
     */
    public static String getCurrentDateTimeStr() {
        Date now = new Date();
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(now);
    }

    /**
     * 毫秒转化为纳秒
     * 1. 如果时间格式小于0，则视为0
     * @param ms 毫秒
     * @return 纳秒
     * @since 0.0.7 on 2019-5-13 15:02:43
     */
    public static long convertMsToNs(long ms) {
        return TimeUnit.NANOSECONDS.convert(ms > 0 ? ms : 0, TimeUnit.MILLISECONDS);
    }

    /**
     * 返回当前时间
     * @return 当前时间
     * @since 0.1.2
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 计算消耗的毫秒
     * @param start 开始时间
     * @param end 结束时间
     * @return 结果
     * @since 0.1.2
     */
    public static long costTimeInMills(final Date start, final Date end) {
        return end.getTime() - start.getTime();
    }

}
