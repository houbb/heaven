/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang;

/**
 * 字符串工具类
 *
 * @author bbhou
 * @since 0.0.1
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 空格
     */
    public static final String BLANK = " ";

    /**
     * 是否全部为大写
     * @param string 待检验字符
     * @return 是否为大写
     */
    public static boolean isUpperCase(final String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] characters = string.toCharArray();
        for(char c : characters) {
            if(!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否全部为小写
     * @param string 待检验字符
     * @return 是否为大写
     */
    public static boolean isLowerCase(final String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] characters = string.toCharArray();
        for(char c : characters) {
            if(!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否包含大写字母
     * @param string 待检验字符
     * @return 是否为大写
     */
    public static boolean containsUppercase(final String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] characters = string.toCharArray();
        for(char c : characters) {
            if(Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含小写字母
     * @param string 待检验字符
     * @return 是否为大写
     */
    public static boolean containsLowercase(final String string) {
        if(StringUtil.isEmpty(string)) {
            return false;
        }

        char[] characters = string.toCharArray();
        for(char c : characters) {
            if(Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 是否为空
     *
     * @param string 字符串
     * @return {@code true} 为空
     */
    public static boolean isEmpty(final String string) {
        return null == string || EMPTY.equals(string);
    }

    /**
     * 是否为非空
     *
     * @param string 字符串
     * @return {@code true} 为非空
     */
    public static boolean isNotEmpty(final String string) {
        return !isEmpty(string);
    }

    /**
     * 是否为空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * 是否不为空
     *
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }



    /**
     * 根据任意多的空格进行分割字符串。
     * 1. 入参为空,则返回空字符串数组
     *
     * @param string 字符串
     * @return 割字符串数组
     */
    public static String[] splitByAnyBlank(final String string) {
        if (StringUtil.isEmpty(string)) {
            return new String[0];
        }

        final String pattern = "\\s+";
        return string.split(pattern);
    }


    /**
     * 获取的驼峰写法。
     * 1.这是 mybatis-gen 源码
     *
     * @param inputString             输入字符串
     * @param firstCharacterUppercase 首字母是否大写。
     * @return 驼峰写法
     */
    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
                case '_':
                case '-':
                case '@':
                case '$':
                case '#':
                case ' ':
                case '/':
                case '&':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;

                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    /**
     * 首字母小写
     *
     * @param str 字符串
     * @return 首字母小写字符串
     */
    public static String firstToLowerCase(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 首字母大写
     *
     * @param str 字符串
     * @return 首字母大写结果
     */
    public static String firstToUpperCase(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 默认为 “”
     * 1. 如果为 null TO ""
     * 2. 返回本身
     *
     * @param string 字符串
     * @return 非 null 的字符串
     */
    public static String defaultEmpty(final String string) {
        if (isEmpty(string)) {
            return EMPTY;
        }
        return string;
    }


    /**
     * 将数组进行连接
     * from:    apache lang3
     *
     * @param array      object array
     * @param separator  分隔符
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     * @return join string
     */
    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }

        if (separator == null) {
            separator = "";
        }

        int noOfItems = endIndex - startIndex;
        if (noOfItems <= 0) {
            return "";
        } else {
            StringBuilder buf = new StringBuilder(noOfItems * 16);

            for (int i = startIndex; i < endIndex; ++i) {
                if (i > startIndex) {
                    buf.append(separator);
                }

                if (array[i] != null) {
                    buf.append(array[i]);
                }
            }

            return buf.toString();
        }
    }

    /**
     * 驼峰命名转下划线
     *
     * @param camelStr 驼峰字符串
     * @return 下划线字符串
     */
    public static String camelToUnderline(String camelStr) {
        if (StringUtil.isEmpty(camelStr)) {
            return StringUtil.EMPTY;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = camelStr.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 下划线转驼峰命名
     *
     * @param underlineStr 下划线字符串
     * @return 驼峰字符串
     */
    public static String underlineToCamel(String underlineStr) {
        if (StringUtil.isEmpty(underlineStr)) {
            return StringUtil.EMPTY;
        }

        int len = underlineStr.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = underlineStr.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(underlineStr.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 重复多少次
     * @param component 组成信息
     * @param times 重复次数
     * @return 重复多次的字符串结果
     */
    public static String repeat(final String component, final int times) {
        if(StringUtil.isEmpty(component)
                || times <= 0) {
            return StringUtil.EMPTY;
        }

        StringBuilder stringBuffer = new StringBuilder();
        for(int i = 0; i < times; i++) {
            stringBuffer.append(component);
        }

        return stringBuffer.toString();
    }

}
