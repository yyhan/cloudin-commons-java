package com.cloudin.commons.security;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by YFHan on 2017/4/4 0004.
 */
public class AES {

    /**
     * 对指定内容使用指定秘钥进行AES(128)加密，并返回加密后的字节数组
     *
     * @param content  待加密的内容
     * @param password 加密秘钥
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        return encrypt(content.getBytes(), password.getBytes());
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)加密，并返回加密后的字节数组
     *
     * @param content  待加密的内容
     * @param password 加密秘钥
     * @param encoding 待加密内容和加密秘钥的编码方式
     * @return
     */
    public static byte[] encrypt(String content, String password, String encoding) {
        try {
            return encrypt(content.getBytes(encoding), password.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)加密，并返回加密结果转换为base64字符串返回
     *
     * @param content  待加密的内容
     * @param password 加密秘钥
     * @return
     */
    public static String encryptToBase64(String content, String password) {
        byte[] res = encrypt(content, password);
        if (null != res) {
            return Base64.getEncoder().encodeToString(res);
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)加密，并返回加密结果转换为base64字符串返回
     *
     * @param content  待加密的内容
     * @param password 加密秘钥
     * @param encoding 待加密内容和加密秘钥的编码方式
     * @return
     */
    public static String encryptToBase64(String content, String password, String encoding) {
        byte[] res = encrypt(content, password, encoding);
        if (null != res) {
            return Base64.getEncoder().encodeToString(res);
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)加密，并返回加密后的字节数组
     *
     * @param content  待加密的内容
     * @param password 加密秘钥
     * @return
     */
    public static byte[] encrypt(byte[] content, byte[] password) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(password, "AES");
            Cipher cp = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cp.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
            return cp.doFinal(content);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)解密，并返回解密后的字节数组
     *
     * @param content  待解密的内容
     * @param password 解密秘钥
     * @return
     */
    public static byte[] decrypt(String content, String password) {
        return decrypt(content.getBytes(), password.getBytes());
    }

    /**
     * 对指定的base64编码内容使用指定秘钥进行AES(128)解密，并返回解密后的字节数组
     *
     * @param content  待解密的内容(base64)
     * @param password 解密秘钥
     * @return
     */
    public static byte[] decryptBase64(String content, String password) {
        return decrypt(Base64.getDecoder().decode(content), password.getBytes());
    }

    /**
     * 对指定的base64编码内容使用指定秘钥进行AES(128)解密，并将解密结果转换为指定编码的字符串返回
     *
     * @param content  待解密的内容(base64)
     * @param password 解密秘钥
     * @param encoding 返回结果的编码
     * @return
     */
    public static String decryptBase64ToString(String content, String password, String encoding) {
        byte[] res = decryptBase64(content, password);
        if (null != res) {
            try {
                return new String(res, encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)解密，并将解密结果转换为指定编码的字符串返回
     *
     * @param content  待解密的内容(base64)
     * @param password 解密秘钥
     * @param encoding 返回结果的编码
     * @return
     */
    public static String decryptToString(byte[] content, byte[] password, String encoding) {
        byte[] res = decrypt(content, password);
        if (null != res) {
            try {
                return new String(res, encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 对指定内容使用指定秘钥进行AES(128)解密，并返回解密后的字节数组
     *
     * @param content  待解密的内容
     * @param password 解密秘钥
     * @return
     */
    public static byte[] decrypt(byte[] content, byte[] password) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(password, "AES");
            Cipher cp = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cp.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));

            return cp.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
