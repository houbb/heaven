package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.util.util.ArrayPrimitiveUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.Optional;

/**
 * 数字工具类
 * @author binbin.hou
 * @since 0.1.16
 */
public final class NumUtil {

    private NumUtil(){}


    /**
     * 16 进制数组
     * @since 0.1.26
     */
    public static final char[] HEX_CHARS = "1234567890abcdefABCDEF".toCharArray();

    /**
     * 获取较小的结果
     * @param current 当前值
     * @param other 其他值
     * @return 较小的值
     */
    public static int getMin(final int current, final int other) {
        return current > other ? other : current;
    }

    /**
     * 获取较大的结果
     * @param current 当前值
     * @param other 其他值
     * @return 较大的值
     */
    public static int getMax(final int current, final int other) {
        return current > other ? current : other;
    }

    /**
     * 转为 int
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Integer> toInteger(final String string) {
        if(StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Integer integer = Integer.valueOf(string);
            return Optional.of(integer);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 转为 Long
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Long> toLong(final String string) {
        if(StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Long aLong = Long.valueOf(string);
            return Optional.of(aLong);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 转为 Double
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Double> toDouble(final String string) {
        if(StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Double aDouble = Double.valueOf(string);
            return Optional.of(aDouble);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 是否为 16 进制信息
     * @param string 结果
     * @return 是否
     */
    public static boolean isHex(final String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }
        char[] chars = string.toCharArray();
        for(char c : chars) {
            if(ArrayPrimitiveUtil.indexOf(HEX_CHARS, c) < 0) {
                return false;
            }
        }
        return true;
    }

}
