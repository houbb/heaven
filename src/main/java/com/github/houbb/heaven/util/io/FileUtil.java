/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.io;


import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.sun.org.apache.xpath.internal.Arg;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 文件工具类
 * 1. 用于获取文件的内容
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

    /**
     * 写入文件信息
     * （1）默认 utf-8 编码
     * （2）默认新建一个文件
     * @since 0.1.22
     * @param filePath 文件路径
     * @param lines 行信息
     * @param openOptions 文件选项
     */
    public static void write(final String filePath, final Iterable<? extends CharSequence> lines, OpenOption ... openOptions) {
        write(filePath, lines, CharsetConst.UTF8, openOptions);
    }

    /**
     * 写入文件信息
     * @since 0.1.22
     * @param filePath 文件路径
     * @param lines 行信息
     * @param charset 文件编码
     * @param openOptions 文件操作选项
     */
    public static void write(final String filePath, final Iterable<? extends CharSequence> lines,
                             final String charset, OpenOption ... openOptions) {
        try {
            // ensure lines is not null before opening file
            ArgUtil.notNull(lines, "charSequences");
            CharsetEncoder encoder = Charset.forName(charset).newEncoder();
            final Path path = Paths.get(filePath);

            OutputStream out = path.getFileSystem().provider().newOutputStream(path, openOptions);
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, encoder))) {
                for (CharSequence line: lines) {
                    writer.append(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建文件
     * （1）文件路径为空，则直接返回 false
     * （2）如果文件已经存在，则返回 true
     * （3）如果文件不存在，则创建文件夹，然后创建文件。
     * 3.1 如果父类文件夹创建失败，则直接返回 false.
     * @param filePath 文件路径
     * @return 是否成功
     * @since 0.1.24
     * @throws RuntimeException 运行时异常，如果创建文件异常。包括的异常为 {@link IOException} 文件异常.
     */
    public static boolean createFile(final String filePath) {
        if(StringUtil.isEmpty(filePath)) {
            return false;
        }

        if(FileUtil.exists(filePath)) {
            return true;
        }

        File file = new File(filePath);

        // 父类文件夹的处理
        File dir = file.getParentFile();
        if(FileUtil.notExists(dir)) {
            boolean mkdirResult = dir.mkdirs();
            if(!mkdirResult) {
                return false;
            }
        }
        // 创建文件
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 文件是否存在
     * @param filePath 文件路径
     * @param options 连接选项
     * @return 是否存在
     * @since 0.1.24
     */
    public static boolean exists(final String filePath, LinkOption ... options) {
        if(StringUtil.isEmpty(filePath)) {
            return false;
        }

        Path path = Paths.get(filePath);
        return Files.exists(path, options);
    }

    /**
     * 文件是否不存在
     * @param filePath 文件路径
     * @param options 连接选项
     * @return 是否存在
     * @since 0.1.24
     */
    public static boolean notExists(final String filePath, LinkOption ... options) {
        return !exists(filePath, options);
    }


    /**
     * 文件是否不存在
     * @param file 文件
     * @return 是否存在
     * @since 0.1.24
     */
    public static boolean notExists(final File file) {
        ArgUtil.notNull(file, "file");
        return !file.exists();
    }

    /**
     * 判断文件是否为空
     * （1）文件不存在，返回 true
     * （2）文件存在，且 {@link File#length()} 为0，则认为空。
     * （3）文件存在，且length大于0，则认为不空
     * @param filePath 文件路径
     * @return 内容是否为空
     * @since 0.1.24
     */
    public static boolean isEmpty(final String filePath) {
        if(StringUtil.isEmpty(filePath)) {
            return true;
        }
        File file = new File(filePath);
        return file.length() <= 0;
    }

    /**
     * 内容是否为不空
     * @param filePath 文件路径
     * @return 内容是否为不空
     * @since 0.1.24
     */
    public static boolean isNotEmpty(final String filePath) {
        return !isEmpty(filePath);
    }

    /**
     * 获取文件字节数组
     * @param file 文件信息
     * @return 字节数组
     * @since 0.1.50
     */
    public static byte[] getFileBytes(final File file) {
        ArgUtil.notNull(file, "file");

        try(FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024)) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 获取文件字节流
     * @param filePath 文件路径
     * @return 字节数组
     * @since 0.1.50
     */
    public static byte[] getFileBytes(final String filePath) {
        ArgUtil.notNull(filePath, "filePath");

        File file = new File(filePath);
        return getFileBytes(file);
    }

    /**
     * 根据字节信息创建文件
     * @param filePath 文件路径
     * @param bytes 字节数组
     * @since 0.1.50
     * @see #createFileAssertSuccess 断言创建成功
     */
    public static void createFile(final String filePath, final byte[] bytes) {
        File file = createFileAssertSuccess(filePath);
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);){
            bos.write(bytes);
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 创建文件
     * @param filePath 文件路径
     * @return 文件信息
     * @since 0.1.50
     * @throws RuntimeException 运行时异常，如果创建文件异常。包括的异常为 {@link IOException} 文件异常.
     */
    public static File createFileAssertSuccess(final String filePath) {
        ArgUtil.notEmpty(filePath, "filePath");

        // 判断文件是否存在
        File file = new File(filePath);
        if(file.exists()) {
            return file;
        }

        // 父类文件夹的处理
        File dir = file.getParentFile();
        if(FileUtil.notExists(dir)) {
            boolean mkdirResult = dir.mkdirs();
            if(!mkdirResult) {
                throw new CommonRuntimeException("Parent file create fail " + filePath);
            }
        }

        try {
            // 创建文件
            boolean createFile = file.createNewFile();
            if(!createFile) {
                throw new CommonRuntimeException("Create new file fail for path " + filePath);
            }
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除文件
     * @param file 文件信息
     * @since 0.1.50
     */
    public static void deleteFile(final File file) {
        ArgUtil.notNull(file, "file");

        if(file.exists()) {
            boolean result = file.delete();
            if(!result) {
                throw new CommonRuntimeException("Delete file fail for path " + file.getAbsolutePath());
            }
        }
    }

    /**
     * 创建临时文件
     * @param name 文件名称
     * @param suffix 文件后缀
     * @return 临时文件
     * @since 0.1.50
     */
    public static File createTempFile(final String name, final String suffix) {
        try {
            ArgUtil.notEmpty(name, "prefix");
            ArgUtil.notEmpty(suffix, "suffix");

            return File.createTempFile(name, suffix);
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 创建临时文件
     * @param nameWithSuffix 文件名称全称
     * @return 临时文件
     * @since 0.1.50
     */
    public static File createTempFile(final String nameWithSuffix) {
        try {
            ArgUtil.notEmpty(nameWithSuffix, "fileName");
            String[] strings = nameWithSuffix.split("\\.");
            return File.createTempFile(strings[0], strings[1]);
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }
    }

}
