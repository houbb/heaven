package com.github.houbb.heaven.support.reader.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.support.reader.IReader;
import com.github.houbb.heaven.util.io.FileUtil;

/**
 * 文件路径阅读者
 * <p> project: heaven-StringReader </p>
 * <p> create on 2020/3/19 21:43 </p>
 *
 * @author binbin.hou
 * @since 0.1.94
 */
@ThreadSafe
public class FilePathReader implements IReader {

    /**
     * 字符串内容
     * @since 0.1.94
     */
    private final String path;

    /**
     * 文件编码
     * @since 0.1.94
     */
    private final String charset;

    public FilePathReader(String path, String charset) {
        this.path = path;
        this.charset = charset;
    }

    public FilePathReader(String path) {
        this(path, CharsetConst.UTF8);
    }

    @Override
    public String read() {
        return FileUtil.getFileContent(path, charset);
    }

}
