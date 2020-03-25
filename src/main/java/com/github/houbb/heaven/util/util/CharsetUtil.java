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
    public static String unicodeToZh(String unicode) {
        if(StringUtil.isEmpty(unicode)) {
           return null;
        }

        String[] strings = unicode.split("\\\\u");
        StringBuilder builder = new StringBuilder();
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strings.length; i++) {
            String code = strings[i];

            // 只考虑4个字符的部分
            String actualCode = code.substring(0, 4);
            final char c = (char) Integer.valueOf(actualCode, 16).intValue();
            builder.append(c);

            if(code.length() > 4) {
                // 如果有超过4个字母的部分，直接当做字符串处理掉
                builder.append(code.substring(4));
            }
        }
        return builder.toString();
    }

    /**
     * 中文转 unicode 编码
     * @param zh 中文字符串
     * @return 编码
     * @since 0.1.31
     */
    public static String zhToUnicode(String zh) {
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

    /**
     * 是否为中文字符
     * @param c char
     * @return 是否
     * @since 0.1.67
     */
    public static boolean isChinese(char c) {
        boolean result = false;
        // 汉字范围 \u4e00-\u9fa5 (中文)
        if (c >= 19968 && c <= 171941) {
            result = true;
        }
        return result;
    }

    /**
     * 是否包含中文
     * @param string 字符串
     * @return 是否
     * @since 0.1.67
     */
    public static boolean isContainsChinese(String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] chars = string.toCharArray();
        for(char c : chars) {
            if(isChinese(c)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否全是中文
     * @param string 字符串
     * @return 是否
     * @since 0.1.67
     */
    public static boolean isAllChinese(String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] chars = string.toCharArray();
        for(char c : chars) {
            if(!isChinese(c)) {
                return false;
            }
        }

        return true;
    }
    
}
