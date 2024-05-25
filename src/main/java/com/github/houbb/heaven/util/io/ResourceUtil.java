package com.github.houbb.heaven.util.io;

/**
 * 资源工具类
 * @since 0.10.0
 */
public class ResourceUtil {

    /**
     * 获取当前线程的上下文类加载器的资源路径
     * @return 路径
     * @since 0.10.0
     */
    public static String getCurrentThreadContextClassLoaderResource() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    /**
     * 获取系统类加载器的资源路径
     * @return 路径
     * @since 0.10.0
     */
    public static String getSystemClassLoaderResource() {
        return ClassLoader.getSystemResource("").getPath();
    }

    /**
     * 获取指定类加载器的资源路径
     * @return 路径
     * @since 0.10.0
     */
    public static String getClassLoaderResource(Class<?> clazz) {
        return clazz.getClassLoader().getResource("").getPath();
    }

    /**
     * 获取指定类的根路径
     * @return 路径
     * @since 0.10.0
     */
    public static String getClassRootResource(Class<?> clazz) {
        return clazz.getResource("/").getPath();
    }

    /**
     * 获取指定类的路径
     * @return 路径
     * @since 0.10.0
     */
    public static String getClassResource(Class<?> clazz) {
        return clazz.getResource("").getPath();
    }

}
