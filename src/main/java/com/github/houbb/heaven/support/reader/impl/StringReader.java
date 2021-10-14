package com.github.houbb.heaven.support.reader.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.reader.IReader;

/**
 * 字符串读取类
 *
 * <p> project: heaven-StringReader </p>
 * <p> create on 2020/3/19 21:43 </p>
 *
 * @author binbin.hou
 * @since 0.1.94
 */
@ThreadSafe
public class StringReader implements IReader {

    /**
     * 字符串内容
     * @since 0.1.94
     */
    private final String string;

    public StringReader(String string) {
        this.string = string;
    }


    @Override
    public String read() {
        return this.string;
    }

}
