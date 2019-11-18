package com.github.houbb.heaven.util.io;

import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 流工具类
 *
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
        try (ByteArrayOutputStream boa = new ByteArrayOutputStream()) {
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
     * @param is 流。注意：这里并不会关闭输入流，需要外部自行处理。
     * @return 字符串
     */
    public static String toString(InputStream is) {
        return toString(is, CharsetConst.UTF8);
    }

    /**
     * 获取文件对应输入流
     *
     * @param filePath 文件路径
     * @return 输入流
     * @since 0.1.44
     */
    public static InputStream getInputStream(final String filePath) {
        InputStream inputStream;
        try {
            inputStream = new URL(filePath).openStream();
        } catch (MalformedURLException localMalformedURLException) {
            try {
                inputStream = new FileInputStream(filePath);
            } catch (Exception localException2) {
                ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
                if (localClassLoader == null) {
                    localClassLoader = StreamUtil.class.getClassLoader();
                }
                inputStream = localClassLoader.getResourceAsStream(filePath);
                if (inputStream == null) {
                    throw new CommonRuntimeException("Could not find file: " + filePath);
                }
            }
        } catch (IOException localIOException1) {
            throw new CommonRuntimeException(localIOException1);
        }

        return inputStream;
    }

    /**
     * 关闭流
     * @param closeable 可关闭的信息
     * @since 0.1.44
     */
    public static void closeStream(final Closeable closeable) {
        if(ObjectUtil.isNotNull(closeable)) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new CommonRuntimeException(e);
            }
        }
    }

}
