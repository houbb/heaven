package com.github.houbb.heaven.util.net;

import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> project: heaven-URLUtil </p>
 * <p> create on 2020/6/19 20:07 </p>
 *
 * @author binbin.hou
 * @since 0.1.108
 */
public final class URLUtil {

    private URLUtil(){}

    /**
     * 读取每一行的内容
     * @param url url 信息
     * @return 结果
     * @since 0.1.108
     */
    public static List<String> readAllLines(final URL url) {
        return readAllLines(url, CharsetConst.UTF8);
    }

    /**
     * 读取每一行的内容
     * @param url url 信息
     * @param charset 文件编码
     * @return 结果
     * @since 0.1.108
     */
    public static List<String> readAllLines(final URL url,
                                     final String charset) {
        ArgUtil.notNull(url, "url");
        ArgUtil.notEmpty(charset, "charset");

        List<String> resultList = new ArrayList<>();

        try(InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName(charset)))) {
            // 按行读取信息
            String line;
            while ((line = br.readLine()) != null) {
                resultList.add(line);
            }
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
        return resultList;
    }

}
