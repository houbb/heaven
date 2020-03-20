package com.github.houbb.heaven.support.reader.impl;

import com.github.houbb.heaven.support.reader.IReader;
import com.github.houbb.heaven.util.io.FileUtil;

/**
 * 读取类
 * @author binbin.hou
 * @since 0.0.1
 */
public class FileReader implements IReader {

    /**
     * 文件路径
     * @since 0.0.1
     */
    private final String path;

    /**
     * 文件编码
     * @since 0.0.1
     */
    private final String charset;

    public FileReader(String path, String charset) {
        this.path = path;
        this.charset = charset;
    }

    @Override
    public String read() {
        return FileUtil.getFileContent(path, charset);
    }

}
