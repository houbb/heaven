package com.github.houbb.heaven.support.metadata.util;

import com.github.houbb.heaven.annotation.CommonEager;
import com.github.houbb.heaven.constant.CharsetConst;
import com.github.houbb.heaven.constant.FileProtocolConst;
import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.support.metadata.constant.PackageConst;
import com.github.houbb.heaven.support.tuple.impl.Quatenary;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.util.ArrayUtil;
import sun.tools.jar.resources.jar;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 包工具类
 * @author binbin.hou
 * @since 0.1.13
 */
public final class PackageUtil {

    /**
     * 获取包名称
     * @param clazz 类
     * @return 包名称
     */
    public static String getPackageName(final Class clazz) {
        return clazz.getPackage().getName();
    }

    /**
     * 是否在同一个包下
     * @param packageName 包名称
     * @param clazz 目标类
     * @return 是否
     */
    public static boolean isSamePackage(final String packageName, final Class clazz) {
        final String targetPackage = getPackageName(clazz);
        return packageName.equals(targetPackage);
    }

    /**
     * 是否为 java.lang 包的类，不包含子包
     * @param clazz 类信息
     * @return 是否
     */
    public static boolean isJavaLangPackage(final Class clazz) {
        final String packageName = getPackageName(clazz);
        return PackageConst.JAVA_LANG.equals(packageName);
    }

    /**
     * 扫描包中对应的类集合
     * @param packageName 包名称
     * @return 结果列表
     * @since 0.1.54
     */
    public static Set<String> scanPackageClassNameSet(final String packageName) {
        ArgUtil.notEmpty(packageName, "packageNames");

        Set<String> classNameSet = Guavas.newHashSet();
        String packageDirName = packageName.replace('.', '/');

        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();

                // 文件处理
                if(FileProtocolConst.FILE.equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), CharsetConst.UTF8);
                    File file = new File(filePath);

                    // 递归处理下面的文件明细
                    if(file.isDirectory()) {
                        File[] files = file.listFiles();
                        if(ArrayUtil.isNotEmpty(files)) {
                            for(File entry : files) {
                                recursiveFile(packageName, entry, classNameSet);
                            }
                        }
                    }
                } else if(FileProtocolConst.JAR.equals(protocol)) {
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                    jarEntryEnumeration.nextElement();
                    while (jarEntryEnumeration.hasMoreElements()) {
                        JarEntry jarEntry = jarEntryEnumeration.nextElement();

                        jarEntry.isDirectory();
                        System.out.println("jar " + jarEntry.getName());
                    }
                } else {
                    //jar 处理
                    System.err.println("Not support protocol: " + protocol);
                }
            }
        } catch (IOException e) {
            throw new CommonRuntimeException(e);
        }

        return classNameSet;
    }

    /**
     * 递归处理文件信息
     *
     * （1）如果是文件夹
     *
     * （2）如果是文件
     *  跳过特殊标志的信息
     *  $ 这个怎么处理？
     *  Proxy.isProxyClass(XXX)
     * @param packageNamePrefix 包名称前缀
     * @param file 根路径
     * @param classNameSet 类的全称信息集合
     * @since 0.1.54
     */
    private static void recursiveFile(String packageNamePrefix,
                               final File file,
                               final Set<String> classNameSet) {
        // 如果是文件
        if(file.isFile()) {
            // 比较简单的方式是获取对应的 class 全称。
            String fileName = file.getName().split("\\.")[0];
            String className = packageNamePrefix + PunctuationConst.DOT + fileName;

            classNameSet.add(className);
        } else {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                String dirName = file.getName();
                packageNamePrefix = packageNamePrefix + PunctuationConst.DOT + dirName;
                if(ArrayUtil.isNotEmpty(files)) {
                    for(File fileEntry : files) {
                        // 递归处理
                        recursiveFile(packageNamePrefix, fileEntry, classNameSet);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        scanPackageClassNameSet("com");
    }

}
