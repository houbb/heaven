package com.github.houbb.heaven.util.io.filewalker;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用于返回所有的文件信息
 * @since 0。2.2
 */
public class AllFileVisitor extends SimpleFileVisitor<Path> {

    /**
     * 存放路径列表
     */
    private List<Path> pathList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        pathList.add(file);
        return FileVisitResult.CONTINUE;
    }

    /**
     * 获取文件路径列表
     *
     * @return 文件路径列表
     */
    public List<Path> getPathList() {
        return Collections.unmodifiableList(pathList);
    }

}
