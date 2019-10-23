package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.util.ArrayPrimitiveUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字工具类
 *
 * @author binbin.hou
 * @since 0.1.16
 */
public final class NumUtil {

    private NumUtil() {
    }


    /**
     * 16 进制数组
     *
     * @since 0.1.26
     */
    public static final char[] HEX_CHARS = "1234567890abcdefABCDEF".toCharArray();

    /**
     * 获取较小的结果
     *
     * @param current 当前值
     * @param other   其他值
     * @return 较小的值
     */
    public static int getMin(final int current, final int other) {
        return current > other ? other : current;
    }

    /**
     * 获取较大的结果
     *
     * @param current 当前值
     * @param other   其他值
     * @return 较大的值
     */
    public static int getMax(final int current, final int other) {
        return current > other ? current : other;
    }

    /**
     * 转为 int
     *
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Integer> toInteger(final String string) {
        if (StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Integer integer = Integer.valueOf(string);
            return Optional.of(integer);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 字符串转化为整形
     * （1）如果参数不合法，直接抛出异常
     * @param string 字符串
     * @return 结果
     * @since 0.1.36
     */
    public static Integer toIntegerThrows(final String string) {
        ArgUtil.notEmpty(string, "string");

        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转换为整形
     * （1）如果参数不合法，直接使用默认值
     * @param string 字符串
     * @param defaultValue 默认值
     * @return 结果
     * @since 0.1.36
     */
    public static int toInteger(final String string, final int defaultValue) {
        try {
            return Integer.valueOf(string);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 转为 Long
     *
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Long> toLong(final String string) {
        if (StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Long aLong = Long.valueOf(string);
            return Optional.of(aLong);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 转为 Double
     *
     * @param string 原始字符串
     * @return 结果
     * @since 0.1.26
     */
    public static Optional<Double> toDouble(final String string) {
        if (StringUtil.isEmpty(string)) {
            return Optional.empty();
        }

        try {
            Double aDouble = Double.valueOf(string);
            return Optional.of(aDouble);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 是否为 16 进制信息
     *
     * @param string 结果
     * @return 是否
     */
    public static boolean isHex(final String string) {
        if (StringUtil.isEmpty(string)) {
            return false;
        }
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (ArrayPrimitiveUtil.indexOf(HEX_CHARS, c) < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 将对象转换为 Long
     *
     * @param object 对象
     * @return Long 如果信息为 null，直接返回 null
     * @throws ClassCastException 类型转换异常
     * @see CharSequence
     * @see java.math.BigDecimal
     * @see java.math.BigInteger
     * @see Integer
     * @see Short
     * @see Byte
     * @see Long
     * @since 0.1.30
     */
    public static Long parseLong(final Object object) {
        if (ObjectUtil.isNull(object)) {
            return null;
        }

        final Class valueClass = object.getClass();
        if (object instanceof Byte
                || valueClass == byte.class) {
            Byte aByte = (Byte) object;
            return aByte.longValue();
        }
        if (object instanceof Short
                || valueClass == short.class) {
            Short aShort = (Short) object;
            return aShort.longValue();
        }
        if (object instanceof Integer
                || valueClass == int.class) {
            Integer integer = (Integer) object;
            return integer.longValue();
        }
        if (object instanceof Long) {
            return (Long) object;
        }
        if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) object;
            return Long.parseLong(charSequence.toString());
        }
        if (object instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) object;
            return bigInteger.longValue();
        }
        if (object instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) object;
            return bigDecimal.longValue();
        }

        throw new ClassCastException("Class cast exception for parse long with object: " + object);
    }

}
