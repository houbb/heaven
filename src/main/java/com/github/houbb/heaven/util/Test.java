package com.github.houbb.heaven.util;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.util.regex.RegexUtil;

import java.io.File;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        // 特殊字符匹配
//        String regex = "[\\x02]";
//        Pattern pattern = Pattern.compile(regex);
//        File[] files = new File("D:\\code\\github\\houbb.github.io\\_posts").listFiles();
//        for(File file : files) {
//            String content = FileUtil.getFileContent(file);
//            if(RegexUtil.match(pattern, content)) {
//                System.out.println(file.getAbsoluteFile());
//
//                System.out.println(content);
//            }
//        }

        for(int i = 1; i < 32; i++) {
            char c = (char) i;
            System.out.println(i + ": " + Character.valueOf(c));
        }
    }
}
