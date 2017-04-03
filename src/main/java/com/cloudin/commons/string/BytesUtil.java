package com.cloudin.commons.string;

/**
 * Created by YFHan on 2017/4/3 0003.
 */
public class BytesUtil {

    public final static char[] hexOfLower;
    public final static char[] hexOfUpper;

    static {
        hexOfLower = "0123456789abcdef".toCharArray();
        hexOfUpper = "0123456789ABCDEF".toCharArray();
    }

    /**
     * 将指定的byte数组转换为小写hex文本
     *
     * @param bytes 需要转换的byte数组
     * @return
     */
    public final static String toHexLowerString(byte[] bytes) {
        return toHexString(bytes, null, false);
    }

    /**
     * 将指定的byte数组转换为大写hex文本
     *
     * @param bytes 需要转换的byte数组
     * @return
     */
    public final static String toHexUpperString(byte[] bytes) {
        return toHexString(bytes, null, true);
    }

    /**
     * 将指定的byte数组转换为小写hex文本，使用一个空格分隔
     *
     * @param bytes 需要转换的byte数组
     * @return
     */
    public final static String toHexLowerStringWithSpace(byte[] bytes) {
        return toHexString(bytes, " ", false);
    }

    /**
     * 将指定的byte数组转换为大写hex文本，使用一个空格分隔
     *
     * @param bytes 需要转换的byte数组
     * @return
     */
    public final static String toHexUpperStringWithSpace(byte[] bytes) {
        return toHexString(bytes, " ", true);
    }

    /**
     * 将指定的byte数组转换为小写hex文本
     *
     * @param bytes 需要转换的byte数组
     * @return
     */
    public final static String toHexString(byte[] bytes) {
        return toHexLowerString(bytes);
    }

    /**
     * 将指定的byte数组转换为hex文本
     *
     * @param bytes     需要转换的byte数组
     * @param separator 分隔符
     * @param upperCase 是否转换为大写的hex文本
     * @return
     */
    public final static String toHexString(byte[] bytes, String separator, boolean upperCase) {
        if (null == bytes || bytes.length == 0) {
            return null;
        }
        char[] hexChars = upperCase ? hexOfUpper : hexOfLower;
        StringBuilder builder = new StringBuilder();
        for (byte m : bytes) {
            builder.append(hexChars[m >> 4 & 0x0F]);
            builder.append(hexChars[m & 0x0F]);
            if (separator != null) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }
}
