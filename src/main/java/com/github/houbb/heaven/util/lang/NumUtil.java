package com.github.houbb.heaven.util.lang;

/**
 * 数字工具类
 * @author binbin.hou
 * @since 0.1.16
 */
public final class NumUtil {

    private NumUtil(){}


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

}
