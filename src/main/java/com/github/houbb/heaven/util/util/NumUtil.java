package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.util.codec.Base64;
import com.github.houbb.heaven.util.common.ArgUtil;

/**
 * 数字工具类
 *
 * @author binbin.hou
 * @since 0.1.162
 */
public final class NumUtil {

    private NumUtil(){}

    /**
     * 这里预留了足够的空位122位
     * private static final int FAST_SIZE = 'z';
     * 这个是为了存放字母对应的值，比如-对应63，但是-是45，也就是 digitsIndex[45]=63
     * [digitsChar[-]会自动转变成45，这样子十六进制转十进制，就可以获取到前面的数字了。
     */
    private static final int[] DIGITS_INDEX = new int[128];

    static {
        for (int i = 0; i < 64; i++) {
            DIGITS_INDEX[Base64.ALPHABET[i]] = i;
        }
    }

    //获取对应的的64进制的值
    private static int getIndex(String s, int pos) {
        char c = s.charAt(pos);
        return DIGITS_INDEX[c];
    }

    /**
     * 64进制转十进制
     * @param s 字符串
     * @return 数字
     * @since 0.1.162
     */
    public static long num64To10(String s) {
        long result = 0L;
        long multiplier = 1;
        for (int pos = s.length() - 1; pos >= 0; pos--) {
            int index = getIndex(s, pos);
            result += index * multiplier;
            multiplier *= 64;
        }
        return result;
    }

    /**
     * 十进制转64进制
     * @param number 数字
     * @return 结果
     * @since 0.1.162
     */
    public static String num10To64(long number) {
        ArgUtil.notNegative(number, "number");

        if(number == 0) {
            return "0";
        }

        StringBuilder buf = new StringBuilder();
        while (number != 0) {
            //获取余数
            int remain = (int) (number % 64);
            char c = Base64.ALPHABET[remain];
            buf.append(c);

            //剩下的值
            number /= 64;
        }

        //因为是从最后开始读的，所以这里要反转
        return buf.reverse().toString();
    }

}
