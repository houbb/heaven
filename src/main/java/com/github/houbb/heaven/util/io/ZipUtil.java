package com.github.houbb.heaven.util.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 压缩工具类
 *
 * @since 0.10.0
 */
public class ZipUtil {

    /**
     * 解压 war
     * @param warFilePath 文件路径
     * @param destinationDirectory 目标文件夹
     */
    public static void extractWar(String warFilePath, String destinationDirectory) {
        try {
            File destinationDir = new File(destinationDirectory);
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }

            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(Paths.get(warFilePath)))) {
                ZipEntry entry = zipInputStream.getNextEntry();
                while (entry != null) {
                    String filePath = destinationDirectory + File.separator + entry.getName();
                    if (!entry.isDirectory()) {
                        extractFile(zipInputStream, filePath);
                    } else {
                        File dir = new File(filePath);
                        dir.mkdir();
                    }
                    zipInputStream.closeEntry();
                    entry = zipInputStream.getNextEntry();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解压文件
     * @param zipInputStream 输入流
     * @param filePath 文件路径
     */
    private static void extractFile(ZipInputStream zipInputStream, String filePath) {
        try {
            FileUtil.createFile(filePath);

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
