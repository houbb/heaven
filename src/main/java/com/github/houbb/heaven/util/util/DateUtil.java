/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
     * 时间戳格式化
     * 14位长度
     */
    public static final String TIMESTAMP_FORMAT_14 = "yyyyMMddHHmmss";

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
        if(ObjectUtil.isNull(date)) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式化为 17 位时间戳
     * @param date 日期
     * @return  时间戳
     * @since 0.1.127
     */
    public static String getDateFormat17(final Date date) {
        return getDateFormat(date, TIMESTAMP_FORMAT_17);
    }

    /**
     * 格式化为 14 位时间戳
     * @param date 日期
     * @return  时间戳
     * @since 0.1.127
     */
    public static String getDateFormat14(final Date date) {
        return getDateFormat(date, TIMESTAMP_FORMAT_14);
    }

    /**
     * 对字符串格式化为日期
     * @param dateStr 日期字符串
     * @param format 格式化
     * @return 格式化后日期信息
     * @since 0.1.12
     */
    public static Date getFormatDate(final String dateStr, final String format) {
        if(StringUtil.isEmptyTrim(dateStr)) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 对字符串格式化为日期
     * @param dateStr 日期字符串
     * @return 格式化后日期信息
     * @since 0.1.127
     */
    public static Date getFormatDate17(final String dateStr) {
        return getFormatDate(dateStr, TIMESTAMP_FORMAT_17);
    }

    /**
     * 对字符串格式化为日期
     * @param dateStr 日期字符串
     * @return 格式化后日期信息
     * @since 0.1.127
     */
    public static Date getFormatDate14(final String dateStr) {
        return getFormatDate(dateStr, TIMESTAMP_FORMAT_14);
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
     * 获取当前时间戳。
     * @since 0.1.127
     * @return 时间戳
     */
    public static String getCurrentTime17() {
        Date now = new Date();
        return new SimpleDateFormat(TIMESTAMP_FORMAT_17).format(now);
    }

    /**
     * 获取当前时间戳。
     * @since 0.1.127
     * @return 时间戳
     */
    public static String getCurrentTime14() {
        Date now = new Date();
        return new SimpleDateFormat(TIMESTAMP_FORMAT_14).format(now);
    }

    /**
     * 获取当前时间戳。
     * @return  dateStr
     * @since 0.1.104
     */
    public static String getCurrentTimeStampStr15() {
        Date now = new Date();
        return new SimpleDateFormat(TIMESTAMP_FORMAT_15).format(now);
    }

    /**
     * 当前的毫秒数
     * @return 毫秒数
     * @since 0.1.104
     */
    public static String getCurrentTimeMills() {
        return String.valueOf(System.currentTimeMillis());
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

    /**
     * 当前线程主动沉睡
     * @param pauseMills 暂定的毫秒数
     * @since 0.1.104
     */
    public static void sleep(final long pauseMills) {
        sleep(TimeUnit.MILLISECONDS, pauseMills);
    }

    /**
     * 当前线程主动沉睡
     * @param unit 时间单位
     * @param timeout 超时时间
     * @since 0.1.104
     */
    public static void sleep(final TimeUnit unit,
                             final long timeout) {
        if(timeout <= 0) {
            return;
        }

        try {
            unit.sleep(timeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 从 sql 转化为 date
     * @param date 日期
     * @return 结果
     * @since 0.1.122
     */
    public static Date fromSql(java.sql.Date date) {
        if(null == date) {
            return null;
        }

        return new Date(date.getTime());
    }

    /**
     * 从 date 转化为 sql date
     * @param date 日期
     * @return 结果
     * @since 0.1.122
     */
    public static java.sql.Date toSqlDate(Date date) {
        if(null == date) {
            return null;
        }

        return new java.sql.Date(date.getTime());
    }

    /**
     * 从 date 转化为 sql date
     * @param date 日期
     * @return 结果
     * @since 0.1.122
     */
    public static java.sql.Time toSqlTime(Date date) {
        if(null == date) {
            return null;
        }

        return new java.sql.Time(date.getTime());
    }

    /**
     * 从 date 转化为 sql date
     * @param date 日期
     * @return 结果
     * @since 0.1.122
     */
    public static java.sql.Timestamp toSqlTimestamp(Date date) {
        if(null == date) {
            return null;
        }

        return new java.sql.Timestamp(date.getTime());
    }

    /**
     * 年份变更
     * @param date 日期
     * @param year 年份
     * @return 时间
     * @since 0.1.127
     */
    public static Date addYear(final Date date, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一年，整数往后推，负数往前移
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 秒变更
     * @param date 日期
     * @param second 秒
     * @return 时间
     * @since 0.1.127
     */
    public static Date addSecond(final Date date, int second) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一年，整数往后推，负数往前移
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

}
