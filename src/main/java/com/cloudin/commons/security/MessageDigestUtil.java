package com.cloudin.commons.security;

import com.cloudin.commons.util.Bytes;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 信息签名算法
 * Created by YFHan on 2017/4/3 0003.
 */
public enum MessageDigestUtil {

    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private String algorithmName;

    MessageDigestUtil(String algorithmName) {
        this.algorithmName = algorithmName;
    }


    /**
     * 对指定字符串作签名，得到签名后的byte数组。<br>
     * 如果txt为null，将直接返回null
     *
     * @param txt 需要签名的字符串
     * @return
     */
    public byte[] digest(String txt) {
        if (null == txt) {
            return null;
        }
        return digestBytes(txt.getBytes());
    }

    /**
     * 对指定字符串作签名，得到签名后的byte数组。<br>
     * 如果txt为null，将直接返回null，如果charset不被jvm支持，将打印异常堆栈并返回null
     *
     * @param txt     需要签名的字符串
     * @param charset txt的编码字符集
     * @return
     */
    public byte[] digest(String txt, String charset) {
        if (null == txt) {
            return null;
        }
        try {
            return digestBytes(txt.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对指定字符串作签名，得到签名后的小写字符串。如果txt为null，将直接返回null
     *
     * @param txt 需要签名的字符串
     * @return
     */
    public String digestToString(String txt) {
        if (null == txt) {
            return null;
        }
        return Bytes.toHexLowerString(digestBytes(txt.getBytes()));
    }


    /**
     * 对指定字符串作签名，得到签名后的小写字符串。<br>
     * 如果txt为null，将直接返回null，如果charset不被jvm支持，将打印异常堆栈并返回null
     *
     * @param txt 需要签名的字符串
     * @return
     */
    public String digestToString(String txt, String charset) {
        if (null == txt) {
            return null;
        }
        try {
            return Bytes.toHexLowerString(digestBytes(txt.getBytes(charset)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对指定byte数组作签名，得到签名后的byte数组。如果bytes为null，将直接返回null
     *
     * @param bytes 需要签名的byte数组
     * @return
     */
    public byte[] digestBytes(byte[] bytes) {
        if (null == bytes) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance(algorithmName);
            return md.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对指定byte数组作签名，得到签名后的小写字符串。如果bytes为null，将直接返回null
     *
     * @param bytes 需要签名的byte数组
     * @return
     */
    public String digestBytesToString(byte[] bytes) {
        if (null == bytes) {
            return null;
        }
        return Bytes.toHexLowerString(digestBytes(bytes));
    }
}
