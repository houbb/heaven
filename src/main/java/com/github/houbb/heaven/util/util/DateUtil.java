/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
     * 日期格式化
     * @since 0.1.141
     */
    public static final String DATE_ZH_FORMAT = "yyyy年MM月dd日";

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
     * 时间格式化
     * @since 0.1.12
     */
    public static final String TIME_ZH_FORMAT = "HH时mm分ss秒";

    /**
     * 简单的日期时间格式化
     * @since 0.1.12
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 简单的日期时间格式化
     * @since 0.1.141
     */
    public static final String DATE_TIME_SEC_FORMAT = "yyyy-MM-dd HH:mm:ss";

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
     * 格式化日期
     * @param date 日期
     * @param format 格式化
     * @return 结果
     * @since 0.1.165
     */
    public static String formatDate(final Date date, final String format) {
        return getDateFormat(date, format);
    }


    /**
     * 对日期进行转换
     * @param string 字符串
     * @param format 格式
     * @return 结果
     * @since 0.1.65
     */
    public static Date parseDate(final String string, final String format) {
        return getFormatDate(string, format);
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
     * 获取日期当前字符串形式
     * @return  dateStr
     * @since 0.1.144
     */
    public static String getCurrentDatePureStr() {
        Date now = new Date();
        return new SimpleDateFormat(PURE_DATE_FORMAT).format(now);
    }

    /**
     * 获取日期当前字符串形式
     * @return  dateStr
     * @since 0.1.151
     */
    public static String getYesterdayPureStr() {
        Date now = new Date();
        Date yesterday = addDay(now, -1);
        return new SimpleDateFormat(PURE_DATE_FORMAT).format(yesterday);
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
     * 月份变更
     * @param date 日期
     * @param month 月份
     * @return 时间
     * @since 0.1.141
     */
    public static Date addMonth(final Date date, int month) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 日变更
     * @param date 日期
     * @param day 日
     * @return 时间
     * @since 0.1.141
     */
    public static Date addDay(final Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 分钟变更
     * @param date 日期
     * @param hour 时
     * @return 时间
     * @since 0.1.141
     */
    public static Date addHour(final Date date, int hour) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一年，整数往后推，负数往前移
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    /**
     * 分钟变更
     * @param date 日期
     * @param minute 分
     * @return 时间
     * @since 0.1.141
     */
    public static Date addMinute(final Date date, int minute) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一年，整数往后推，负数往前移
        calendar.add(Calendar.MINUTE, minute);
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

    /**
     * 获取当前日期
     * @return 获取当前日期
     * @since 0.1.152
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取日期的小时
     * @param date 日期
     * @return 结果
     * @since 0.1.152
     */
    public static Integer getDateHours(final Date date) {
        if(date == null) {
            return null;
        }

        return date.getHours();
    }

    /**
     * 获取当前日期的小时数
     * @return 小时
     * @since 0.1.152
     */
    public static int getCurrentDateHours() {
        Date now = getCurrentDate();

        return getDateHours(now);
    }

    /**
     * 是否为早晨
     * @return 是否
     * @since 0.1.152
     */
    public static boolean isAm() {
        int hours = getCurrentDateHours();

        if(0 <= hours && hours <= 12) {
            return true;
        }

        return  false;
    }

    /**
     * 是否为下午
     * @return 是否
     * @since 0.1.152
     */
    public static boolean isPm() {
        return !isAm();
    }

    /**
     * 日期缩短
     * 12.25
     * 3.25
     * @param yyyyMMddStr 原始格式
     * @return 格式化之后的
     * @since 0.1.165
     */
    public static String slimDate(String yyyyMMddStr) {
        Date date = getFormatDate(yyyyMMddStr, PURE_DATE_FORMAT);
        String slimDate = getDateFormat(date, "MM.dd");

        // 移除0
        if(slimDate.startsWith("0")) {
            return slimDate.substring(1);
        }
        return slimDate;
    }

    /**
     * 获取两个日期中的所有日期,并转换为表后缀
     *
     * @param begin 格式:yyyyMMdd
     * @param end   格式:yyyyMMdd
     * @return 格式: yyyyMMdd
     * @since 0.1.165
     */
    public static List<String> getDateRangeList(String begin, String end) {
        Date bDate = getFormatDate(begin, PURE_DATE_FORMAT);//yyyy-MM-dd
        Date eDate = getFormatDate(end, PURE_DATE_FORMAT);
        List<Date> dateList = getDateRangeList(bDate, eDate);//创建日期范围生成器

        List<String> resultList = new ArrayList<>(dateList.size());
        for (Date dt : dateList) {
            String dateStr = getDateFormat(dt, PURE_DATE_FORMAT);
            resultList.add(dateStr);
        }
        return resultList;
    }

    /**
     * 获取日期列表
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 结果
     * @since 0.1.165
     */
    public static List<Date> getDateRangeList(final Date startDate, final Date endDate) {
        ArgUtil.notNull(startDate, "startDate");
        ArgUtil.notNull(endDate, "endDate");

        List<Date> resultList = new ArrayList<>();
        if(startDate.compareTo(endDate) > 0) {
            return resultList;
        }

        // 添加第一个元素
        resultList.add(startDate);

        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            Date nowDate = addDay(startDate, i);

            if(nowDate.compareTo(endDate) <= 0) {
                resultList.add(nowDate);
            } else {
                break;
            }
        }

        return resultList;
    }

    /**
     * 获取差异的时间
     * @param date 日期
     * @param differ 差异
     * @return 结果
     * @since 0.1.165
     */
    public static String getDifferDate(Date date, int differ) {
        Date differDate = DateUtil.addDay(date, differ);

        return DateUtil.getDateFormat(differDate, DateUtil.PURE_DATE_FORMAT);
    }

    /**
     * 变化格式
     * @param dateOld 原始日期
     * @param oldFormat 原始格式
     * @param newFormat 新格式
     * @return 结果
     * @since 0.1.165
     */
    public static String changeFormat(final String dateOld, String oldFormat, String newFormat) {
        if(StringUtil.isEmpty(dateOld)) {
            return dateOld;
        }

        // 转换
        Date date = parseDate(dateOld, oldFormat);
        return formatDate(date, newFormat);
    }

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1 时间参数 1 yyyyMMdd
     * @param str2 时间参数 2 yyyyMMdd
     * @return 相差天数
     * @since 0.1.165
     */
    public static long getDistanceDays(String str1, String str2) {
        Date one = parseDate(str1, PURE_DATE_FORMAT);
        Date two = parseDate(str2, PURE_DATE_FORMAT);
        return getDistanceDays(one, two);
    }

    /**
     * 获取相差的天数
     * @param one 日期1
     * @param two 日期2
     * @return 结果
     * @since 0.1.165
     */
    public static long getDistanceDays(Date one, Date two) {
        long time1 = one.getTime();
        long time2 = two.getTime();
        long diff;

        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        return diff / (1000 * 60 * 60 * 24);
    }

    /**
     * 日历转日期
     *
     * @param calendar 日历
     * @return 结果
     * @since 0.2.0
     */
    public static Date toDate(Calendar calendar) {
        if(calendar == null) {
            return null;
        }

        return calendar.getTime();
    }

    /**
     * 对象转 Date
     * @param object 对象
     * @return 结果
     * @since 0.2.0
     */
    public static Date toDate(final Object object) {
        if(object == null) {
            return null;
        }

        if(object instanceof Date) {
            return (Date) object;
        }

        if(object instanceof Calendar) {
            Calendar calendar = (Calendar) object;
            return toDate(calendar);
        }

        // 不支持的类别转换
        throw new ClassCastException();
    }

}
