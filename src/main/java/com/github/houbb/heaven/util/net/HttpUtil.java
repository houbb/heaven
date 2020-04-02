package com.github.houbb.heaven.util.net;

import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.util.MapUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HTTP 工具类
 * @author binbin.hou
 * @since 0.1.98
 */
public final class HttpUtil {

    private HttpUtil(){}

    /**
     * get 请求
     * @since 0.1.98
     */
    public static final String GET = "GET";

    /**
     * post 请求
     * @since 0.1.98
     */
    public static final String POST = "POST";

    /**
     * http get 请求
     * @param requestUrl 请求地址
     * @return 结果
     * @since 0.1.98
     */
    public static String getRequest(String requestUrl) {
        return request(requestUrl, GET);
    }

    /**
     * http post 请求
     * @param requestUrl 请求地址
     * @return 结果
     * @since 0.1.98
     */
    public static String postRequest(String requestUrl) {
        return request(requestUrl, POST);
    }

    /**
     * http 请求
     * @param requestUrl 请求地址
     * @param requestMethod 方法
     * @return 结果
     * @since 0.1.98
     */
    public static String request(String requestUrl, String requestMethod) {
        return request(requestUrl, requestMethod, CharsetConst.UTF8);
    }

    /**
     * http 请求
     * @param requestUrl 请求地址
     * @param requestMethod 方法
     * @param charset 流编码
     * @return 结果
     * @since 0.1.98
     */
    public static String request(String requestUrl, String requestMethod,
                                 final String charset) {
        StringBuilder buffer = new StringBuilder();
        try {
            URL url = new URL(requestUrl);
            // http协议传输
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if (GET.equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
            return buffer.toString();
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 构建文件头信息
     * @param filePath 文件路径
     * @return map 信息
     * @since 0.1.98
     */
    public static Map<String, String> buildHeaderMap(final String filePath) {
        List<String> stringList = FileUtil.readAllLines(filePath);

        Map<String, String> map = new HashMap<>(stringList.size());
        for (String line : stringList) {
            int index = line.indexOf(PunctuationConst.COLON);
            String key = line.substring(0, index).trim();
            String value = line.substring(index + 1).trim();
            map.put(key, value);
        }

        return map;
    }

    /**
     * 将远程的文件下载到本地
     * @param remoteUrl 远程的 url
     * @param localUrl 本地 url
     * @since 0.1.98
     */
    public static void download(final String remoteUrl,
                                final String localUrl) {
        download(remoteUrl, localUrl, null);
    }

    /**
     * 将远程的文件下载到本地
     * @param remoteUrl 远程的 url
     * @param localUrl 本地 url
     * @param headerMap 头信息 map
     * @since 0.1.98
     */
    public static void download(final String remoteUrl,
                                final String localUrl,
                                final Map<String, String> headerMap) {
        ArgUtil.notEmpty(remoteUrl, "remoteUrl");
        ArgUtil.notEmpty(localUrl, "localUrl");

        try {
            URL url = new URL(remoteUrl);
            URLConnection conn = url.openConnection();
            if(MapUtil.isNotEmpty(headerMap)) {
                for(Map.Entry<String, String> entry : headerMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    conn.setRequestProperty(key, value);
                }
            }

            try(DataInputStream dataInputStream = new DataInputStream(conn.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(localUrl))) {
                ByteArrayOutputStream output = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                fileOutputStream.write(output.toByteArray());
            }
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
