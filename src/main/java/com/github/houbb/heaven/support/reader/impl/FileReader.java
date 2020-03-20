package com.github.houbb.heaven.support.reader.impl;

import com.github.houbb.heaven.support.reader.IReader;
import com.github.houbb.heaven.util.io.FileUtil;

import java.io.File;

/**
 * 读取类
 * @author binbin.hou
 * @since 0.0.1
 */
public class FileReader implements IReader {

    /**
     * 文件路径
     * @since 0.1.95
     */
    private final File file;

    /**
     * 文件编码
     * @since 0.0.1
     */
    private final String charset;

    public FileReader(File file, String charset) {
        this.file = file;
        this.charset = charset;
    }

    @Override
    public String read() {
        return FileUtil.getFileContent(file, charset);
    }

}
