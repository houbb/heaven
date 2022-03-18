package com.github.houbb.heaven.util.io.big;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * 文件切割
 *
 * @author binbin.hou
 * @since 0.1.159
 */
public class BigFileStringHandlerSegment implements IBigFileStringHandler {

    /**
     * 限制大小
     */
    private final int limitSize;

    public BigFileStringHandlerSegment(int limitSize) {
        this.limitSize = limitSize;
    }

    @Override
    public void handle(BigFileStringHandlerContext context) {
        int index = context.getIndex();
        String line = context.getLine();
        int fileIndex = index / limitSize;

        String suffix = StringUtil.leftPadding(fileIndex + "", 3, '0');
        String targetFilePath = context.getFilePath() + "_" + suffix;

        if (FileUtil.notExists(targetFilePath)) {
            FileUtil.createFile(targetFilePath);
        }

        FileUtil.append(targetFilePath, line);
    }

}
