package com.github.houbb.heaven.util.util.regex;

import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.regex.Pattern;

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
     * 标点符号正则
     * @since 0.1.68
     */
    private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("\\p{P}");

    /**
     * emoji 表情正则表达式
     * https://github.com/zly394/EmojiRegex
     * https://github.com/vdurmont/emoji-java
     * @since 0.1.68
     */
    private static final Pattern EMOJI_PATTERN = Pattern.compile("(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)");

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

    /**
     * 是否为表情符号
     * @param string  字符串
     * @return 是否
     * @since 0.1.68
     */
    public static boolean isEmoji(final String string) {
        return EMOJI_PATTERN.matcher(string).find();
    }

    /**
     * 是否为标点符号
     * 中文符号：参考：https://blog.csdn.net/ztf312/article/details/54310542
     * @param string 字符
     * @return 结果
     * @since 0.1.68
     */
    private static boolean isPunctuation(String string) {
        return PUNCTUATION_PATTERN.matcher(string).find();
    }

}
