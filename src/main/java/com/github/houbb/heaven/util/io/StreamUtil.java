package com.github.houbb.heaven.util.io;

import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 流工具类
 * @author binbin.hou
 * @since 0.1.1
 */
public class StreamUtil {

    private StreamUtil() {
    }

    /**
     * 流转换为字符
     *
     * @param is      流。注意：这里并不会关闭输入流，需要外部自行处理。
     * @param charset 编码集合
     * @return 字符串
     */
    public static String toString(InputStream is, String charset) {
        try(ByteArrayOutputStream boa = new ByteArrayOutputStream()){
            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = is.read(buffer)) != -1) {
                boa.write(buffer, 0, len);
            }
            byte[] result = boa.toByteArray();
            return new String(result, charset);
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 流转换为字符
     *
     * @param is      流。注意：这里并不会关闭输入流，需要外部自行处理。
     * @return 字符串
     */
    public static String toString(InputStream is) {
        return toString(is, CharsetConst.UTF8);
    }

}
