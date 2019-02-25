/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.common;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.math.BigDecimal;

/**
 * 参数工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class ArgUtil {

    private ArgUtil() {
    }

    /**
     * 断言不为空
     *
     * @param object 对象
     * @param name   对象名称
     */
    public static void notNull(Object object, String name) {
        if (null == object) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }

    /**
     * 不可为空
     * @param object 对象
     * @param name 对象名称
     * @param errMsg 错误描述
     */
    public static void notNull(Object object, String name, String errMsg) {
        if(null == object) {
            String errorInfo = String.format("%s %s", name, errMsg);
            throw new IllegalArgumentException(errorInfo);
        }
    }

    /**
     * 校验字符串非空
     * @param string 待检查的字符串
     * @param name 字符串的名称
     */
    public static void notEmpty(String string, String name) {
        if(StringUtil.isEmpty(string)) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }

    /**
     * 断言: real 与 except 相等
     * @param except    期望值
     * @param real  实际值
     * @param msg   错误消息
     */
    public static void equals(Object except, Object real, String msg) {
        if(ObjectUtil.isNotEquals(except, real)) {
            String errorMsg = buildErrorMsg(except, real, msg);
            throw new IllegalArgumentException(errorMsg);
        }
    }


    /**
     * 指定长度是否等于某个值
     * 1.空值校验则认为长度为0；
     * 2.想对空值校验,请使用判断非空。
     * @param string 字符串
     * @param len 期望长度
     * @return  {@code true} 是
     */
    public static boolean isEqualsLen(String string, int len) {
        if(StringUtil.isEmpty(string)) {
            return 0 ==len;
        }

        return string.length() == len;
    }

    /**
     * 指定长度是否不等于某个值
     * @param string 字符串
     * @param len 期望长度
     * @return {@code true} 是
     */
    public static boolean isNotEqualsLen(String string, int len) {
        return !isEqualsLen(string, len);
    }

    /**
     * 字符串是否满足最大长度
     * 1. 认为 null 字段长度为 0
     * 2. 比较校验
     * @param string 字符串
     * @param maxLen 最大长度
     * @return {@code true} 是
     */
    public static boolean isFitMaxLen(String string, int maxLen) {
        if(StringUtil.isEmpty(string)) {
            return 0 <= maxLen;
        }
        return string.length() <= maxLen;
    }

    /**
     * 字符串是否不满足最大长度
     * @param string 字符串
     * @param maxLen 最大长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMaxLen(String string, int maxLen) {
        return !isFitMaxLen(string, maxLen);
    }


    /**
     * 满足最小长度
     * 1. 如果为 null，则认为长度为0
     * @param string 字符串
     * @param minLen 最小长度
     * @return {@code true} 是
     */
    public static boolean isFitMinLen(String string, int minLen) {
        if(StringUtil.isEmpty(string)) {
            return 0 >= minLen;
        }
        return string.length() >= minLen;
    }

    /**
     * 不满足最小长度
     * @param string 字符串
     * @param minLen 最小长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMinLen(String string, int minLen) {
        return !isFitMinLen(string, minLen);
    }

    /**
     * 校验字符串是否满足全是数字
     * 1. null 值通过
     * 2.
     * @param number 数字字符串
     * @return {@code true} 是
     */
    public static Boolean isNumber(String number) {
        if(ObjectUtil.isNotNull(number)) {
            try {
                new BigDecimal(number);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不是一个数字
     * @param number    数字字符串
     * @return  {@code true} 是
     */
    public static Boolean isNotNumber(String number) {
        return !isNumber(number);
    }


    /**
     * 字符串是否满足正则表达式。
     * @param string    字符串
     * @param regex 正则表达式
     * @return      {@code true} 是
     */
    public static Boolean isMatchesRegex(String string, String regex) {
        if(null != string) {
            return string.matches(regex);
        }
        return true;
    }

    /**
     * 字符串是否不满足正则表达式。
     * @param string    字符串
     * @param regex 正则表达式
     * @return      {@code true} 是
     */
    public static Boolean isNotMatchesRegex(String string, String regex) {
        return !isMatchesRegex(string, regex);
    }

    /**
     * 构建错误提示消息
     * @param except 期望值
     * @param real 实际值
     * @param msg 错误信息
     * @return  错误提示消息
     */
    private static String buildErrorMsg(Object except, Object real, String msg) {
        String resultMsg = msg;
        if(StringUtil.isEmpty(resultMsg)) {
            resultMsg = "与期望值不符合!";
        }
        return String.format("Except:<%s>, Real:<%s>, Msg:<%s>", except, real, resultMsg);
    }

}
