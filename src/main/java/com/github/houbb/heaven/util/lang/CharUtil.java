package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.List;

/**
 * 字符工具类
 * @author binbin.hou
 * @since 0.1.16
 */
public final class CharUtil {

    private CharUtil(){}

    /**
     * 是否为空
     * @param character 字符
     * @return 是否
     */
    public static boolean isEmpty(final Character character) {
        return character == null;
    }

    /**
     * 是否不为空
     * @param character 字符
     * @return 是否
     */
    public static boolean isNotEmpty(final Character character) {
        return !isEmpty(character);
    }

    /**
     * 重复多次
     * @param unit 单元信息
     * @param times 次数
     * @return 结果
     */
    public static String repeat(final char unit, final int times) {
        String component = String.valueOf(unit);
        return StringUtil.repeat(component, times);
    }

}
