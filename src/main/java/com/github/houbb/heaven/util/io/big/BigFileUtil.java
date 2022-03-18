package com.github.houbb.heaven.util.io.big;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 大文件工具类
 *
 * @author binbin.hou
 * @since 0.1.159
 */
public final class BigFileUtil {

    private BigFileUtil(){}

    /**
     * 读取
     * @param filePath 文件路径
     * @since 0.1.159
     */
    public static void read(String filePath) {
        read(filePath, new BigFileStringHandlerPrint());
    }

    /**
     * 读取
     * @param filePath 文件路径
     * @param handler 处理类
     * @since 0.1.159
     */
    public static void read(String filePath,
                            IBigFileStringHandler handler) {
        read(filePath, handler, "UTF-8");
    }

    /**
     * 读取
     * @param filePath 文件路径
     * @param handler 处理类
     * @param charsetName 编码
     * @since 0.1.159
     */
    public static void read(final String filePath,
                            final IBigFileStringHandler handler,
                            final String charsetName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(new File(filePath),"r");
            String s ;
            // 这里默认的编码是ISO-8859-1
            int index = 0;
            BigFileStringHandlerContext context = new BigFileStringHandlerContext();
            context.setFilePath(filePath);
            context.setCharset(charsetName);
            while((s =raf.readLine())!=null){
                byte[] bytes = s.getBytes("ISO-8859-1");
                String line = new String(bytes, charsetName);

                context.setIndex(index);
                context.setLine(line);
                context.setFilePointer(raf.getFilePointer());

                handler.handle(context);
                index++;
            }
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件内容切分
     * @param filePath 文件路径
     * @since 0.1.159
     */
    public static void segFile(final String filePath) {
        segFile(filePath, 100_000);
    }

    /**
     * 文件内容切分
     * @param filePath 文件路径
     * @param limitSize 文件大小
     * @since 0.1.159
     */
    public static void segFile(final String filePath,
                               final int limitSize) {
        segFile(filePath, limitSize, "UTF-8");
    }

    /**
     * 文件内容切分
     * @param filePath 文件路径
     * @param limitSize 文件大小
     * @param charsetName 文件编码
     * @since 0.1.159
     */
    public static void segFile(final String filePath,
                               final int limitSize,
                               final String charsetName) {
        IBigFileStringHandler stringHandler = new BigFileStringHandlerSegment(limitSize);

        read(filePath, stringHandler, charsetName);
    }

}
