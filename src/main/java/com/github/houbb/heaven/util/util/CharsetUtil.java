package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * 字符集工具类
 * @author binbin.hou
 * @since 0.1.31
 */
public final class CharsetUtil {

    private CharsetUtil(){}

    /**
     * unicode 转中文
     * 分隔
     * @param unicode 编码
     * @return 中文
     * @since 0.1.31
     */
    private static String unicodeToZh(String unicode) {
        if(StringUtil.isEmpty(unicode)) {
           return null;
        }

        String[] strings = unicode.split("\\\\u");
        StringBuilder builder = new StringBuilder();
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strings.length; i++) {
            final char c = (char) Integer.valueOf(strings[i], 16).intValue();
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 中文转 unicode 编码
     * @param zh 中文字符串
     * @return 编码
     * @since 0.1.31
     */
    private static String zhToUnicode(String zh) {
        if(StringUtil.isEmpty(zh)) {
            return null;
        }

        char[] chars = zh.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append("\\u").append(Integer.toString(aChar, 16));
        }
        return builder.toString();
    }

}
