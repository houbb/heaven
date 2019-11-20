/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.constant.CharConst;
import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.util.ArrayPrimitiveUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.*;

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
     * 将数组进行逗号连接
     * @param array  object array
     * @return join string
     * @since 0.1.46
     */
    public static String join(Object[] array) {
        return join(array, PunctuationConst.COMMA);
    }

    /**
     * 将数组进行连接
     * @param array      object array
     * @param separator  分隔符
     * @return join string
     * @since 0.1.14
     * @see #join(Object[], String, int, int) 核心实现
     */
    public static String join(Object[] array, String separator) {
        final int endIndex = ArrayUtil.getEndIndex(-1, array);
        return join(array, separator, 0, endIndex);
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

            for (int i = startIndex; i <= endIndex; ++i) {
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
     * 字符串拼接
     * (1) v0.1.14 将其范围扩展到对象列表
     * 注意：如果有 null 属性，会导致直接报错。此处不再处理。
     * @param collection 集合列表
     * @param splitter 分隔符
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     * @param <E> 泛型
     * @return 结果
     * @since 0.1.14
     */
    public static <E> String join(final Collection<E> collection, final String splitter,
                              final int startIndex, final int endIndex) {
        if(CollectionUtil.isEmpty(collection)) {
            return StringUtil.EMPTY;
        }

        final String actualSplitter = StringUtil.nullToDefault(splitter, StringUtil.EMPTY);
        StringBuilder stringBuilder = new StringBuilder();

        Iterator<E> iterator = collection.iterator();
        // 循环直到 startIndex
        for(int i = 0; i < startIndex; i++) {
            iterator.next();
        }
        stringBuilder.append(iterator.next().toString());
        for(int i = startIndex; i < endIndex; i++) {
            stringBuilder.append(actualSplitter).append(iterator.next().toString());
        }
        return stringBuilder.toString();
    }

    /**
     * 字符串拼接
     * (1) v0.1.14 将其范围扩展到对象列表
     * 注意：如果有 null 属性，会导致直接报错。此处不再处理。
     * @param collection 集合信息
     * @param splitter 分隔符
     * @param <E> 泛型
     * @return 结果
     * @since 0.1.14
     */
    public static <E> String join(final Collection<E> collection, final String splitter) {
        final int endIndex = CollectionUtil.getEndIndex(-1, collection);
        return join(collection, splitter, 0, endIndex);
    }

    /**
     * 字符串按逗号拼接拼接
     * @param collection 集合信息
     * @param <E> 泛型
     * @return 结果
     * @since 0.1.46
     */
    public static <E> String join(final Collection<E> collection) {
        return join(collection, PunctuationConst.COMMA);
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

    /**
     * 构建新的字符串
     * @param original 原始对象
     * @param middle 中间隐藏信息
     * @param prefixLength 前边信息长度
     * @return 构建后的新字符串
     * @since 0.0.8
     */
    public static String buildString(final Object original,
                                     final String middle,
                                     final int prefixLength) {
        if(ObjectUtil.isNull(original)) {
            return null;
        }

        final String string = original.toString();
        final int stringLength = string.length();

        String prefix = "";
        String suffix = "";

        if(stringLength >= prefixLength) {
            prefix = string.substring(0, prefixLength);
        } else {
            prefix = string.substring(0, stringLength);
        }

        int suffixLength = stringLength - prefix.length() - middle.length();
        if(suffixLength > 0) {
            suffix = string.substring(stringLength -suffixLength);
        }

        return prefix + middle + suffix;
    }

    /**
     * 过滤掉空格
     *
     * @param original 原始字符串
     * @return 过滤后的字符串
     * @since 0.1.0
     */
    public static String trim(final String original) {
        if (StringUtil.isBlank(original)) {
            return original;
        }
        return original.trim();
    }

    /**
     * 如果字符串是<code>null</code>，则返回指定默认字符串，否则返回字符串本身。
     *
     * <pre>
     * nullToDefault(null, &quot;default&quot;)  = &quot;default&quot;
     * nullToDefault(&quot;&quot;, &quot;default&quot;)    = &quot;&quot;
     * nullToDefault(&quot;  &quot;, &quot;default&quot;)  = &quot;  &quot;
     * nullToDefault(&quot;bat&quot;, &quot;default&quot;) = &quot;bat&quot;
     * </pre>
     *
     * @param str        要转换的字符串
     * @param defaultStr 默认字符串
     * @return 字符串本身或指定的默认字符串
     * @since 0.1.0
     */
    public static String nullToDefault(CharSequence str, String defaultStr) {
        return (str == null) ? defaultStr : str.toString();
    }

    /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @param isPre      是否填充在前
     * @return 填充后的字符串
     * @since 0.1.0
     */
    public static String fill(String str, char filledChar, int len, boolean isPre) {
        final int strLen = str.length();
        if (strLen > len) {
            return str;
        }

        String filledStr = StringUtil.repeat(String.valueOf(filledChar), len - strLen);
        return isPre ? filledStr.concat(str) : str.concat(filledStr);
    }

    /**
     * 对象转换为字符串
     * 1. 对数组特殊处理 {@link java.util.Arrays#toString(Object[])} 避免打印无意义的信息（v0.1.14）
     * @param object 对象
     * @param defaultWhenNull 对象为空时的默认值
     * @return 结果
     * @since 0.1.5
     */
    public static String objectToString(final Object object,
                             final String defaultWhenNull) {
        if(ObjectUtil.isNull(object)) {
            return defaultWhenNull;
        }
        Class type = object.getClass();
        if(ClassTypeUtil.isArray(type)) {
            Object[] arrays = (Object[])object;
            return Arrays.toString(arrays);
        }
        return object.toString();
    }

    /**
     * 对象转换为字符串
     * 1. 默认为空时返回 null
     * @param object 对象
     * @return 结果
     * @since 0.1.5
     */
    public static String objectToString(final Object object) {
        return objectToString(object, null);
    }

    /**
     * 对 single 的信息重复多次
     * @param single 单个字符
     * @param times 重复次数
     * @return 结果
     * @since 0.1.9
     * @see #repeat(String, int) 重复
     */
    @Deprecated
    public static String times(final String single,
                               final int times) {
        if(StringUtil.isEmpty(single)) {
            return single;
        }
        if(times <= 0) {
            return single;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < times; i++) {
            stringBuilder.append(single);
        }
        return stringBuilder.toString();
    }

    /**
     * 首字母大写
     * @param string 字符串
     * @return 大写的结果
     * @since 0.1.11
     */
    public static String capitalFirst(final String string) {
        if(StringUtil.isEmpty(string)) {
            return string;
        }

        if(string.length() <= 1) {
            return string.toUpperCase();
        }

        char capitalChar = Character.toUpperCase(string.charAt(0));
        return capitalChar + string.substring(1);
    }

    /**
     * 严格拆分
     * 【传统拆分】
     * 1:2:3:31::32:4 结果是：[1, 2, 3, 31, , 32, 4]
     *
     * 【严格拆分】
     * 严格匹配 : 拆分符，如果有多个，则不进行拆分。
     * 结果：[1, 2, 3, 31::32, 4]
     *
     * 实现逻辑：
     * （1）根据 index 获取所有的下标。+length（当前步长）
     * （2）获取当前的所有拆分下标，获取 times+1 的拆分下标
     * （3）从当前下标中移除 times+1 的下标。并且移除连续的信息。
     * 连续：times+1 的下标，后续的 times 步长。如果不连续，则中断。
     * （4）根据过滤后的列表生成最后的结果。
     *
     * @param string 原始字符串
     * @param splitUnit 分隔单元
     * @param times 次数
     * @return 结果
     * @since 0.1.16
     */
    public static List<String> splitStrictly(final String string,
                                             final char splitUnit,
                                             final int times) {
        if(StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        }
        if(times <= 0) {
            return Collections.singletonList(string);
        }

        // 分别获取索引列表
        final String split = CharUtil.repeat(splitUnit, times);
        final String moreSplit = CharUtil.repeat(splitUnit, times+1);
        final List<Integer> splitIndexList = getIndexList(string, split);
        final List<Integer> moreSplitIndexList = getIndexList(string, moreSplit);

        // 移除重复下标
        final List<Integer> removeIndexList = getSerialFilterList(splitIndexList, moreSplitIndexList, times);

        // 构建结果列表
        Collection<Integer> trimIndexList = CollectionUtil.difference(splitIndexList, removeIndexList);
        return subStringList(string, trimIndexList, times);
    }

    /**
     * 获取满足条件连续的列表
     * （1）当前信息
     * （2）连续的索引信息
     * @param allList 所有的整数
     * @param filterList 待排除的整数
     * @param step 步长
     * @return 结果列表
     */
    private static List<Integer> getSerialFilterList(final List<Integer> allList,
                                              final List<Integer> filterList,
                                               final int step) {
        List<Integer> resultList = Guavas.newArrayList();

        resultList.addAll(filterList);
        // 根据 index+times 为步长进行连续判断。不存在则跳过
        for(Integer filter : filterList) {
            // 从匹配的下一个元素开始
            final int startIndex = allList.indexOf(filter)+1;
            int stepTimes = 1;
            for(int i = startIndex; i < allList.size(); i++) {
                final Integer indexVal = allList.get(i);
                final int nextVal = step*stepTimes+filter;
                if(indexVal.equals(nextVal)) {
                    resultList.add(nextVal);
                } else {
                    // 跳出当前循环
                    break;
                }
                stepTimes++;
            }
        }

        return resultList;
    }

    /**
     * 根据下标截取列表
     *
     * 【最后的截取问题】
     * 最后构建的结果：
     * string=1::2::3:31:::32::4:
     * index=[1,4,15]
     * ignore=2
     *
     *  每次截取：
     *  [0,1)
     *  [1+2,4)
     *  [15+2,]
     * @param string 原始字符串
     * @param indexCollection 下标列表
     * @param ignoreLength 每次忽略跳过的长度。用于跳过 split 字符。
     * @return 结果列表
     * @since 0.1.16
     */
    public static List<String> subStringList(final String string,
                                             final Collection<Integer> indexCollection,
                                             final int ignoreLength) {
        if(StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        }
        if(CollectionUtil.isEmpty(indexCollection)) {
            return Collections.singletonList(string);
        }

        List<String> resultList = Guavas.newArrayList(indexCollection.size());
        int startIndex = 0;
        for(Integer index : indexCollection) {
            // 最后的位置添加空字符串
            if(startIndex > string.length()-1) {
                resultList.add(StringUtil.EMPTY);
                break;
            }
            String subString = string.substring(startIndex, index);
            resultList.add(subString);
            startIndex = index+ignoreLength;
        }
        // 最后的结果信息
        if(startIndex < string.length()) {
            String subString = string.substring(startIndex);
            resultList.add(subString);
        }

        return resultList;
    }

    /**
     * 获取所有符合条件的下标类表
     * 【下标】
     * 1:2:3:31::32:4:
     *
     * [1, 3, 5, 8, 9, 12, 14]
     *
     * 问题：这个下标没有过滤 split。
     * 如果想过滤分隔符，应该如下：
     * (0,1)
     * (1+split.length, 3)
     * ...
     * 1,2,
     * @param string 原始字符串
     * @param split 分隔字符串
     * @return 下标列表
     * @since 0.1.16
     */
    public static List<Integer> getIndexList(final String string,
                                             final String split) {
        if(StringUtil.isEmpty(string)
            || StringUtil.isEmpty(split)) {
            return Collections.emptyList();
        }

        List<Integer> indexList = Guavas.newArrayList();
        int startIndex = 0;
        while (startIndex < string.length()) {
            startIndex = string.indexOf(split, startIndex);
            if(startIndex < 0) {
                break;
            }
            indexList.add(startIndex);
            startIndex += split.length();
        }
        return indexList;
    }


    /**
     * 获取字符串对应的下标信息
     * @param string 字符串
     * @param symbol 分隔符
     * @param ignoreDoubleQuotes 是否忽略双引号中的信息
     * @return 结果列表
     * @since 0.1.27
     */
    public static List<Integer> getIndexList(final String string,
                                             final char symbol,
                                             final boolean ignoreDoubleQuotes) {
        if(StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        }

        List<Integer> resultList = Guavas.newArrayList();
        char[] chars = string.toCharArray();

        boolean doubleQuotesStart = false;
        char preChar = CharConst.BLANK;
        for(int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            preChar = getPreChar(preChar, currentChar);
            // 上一个字符不是转义，且当前为 "。则进行状态的切换
            if (CharConst.BACK_SLASH != preChar
                    && CharConst.DOUBLE_QUOTES == currentChar) {
                doubleQuotesStart = !doubleQuotesStart;
            }

            // 等于且不在双引号中。
            if(currentChar == symbol) {
                // 忽略双引号中的信息 && 不在双引号中。
                if(ignoreDoubleQuotes) {
                    if(!doubleQuotesStart) {
                        resultList.add(i);
                    }
                } else {
                    resultList.add(i);
                }
            }
        }
        return resultList;
    }

    /**
     * 获取上一个字符
     *
     * 保证转义字符的两次抵消。
     *
     * @param preChar     上一个字符
     * @param currentChar 当前字符
     * @return 结果
     * @since 0.1.27
     */
    @Deprecated
    private static char getPreChar(final char preChar, final char currentChar) {
        // 判断前一个字符是什么
        if (CharConst.BACK_SLASH == preChar
                && CharConst.BACK_SLASH == currentChar) {
            return CharConst.BLANK;
        }
        return currentChar;
    }

    /**
     * 根据索引下标直接拆分
     * @param string 原始字符串
     * @param indexList 结果列表
     * @return 结果
     * @since 0.1.27
     */
    public static List<String> splitByIndexes(final String string, final List<Integer> indexList) {
        if(StringUtil.isEmpty(string)) {
            return Collections.emptyList();
        }
        if(CollectionUtil.isEmpty(indexList)) {
            return Collections.singletonList(string);
        }

        List<String> resultList = Guavas.newArrayList(indexList.size()+1);

        int preIndex = 0;
        for (Integer anIndexList : indexList) {
            int currentIndex = anIndexList;
            if (currentIndex > preIndex) {
                resultList.add(string.substring(preIndex, currentIndex));
            }
            preIndex = currentIndex+1;
        }
        // 判断最后一个下标
        final int lastIndex = indexList.get(indexList.size()-1);
        if(lastIndex+1 < string.length()) {
            resultList.add(string.substring(lastIndex+1));
        }
        return resultList;
    }

    /**
     * 字符串转字节数组
     * @param string 字符串
     * @return 字节数组
     * @since 0.1.35
     */
    public static byte[] stringToBytes(final String string) {
        if(ObjectUtil.isNull(string)) {
            return null;
        }

        return string.getBytes();
    }

    /**
     * 字节数组转字符串
     * @param bytes 字节数组
     * @return 字符串
     * @since 0.1.35
     */
    public static String bytesToString(final byte[] bytes) {
        if(ArrayPrimitiveUtil.isEmpty(bytes)) {
            return null;
        }

        return new String(bytes);
    }

    /**
     * 拆分为字符串数组
     * @param string 字符串
     * @param splitter 拆分符号
     * @return 字符串数组
     * @since 0.1.46
     */
    public static String[] splitToStringArray(final String string, final String splitter) {
        if(StringUtil.isEmpty(string)) {
            return null;
        }

        return string.split(splitter);
    }

    /**
     * 拆分为字符串数组
     * @param string 字符串
     * @return 字符串数组
     * @since 0.1.46
     */
    public static String[] splitToStringArray(final String string) {
        return splitToStringArray(string, PunctuationConst.COMMA);
    }

}
