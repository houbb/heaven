package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.github.houbb.heaven.util.codec.Base64;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.PrimitiveUtil;
import com.github.houbb.heaven.util.util.ArrayPrimitiveUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

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
        return Math.min(current, other);
    }

    /**
     * 获取较大的结果
     *
     * @param current 当前值
     * @param other   其他值
     * @return 较大的值
     */
    public static int getMax(final int current, final int other) {
        return Math.max(current, other);
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
            return Integer.parseInt(string);
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

    /**
     * 获取数字格式化
     * @param number 数字
     * @param format 格式化
     * @return 结果
     * @since 0.1.48
     */
    public static String getNumFormat(final Number number, final String format) {
        ArgUtil.notNull(number, "number");
        ArgUtil.notEmpty(format, "format");

        NumberFormat numberFormat = new DecimalFormat(format);
        return numberFormat.format(number);
    }

    /**
     * 获取格式化数字
     * @param number 数字
     * @param format 格式化
     * @param numberClazz 数字类型
     * @param <T> 泛型
     * @return 结果
     * @since 0.1.48
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFormatNum(final String number, final String format,
                                      final Class<T> numberClazz) {
        ArgUtil.notNull(number, "number");
        ArgUtil.notEmpty(format, "format");

        NumberFormat numberFormat = new DecimalFormat(format);
        try {
            final Number numValue = numberFormat.parse(number);
            if(BigDecimal.class == numberClazz) {
                return (T) BigDecimal.valueOf((Double) numValue);
            }
            if(BigInteger.class == numberClazz) {
                return (T) BigInteger.valueOf((Long) numValue);
            }
            if(Float.class == numberClazz
                || float.class == numberClazz) {

            }

            //int short byte

            return (T) numValue;
        } catch (ParseException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 获取格式化数字
     * @param number 数字
     * @param format 格式化
     * @return 结果
     * @since 0.1.48
     */
    public static Number getFormatNum(final String number, final String format) {
        return getFormatNum(number, format, Number.class);
    }

    /**
     * 获取类型转换后的金额
     * @param numberStr 数字字符串
     * @param format 格式化
     * @param numberClazz 数字类型
     * @return 转换后的类型
     * @since 0.1.58
     */
    public static Object getFormatNumCast(final String numberStr,
                                          final String format,
                                          final Class numberClazz) {
        ArgUtil.notEmpty(numberStr, "numberStr");
        ArgUtil.notEmpty(format, "format");
        ArgUtil.notNull(numberClazz, "numberClazz");

        Class actualClazz = numberClazz;
        if(ClassTypeUtil.isPrimitive(actualClazz)) {
            actualClazz = PrimitiveUtil.getReferenceType(numberClazz);
        }

        NumberFormat numberFormat = new DecimalFormat(format);
        try {
            final Number numValue = numberFormat.parse(numberStr);
            if(Integer.class == actualClazz) {
                return numValue.intValue();
            }
            if(Long.class == actualClazz) {
                return numValue.longValue();
            }
            if(Float.class == actualClazz) {
                return numValue.floatValue();
            }
            if(Double.class == actualClazz) {
                return numValue.doubleValue();
            }
            if(Short.class == actualClazz) {
                return numValue.shortValue();
            }
            if(Byte.class == actualClazz) {
                return numValue.byteValue();
            }

            if(BigDecimal.class == actualClazz) {
                return BigDecimal.valueOf((Double) numValue);
            }
            if(BigInteger.class == actualClazz) {
                return BigInteger.valueOf((Long) numValue);
            }

            return numValue;
        } catch (ParseException e) {
            throw new CommonRuntimeException(e);
        }
    }

    /**
     * 转换为 bigInteger
     * @param bigDecimal 数字
     * @return 结果
     * @since 0.1.122
     */
    public static BigInteger toBigInteger(final BigDecimal bigDecimal) {
        if(null == bigDecimal) {
            return null;
        }

        return bigDecimal.toBigInteger();
    }

    /**
     * 转换为浮点型
     * @param bigInteger 整数
     * @return 浮点金额
     * @since 0.1.122
     */
    public static BigDecimal parseBigDecimal(final BigInteger bigInteger) {
        if(null == bigInteger) {
            return null;
        }

        return new BigDecimal(bigInteger);
    }

    /**
     * 转为 BigDecimal
     * @param object 对象
     * @return 结果
     * @since 0.2.0
     */
    public static BigDecimal toBigDecimal(final Object object) {
        if(object == null) {
            return null;
        }
        if(object instanceof BigDecimal) {
            return (BigDecimal) object;
        }

        if(object instanceof Long) {
            return BigDecimal.valueOf((Long) object);
        }
        if(object instanceof Double) {
            return BigDecimal.valueOf((Double) object);
        }

        // 字符串
        String string = String.valueOf(object);
        return new BigDecimal(string);
    }

    /**
     * 这里预留了足够的空位122位
     * private static final int FAST_SIZE = 'z';
     * 这个是为了存放字母对应的值，比如-对应63，但是-是45，也就是 digitsIndex[45]=63
     * [digitsChar[-]会自动转变成45，这样子十六进制转十进制，就可以获取到前面的数字了。
     */
    private static final int[] DIGITS_INDEX = new int[128];

    static {
        for (int i = 0; i < 64; i++) {
            DIGITS_INDEX[Base64.ALPHABET[i]] = i;
        }
    }

    //获取对应的的64进制的值
    private static int getIndex(String s, int pos) {
        char c = s.charAt(pos);
        return DIGITS_INDEX[c];
    }

    /**
     * 64进制转十进制
     * @param s 字符串
     * @return 数字
     * @since 0.1.162
     */
    public static long num64To10(String s) {
        long result = 0L;
        long multiplier = 1;
        for (int pos = s.length() - 1; pos >= 0; pos--) {
            int index = getIndex(s, pos);
            result += index * multiplier;
            multiplier *= 64;
        }
        return result;
    }

    /**
     * 十进制转64进制
     * @param number 数字
     * @return 结果
     * @since 0.1.162
     */
    public static String num10To64(long number) {
        ArgUtil.notNegative(number, "number");

        if(number == 0) {
            return "0";
        }

        StringBuilder buf = new StringBuilder();
        while (number != 0) {
            //获取余数
            int remain = (int) (number % 64);
            char c = Base64.ALPHABET[remain];
            buf.append(c);

            //剩下的值
            number /= 64;
        }

        //因为是从最后开始读的，所以这里要反转
        return buf.reverse().toString();
    }

    /**
     * 1、同比计算公式：同比增长率＝（本期数－同期数）／同期数×100%。
     *
     * 2、环比计算公式：环比增长率＝（本期数－上期数）／上期数×100%。
     *
     * @param before 上一期
     * @param now 本期
     * @return 结果
     * @since 0.1.165
     */
    public static String chainRatio(int before, int now) {
        if(before <= 0) {
            return "--";
        }

        double differ = (now - before) * 1.0;
        double result = differ / (before * 1.0) * 100;

        // 保留最后2位
        NumberFormat numberFormat = new DecimalFormat("#0.00");
        return numberFormat.format(result);
    }

}
