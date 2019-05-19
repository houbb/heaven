package com.github.houbb.heaven.util.net;

import com.github.houbb.heaven.constant.CharsetConst;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 编码工具类
 * @author binbin.hou
 * @since 0.1.1
 */
public class EncodeUtil {

    /**
     * 对内容进行 utf=8 编码
     * @param content 编码
     * @return 结果
     */
    public static String encode(final String content) {
        return encode(content, CharsetConst.UTF8);
    }

    /**
     * 对内容进行 utf=8 编码
     * @param content 编码
     * @param charset 字符编码
     * @return 结果
     */
    public static String encode(final String content, final String charset) {
        try {
            return URLEncoder.encode(content, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
