package com.github.houbb.heaven.util.lang.reflect;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 类加载工具类
 *
 * @since 0.10.0
 */
public class ClassLoaderUtil {

    /**
     * 加载类
     * @param classFilePath 文件路劲
     * @param classFullName 全称
     * @return 结果
     */
    public static Class<?> loadClass(String classFilePath, String classFullName) {
        // 确保类名与文件路径匹配
        // 如果类名是com.example.YourClass，则.class文件应该位于com/example/目录下

        try {
            // 创建一个URL对象，表示该class文件的路径
            File file = new File(classFilePath);
            URL url = file.toURI().toURL();

            // 创建一个URLClassLoader对象，加载指定的URL
            // 使用当前线程的上下文类加载器作为父类加载器
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url}, Thread.currentThread().getContextClassLoader());

            // 使用加载的类
            return classLoader.loadClass(classFullName);
        } catch (MalformedURLException e) {
            // 更好的异常处理，记录异常信息
            throw new RuntimeException("Failed to convert file to URL", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + classFullName, e);
        }
    }

    /**
     * 加载指定路径的.class文件对应的Class对象
     *
     * @param classFilePath 绝对路径的.class文件路径
     * @return Class对象
     */
    public static Class<?> loadClassFromFile(String classFilePath) {
        try {
            if (classFilePath == null || classFilePath.isEmpty()) {
                throw new IllegalArgumentException("Class file path must not be null or empty.");
            }

            // 将文件路径转换为URL
            File file = new File(classFilePath);
            URL url = file.toURI().toURL();

            // 创建URLClassLoader实例
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

            try {
                // 获取文件名，去除.class扩展名，得到类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                // 加载Class对象
                return classLoader.loadClass(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found: " + classFilePath, e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
