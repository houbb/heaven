package com.github.houbb.heaven.util.lang;

/**
 * 布尔值工具类
 * @author binbin.hou
 * @since 0.1.14
 */
public final class BoolUtil {

    private BoolUtil(){}

    /**
     * 获取对应的bool值
     *
     * @param boolStr 布尔字符串
     * @return 是否
     */
    public static boolean getBool(String boolStr) {
        if ("YES".equals(boolStr)) {
            return true;
        }
        if ("Y".equals(boolStr)) {
            return true;
        }
        if("1".equals(boolStr)) {
            return true;
        }
        if("true".equals(boolStr)) {
            return true;
        }
        if("是".equals(boolStr)) {
            return true;
        }

        return false;
    }

}
