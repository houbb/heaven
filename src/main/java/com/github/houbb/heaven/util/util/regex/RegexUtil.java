package com.github.houbb.heaven.util.util.regex;

import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * 正则表达式工具类
 * @author binbin.hou
 * @since 0.1.17
 */
public final class RegexUtil {

    private RegexUtil(){}

    /**
     * 特殊字符
     */
    private static final String[] SPECIAL_CHARS = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };

    /**
     * 对特殊字符转移
     * @param keyword 特殊字符
     * @return 结果
     */
    public static String escapeWord(String keyword) {
        if (StringUtil.isNotBlank(keyword)) {
            for (String key : SPECIAL_CHARS) {
                if (keyword.contains(key)) {
                    keyword = keyword.replace(key, "\\" + key);
                }
            }
        }
        return keyword;
    }

}
