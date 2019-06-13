package com.github.houbb.heaven.support.metadata.util;

import com.github.houbb.heaven.support.metadata.constant.PackageConst;

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

}
