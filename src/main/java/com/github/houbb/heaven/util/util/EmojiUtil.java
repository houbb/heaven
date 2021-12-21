package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * 表情工具类
 * @author binbin.hou
 * @since 0.1.151
 */
public final class EmojiUtil {

    private EmojiUtil(){}

    /**
     * 替换掉 emoji 表情
     * @param text 文本
     * @param replaceText 替换的文本
     * @return 结果
     * @since 0.1.151
     */
    public static String replaceEmoji(final String text, final String replaceText) {
        if(StringUtil.isEmpty(text)) {
            return text;
        }

        return text.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", replaceText);
    }

    /**
     * 替换掉 emoji 表情
     * @param text 文本
     * @return 结果
     * @since 0.1.151
     */
    public static String replaceEmoji(final String text) {
        return replaceEmoji(text, "");
    }

}
