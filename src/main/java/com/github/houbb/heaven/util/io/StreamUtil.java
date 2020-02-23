package com.github.houbb.heaven.util.io;

import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
    @Deprecated
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
    @Deprecated
    public static String toString(InputStream is) {
        return toString(is, CharsetConst.UTF8);
    }

    /**
     * 获取文章内容
     * @param path 路径
     * @return 文件内容
     * @since 0.1.71
     */
    public static String getFileContent(final String path) {
        return getFileContent(path, CharsetConst.UTF8);
    }

    /**
     * 获取文章内容
     * @param path 路径
     * @param charset 字符集合
     * @return 文件内容
     * @since 0.1.71
     */
    public static String getFileContent(final String path,
                                 final String charset) {
        try (InputStream inputStream = getInputStream(path);
                ByteArrayOutputStream boa = new ByteArrayOutputStream()) {
            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = inputStream.read(buffer)) != -1) {
                boa.write(buffer, 0, len);
            }
            byte[] result = boa.toByteArray();
            return new String(result, charset);
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
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

    /**
     * 获取数据内容
     * 例如： /data.txt
     * @param path resource 下的文件路径
     * @return 返回数据集合
     * @since 0.1.67
     */
    public static List<String> readAllLines(final String path) {
        InputStream inputStream = StreamUtil.class.getResourceAsStream(path);
        return readAllLines(inputStream, CharsetConst.UTF8, true);
    }

    /**
     * 构建数据集合
     * @param is 文件输入流
     * @return 返回数据集合
     * @since 0.1.67
     */
    public static List<String> readAllLines(final InputStream is) {
        return readAllLines(is, CharsetConst.UTF8, true);
    }

    /**
     * 构建数据集合
     *
     * @param is 文件输入流
     * @param charset 文件编码
     * @param ignoreEmpty 是否忽略空白行
     * @return 返回数据集合
     * @since 0.1.67
     */
    public static List<String> readAllLines(InputStream is,
                                            final String charset,
                                            final boolean ignoreEmpty) {
        try {
            List<String> lines = new ArrayList<>();
            BufferedReader e = new BufferedReader(new InputStreamReader(is,
                    Charset.forName(charset)));

            while (e.ready()) {
                String entry = e.readLine();
                if (StringUtil.isEmpty(entry)
                        && ignoreEmpty) {
                    continue;
                }
                lines.add(entry);
            }
            return lines;
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 获取文件内容
     * @param path 路径
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     * @return 结果
     * @since 0.1.78
     */
    public static String getFileContent(final String path,
                                        final int startIndex,
                                        final int endIndex) {
        return getFileContent(path, startIndex, endIndex, StandardCharsets.UTF_8);
    }

    /**
     * 获取文件内容
     * @param path 路径
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     * @param charset 编码
     * @return 结果
     * @since 0.1.78
     */
    public static String getFileContent(final String path,
                                        final int startIndex,
                                        final int endIndex,
                                        final Charset charset) {
        try(InputStream inputStream = StreamUtil.class.getResourceAsStream(path)) {
            // 跳过指定长度
            inputStream.skip(startIndex);

            byte[] bytes = new byte[endIndex-startIndex];
            inputStream.read(bytes);

            return new String(bytes, charset);
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }
}
