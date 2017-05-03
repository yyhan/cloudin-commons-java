package com.cloudin.commons.security;

import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.*;

/**
 * Created by YFHan on 2017/4/4 0004.
 */
public class AESTest {
    @Test
    public void encrypt() throws Exception {
        String sourceTxt = "中国china密码password~！@#￥%……&*（）——+";
        String password = "中国china密码password~！@#￥%……&*（）——+";
        String expectedTxt = "VI5vW0qvjJa/QBlxNTg7glgvnWuNcJiEuXQddUPyg4MuLRoDTvIay5gigupJact4g1xiWkEaHU+vNEeZ/lRzUw==";


        assertEquals(expectedTxt, Base64.getEncoder().encodeToString(AES.encrypt(sourceTxt.getBytes(), password.getBytes())));
        assertEquals(expectedTxt, Base64.getEncoder().encodeToString(AES.encrypt(sourceTxt, password)));
        assertEquals(expectedTxt, Base64.getEncoder().encodeToString(AES.encrypt(sourceTxt, password, "UTF-8")));

        byte[] encrypts = AES.encrypt(sourceTxt.getBytes(), password.getBytes());
        String encryptsBase64 = Base64.getEncoder().encodeToString(encrypts);

        assertEquals(sourceTxt, new String(AES.decrypt(encrypts, password.getBytes("UTF-8"))));
        assertEquals(sourceTxt, new String(AES.decryptBase64ToString(encryptsBase64, password, "UTF-8")));
    }

    @Test
    public void decrypt() throws Exception {
    
    }

}