package com.github.houbb.heaven.util.nio;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 路径工具类
 * @author binbin.hou
 * @since 0.0.6
 */
public final class PathUtil {

    private PathUtil(){}

    /**
     * 根路径
     */
    public static final Path ROOT_PATH = Paths.get("/");

    /**
     * 获取 path 相对于 parentPath 剩余的路径
     * 和 {@link Path#relativize(Path)} 不同，这个结果更加直观。不过性能一般。
     * @param parentPath 父类路径
     * @param path 原始路径
     * @return 相对结果路径
     */
    public static String getRelativePath(final Path parentPath,
                                         final Path path) {
        final String pathStr = path.toString();
        if(ObjectUtil.isNull(parentPath)) {
            return pathStr;
        }

        // 认为是根路径
        if(parentPath.toString().length() <= 1) {
            return pathStr;
        }

        final String parentPathStr = parentPath.toString();
        if(pathStr.startsWith(parentPathStr)) {
            return pathStr.substring(parentPathStr.length()+1);
        }
        return pathStr;
    }

    /**
     * 获取共有的路径
     * @param pathList 路径列表
     * @return 结果
     */
    public static Path getPublicParentPath(final List<Path> pathList) {
        // 直接返回第一个元素的父类路径即可、
        if(pathList.size() == 1) {
            return getParentPath(pathList.get(0));
        }

        // 获取所有的父类文件夹
        List<List<String>> pathStrList = new ArrayList<>(pathList.size());
        for(Path path : pathList) {
            List<String> stringList = CollectionUtil.toStringList(getParentPaths(path));
            pathStrList.add(stringList);
        }

        // 获取共有的父类文件夹
        List<String> publicParentPathStrs = retainAll(pathStrList);

        // 获取最长的一个作为最大的公共路径
        String maxLengthParent = getMaxLength(publicParentPathStrs);
        return Paths.get(maxLengthParent);
    }

    /**
     * 获取最长的字符串
     * @param stringList 字符串列表
     * @return 最长的结果
     */
    private static String getMaxLength(final List<String> stringList) {
        String result = StringUtil.EMPTY;

        for(String string : stringList) {
            if(string.length() > result.length()) {
                result = string;
            }
        }
        return result;
    }

    /**
     * 获取所有的父类路径
     * 1. 不包含本身
     * 2. 递归获取父类，如果父类为 null 则停止（说明到 root 了）
     * 3. 默认 / root 的是所有逻辑的父亲路径，包括 root 文件夹本身。
     * @param path 当前路径
     * @return 所有的父类列表
     */
    public static List<Path> getParentPaths(final Path path) {
        if(ObjectUtil.isNull(path)) {
            return Collections.emptyList();
        }

        List<Path> pathList = new ArrayList<>();
        Path parentPath = path.getParent();
        while (ObjectUtil.isNotNull(parentPath)) {
            pathList.add(parentPath);

            parentPath = parentPath.getParent();
        }

        // 如果列表为空，则默认添加 /
        if(CollectionUtil.isEmpty(pathList)) {
            pathList.add(ROOT_PATH);
        }

        return pathList;
    }


    /**
     * 获取父类路径，避免返回 null
     * 1. 如果为根路径，则依然返回根路径
     * @param path 路径
     * @return 结果
     */
    public static Path getParentPath(final Path path) {
        Path parentPath = path.getParent();
        if(ObjectUtil.isNull(parentPath)) {
            return ROOT_PATH;
        }
        return parentPath;
    }

    /**
     * 获取所有集合的交集
     * 1. 如果后续参数为空，则直接返回第一个集合。
     * 2. 如果第一个列表为空，则直接返回第一个集合。
     * @param collectionList 原始对象集合
     * @return 满足条件的结合
     */
    public static List<String> retainAll(final List<List<String>> collectionList) {
        if(CollectionUtil.isEmpty(collectionList)) {
            return Collections.emptyList();
        }
        if(collectionList.size() == 1) {
            return collectionList.get(0);
        }

        List<String> result = collectionList.get(0);
        for(int i = 1; i < collectionList.size(); i++) {
            result.retainAll(collectionList.get(i));
        }

        return result;
    }

    /**
     * 递归获取所有对应的文件
     * 1. 如果为文件，直接返回本身
     * 2. 如果为文件夹，则递归获取下面的所有文件信息
     * @param rootPath 根路径
     * @return 文件列表
     */
    public static List<Path> getPathList(final Path rootPath) {
        final List<Path> pathList = new ArrayList<>();

        try {
            if(Files.isDirectory(rootPath)) {
                Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        pathList.add(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        pathList.add(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } else {
                pathList.add(rootPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pathList;
    }

}
