package com.github.houbb.heaven.util.secrect;

import com.github.houbb.heaven.util.codec.Base64;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 加密算法
 * @author binbin.hou
 * @since 0.1.5
 */
public final class Md5Util {

    private Md5Util(){}

    /**
     * 获取字符串的 md5 值
     * @param string 字符串
     * @param charset 编码
     * @return md5
     */
    public static String md5(final String string, Charset charset) {
        try {
            if(StringUtil.isEmpty(string)) {
                return string;
            }

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] output = messageDigest.digest(string.getBytes(charset));

            //将得到的字节数组变成字符串返回
            return Base64.encodeToString(output);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取字符串的 md5 值
     * @param string 字符串
     * @return md5
     */
    public static String md5(final String string) {
        return md5(string, StandardCharsets.UTF_8);
    }

}
