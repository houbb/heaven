package com.github.houbb.heaven.util.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机工具类
 * @author binbin.hou
 * @since 0.1.12
 */
public final class RandomUtil {

    private RandomUtil(){}

    /** 用于随机选的数字 */
    private static final String BASE_NUMBER = "0123456789";

    /** 用于随机选的字符 */
    private static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";

    /** 用于随机选的字符和数字 */
    private static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;

    /**
     * 随机的字符
     * @param length 长度
     * @return 随机的数字
     */
    public static String randomChar(final int length) {
        return randomString(BASE_CHAR, length);
    }
    /**
     * 随机的字符数字
     * @param length 长度
     * @return 随机的数字
     */
    public static String randomCharNumber(final int length) {
        return randomString(BASE_CHAR_NUMBER, length);
    }

    /**
     * 随机的数字
     * @param length 长度
     * @return 随机的数字
     */
    public static String randomNumber(final int length) {
        return randomString(BASE_NUMBER, length);
    }

    /**
     * 获得一个随机的字符串
     *
     * @param baseString 随机字符选取的样本
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomString(String baseString, int length) {
        final StringBuilder sb = new StringBuilder();

        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int number = ThreadLocalRandom.current().nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }
}
