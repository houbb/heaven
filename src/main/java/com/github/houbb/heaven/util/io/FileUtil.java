/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.io;


import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 文件工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class FileUtil {

    private FileUtil() {
    }

    /**
     * 获取文件内容
     *
     * @param filePath 文件路径
     * @return 文件不存在或异常等, 直接抛出异常
     */
    public static String getFileContent(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                return getFileContent(inputStream);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return StringUtil.EMPTY;
    }

    /**
     * 获取文件内容
     * 默认编码UTF8
     *
     * @param inputStream 输入流
     * @return 文件内容
     */
    public static String getFileContent(InputStream inputStream) {
        return getFileContent(inputStream, CharsetConst.UTF8);
    }

    /**
     * 获取文件内容
     *
     * @param inputStream 文件输入流
     * @param charset     文件编码
     * @return 文件内容字符串
     */
    public static String getFileContent(InputStream inputStream, String charset) {
        try {
            int size = inputStream.available();
            byte[] bytes = new byte[size];
            int readSize = inputStream.read(bytes);
            inputStream.close();
            String jsonText;
            jsonText = new String(bytes, charset);
            return jsonText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件后缀
     *
     * @param fileName 文件名称
     * @return 文件后缀
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }


    /**
     * 获取指定路径文件的每一行内容
     *
     * @param filePath 文件路径
     * @param initLine 初始化行数
     * @return 内容列表
     */
    public static List<String> getFileContentEachLine(String filePath, int initLine) {
        File file = new File(filePath);
        return getFileContentEachLine(file, initLine);
    }

    /**
     * 获取指定路径文件的每一行内容
     * 1.初始化行数默认为0
     *
     * @param filePath 文件路径
     * @return 内容列表
     * @see #getFileContentEachLine(String, int) 获取指定路径文件的每一行内容
     */
    public static List<String> getFileContentEachLine(String filePath) {
        File file = new File(filePath);
        return getFileContentEachLine(file, 0);
    }


    /**
     * 获取指定文件的每一行内容。并对内容进行trim()操作。
     *
     * @param filePath 文件路径
     * @param initLine 初始化行数
     * @return 内容列表
     */
    public static List<String> getFileContentEachLineTrim(String filePath, int initLine) {
        List<String> stringList = getFileContentEachLine(filePath, initLine);
        List<String> resultList = new LinkedList<>();

        for (String string : stringList) {
            resultList.add(string.trim());
        }

        return resultList;
    }

    /**
     * 获取指定文件的每一行内容
     * 默认初始行数为0
     *
     * @param file 文件
     * @return 内容列表
     */
    public static List<String> getFileContentEachLine(File file) {
        return getFileContentEachLine(file, 0);
    }

    /**
     * 获取指定文件的每一行内容
     * [TWR](http://blog.csdn.net/doctor_who2004/article/details/50901195)
     *
     * @param file     指定读取文件
     * @param initLine 初始读取行数
     * @return 错误返回空列表
     * @since 1.7
     */
    public static List<String> getFileContentEachLine(File file, int initLine) {
        List<String> contentList = new LinkedList<>();

        if (!file.exists()) {
            return contentList;
        }

        //暂时使用此编码
        String charset = "UTF-8";
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            // 用于记录行号
            int lineNo = 0;
            while (lineNo < initLine) {
                lineNo++;
                String ignore = bufferedReader.readLine();
            }

            String dataEachLine;   //每一行的内容
            while ((dataEachLine = bufferedReader.readLine()) != null) {
                lineNo++;
                //跳过空白行
                if (Objects.equals("", dataEachLine)) {
                    continue;
                }
                contentList.add(dataEachLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contentList;
    }


    /**
     * 获取文件内容的列表
     *
     * @param file     文件
     * @param initLine 0 开始
     * @param endLine  下标从0开始
     * @param charset  编码
     * @return string list
     */
    public static List<String> getFileContentEachLine(final File file, final int initLine, final int endLine, final String charset) {
        List<String> contentList = new LinkedList<>();

        if (!file.exists()) {
            return contentList;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            // 用于记录行号
            int lineNo = 0;
            while (lineNo < initLine) {
                lineNo++;
                String ignore = bufferedReader.readLine();
            }

            //每一行的内容
            String dataEachLine;
            while ((dataEachLine = bufferedReader.readLine()) != null
                    && lineNo < endLine) {
                lineNo++;
                contentList.add(dataEachLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contentList;
    }


    /**
     * 复制文件夹
     *
     * @param sourceDir 原始文件夹
     * @param targetDir 目标文件夹
     * @throws IOException if any
     * @since 1.1.2
     */
    public static void copyDir(String sourceDir, String targetDir) throws IOException {
        File file = new File(sourceDir);
        String[] filePath = file.list();

        if (!(new File(targetDir)).exists()) {
            (new File(targetDir)).mkdir();
        }

        if (ArrayUtil.isNotEmpty(filePath)) {

            for (String aFilePath : filePath) {
                if ((new File(sourceDir + File.separator + aFilePath)).isDirectory()) {
                    copyDir(sourceDir + File.separator + aFilePath, targetDir + File.separator + aFilePath);
                }

                if (new File(sourceDir + File.separator + aFilePath).isFile()) {
                    copyFile(sourceDir + File.separator + aFilePath, targetDir + File.separator + aFilePath);
                }

            }

        }

    }


    /**
     * 复制文件
     *
     * @param sourceFile 原始路径
     * @param targetPath 目标路径
     * @throws IOException if any
     * @since 1.1.2
     */
    public static void copyFile(String sourceFile, String targetPath) throws IOException {
        File oldFile = new File(sourceFile);
        File file = new File(targetPath);

        try (FileInputStream in = new FileInputStream(oldFile);
             FileOutputStream out = new FileOutputStream(file)) {

            byte[] buffer = new byte[2097152];

            while ((in.read(buffer)) != -1) {
                out.write(buffer);
            }

        }

    }

}
