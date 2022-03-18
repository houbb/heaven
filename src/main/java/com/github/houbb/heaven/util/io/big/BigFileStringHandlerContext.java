package com.github.houbb.heaven.util.io.big;

/**
 * @author binbin.hou
 * @since 0.1.159
 */
public class BigFileStringHandlerContext {

    /**
     * 下标
     */
    private int index;

    /**
     * 当前行内容
     */
    private String line;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件编码
     */
    private String charset;

    /**
     * 文件指针
     */
    private long filePointer;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public long getFilePointer() {
        return filePointer;
    }

    public void setFilePointer(long filePointer) {
        this.filePointer = filePointer;
    }

    @Override
    public String toString() {
        return "BigFileStringHandlerContext{" +
                "index=" + index +
                ", line='" + line + '\'' +
                ", filePath='" + filePath + '\'' +
                ", charset='" + charset + '\'' +
                ", filePointer=" + filePointer +
                '}';
    }

}
