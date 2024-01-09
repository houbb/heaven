/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.util;

import com.github.houbb.heaven.constant.SystemConst;

/**
 * <p> 系统工具类 </p>
 *
 * <pre> Created: 2019/9/2 8:44 PM  </pre>
 * <pre> Project: heaven  </pre>
 *
 * @author houbinbin
 * @since 0.1.23
 */
public final class SystemUtil {

    private SystemUtil(){}

    /**
     * 获取换行符号
     * @return 换行符号
     * @since 0.1.23
     */
    public static String getLineSeparator() {
        return getProperty(SystemConst.LINE_SEPARATOR);
    }

    /**
     * 获取属性信息
     * @param key 标识
     * @return 结果
     * @since 0.1.23
     */
    public static String getProperty(final String key) {
        return System.getProperty(key);
    }

    /**
     * 是否为 windows 系统
     * @return 是否
     * @since 0.1.165
     */
    public static boolean isWindowsOs() {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            return true;
        }

        return false;
    }

    /**
     * 根据不同的系统，返回对应的基本路径
     * @param baseDir 目录
     * @return 基本路径
     * @since 0.1.165
     */
    public static String getBaseDir(final String baseDir) {
        if(isWindowsOs()) {
            return "D:\\file\\"+baseDir+"\\";
        }

        return "/app/file/"+baseDir+"/";
    }

    /**
     * 获取临时文件夹
     * @return 文件夹
     * @since 0.9.0
     */
    public static String getTempDir() {
        return System.getProperty("java.io.tmpdir");
    }

}
