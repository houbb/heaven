package com.github.houbb.heaven.util.secrect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * base64
 * @author binbin.hou
 * @since 0.1.5
 */
public final class Base64 {

    private Base64(){}

    /**
     * hex 数组
     */
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    /**
     * Base64 标准字符集合
     * @since 0.1.106
     */
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    /**
     * 编码信息
     * @since 0.1.106
     */
    private static final byte[] CODES = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            CODES[i] = -1;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            CODES[i] = (byte) (i - 'A');
        }
        for (int i = 'a'; i <= 'z'; i++) {
            CODES[i] = (byte) (26 + i - 'a');
        }
        for (int i = '0'; i <= '9'; i++) {
            CODES[i] = (byte) (52 + i - '0');
        }
        CODES['+'] = 62;
        CODES['/'] = 63;
    }

    /**
     * 将字节数组转换成十六进制，并以字符串的形式返回
     * 128位是指二进制位。二进制太长，所以一般都改写成16进制，
     * 每一位16进制数可以代替4位二进制数，所以128位二进制数写成16进制就变成了128/4=32位。
     * @param bytes 字节流
     * @return 字符串
     */
    public static String toBase64String(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(byteToHex(b));
        }
        return sb.toString();
    }

    /**
     * 将一个字节转换成十六进制，并以字符串的形式返回
     * @param b 比特
     */
    private static String byteToHex(byte b) {
        int n = b;
        if (n < 0) {
            n = n + 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;

        final String charOne = String.valueOf(HEX_ARRAY[d1]);
        final String charTwo = String.valueOf(HEX_ARRAY[d2]);
        return charOne+charTwo;
    }

    /**
     * 将原始数据编码为base64编码
     * @since 0.1.106
     */
    public static char[] encode(byte[] data) {
        char[] out = new char[((data.length + 2) / 3) * 4];

        for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
            boolean quad = false;
            boolean trip = false;
            int val = (0xFF & (int) data[i]);
            val <<= 8;
            if ((i + 1) < data.length) {
                val |= (0xFF & (int) data[i + 1]);
                trip = true;
            }
            val <<= 8;
            if ((i + 2) < data.length) {
                val |= (0xFF & (int) data[i + 2]);
                quad = true;
            }
            out[index + 3] = ALPHABET[(quad ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 2] = ALPHABET[(trip ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 1] = ALPHABET[val & 0x3F];
            val >>= 6;
            out[index] = ALPHABET[val & 0x3F];
        }

        return out;
    }

    /**
     * 将base64编码的数据解码成原始数据
     * @since 0.1.106
     */
    public static byte[] decode(char[] data)
    {
        int len = ((data.length + 3) / 4) * 3;
        if(data.length > 0 && data[data.length - 1] == '=') {
            --len;
        }
        if(data.length > 1 && data[data.length - 2] == '=') {
            --len;
        }
        byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;
        for (char aData : data) {
            int value = CODES[aData & 0xFF];
            if (value >= 0) {
                accum <<= 6;
                shift += 6;
                accum |= value;
                if (shift >= 8) {
                    shift -= 8;
                    out[index++] = (byte) ((accum >> shift) & 0xff);
                }
            }
        }
        if(index != out.length) {
            throw new CommonRuntimeException("miscalculated data length!");
        }
        return out;
    }

    /**
     * 编码
     * @param text 文本
     * @return 结果
     * @since 0.1.106
     */
    public static String encode(final String text) {
        if(StringUtil.isEmpty(text)) {
            return text;
        }
        return new String(encode(text.getBytes()));
    }

    /**
     * 解码
     * @param text 文本
     * @return 结果
     * @since 0.1.106
     */
    public static String decode(final String text) {
        if(StringUtil.isEmpty(text)) {
            return text;
        }
        return new String(decode(text.toCharArray()));
    }

}
