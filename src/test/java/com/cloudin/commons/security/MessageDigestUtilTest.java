package com.cloudin.commons.security;

import com.cloudin.commons.util.Bytes;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YFHan on 2017/4/3 0003.
 */
public class MessageDigestUtilTest {

    @Test
    public void md5() throws Exception {
        String sourceTxt = "md5";
        byte[] sourceTxtBytes = "md5".getBytes();
        String expectedTxt = "1bc29b36f623ba82aaf6724fd3b16718";
        assertNull(MessageDigestUtil.MD5.digest(null));
        assertNull(MessageDigestUtil.MD5.digest(null, "UTF-8"));
        assertNull(MessageDigestUtil.MD5.digestToString(null));
        assertNull(MessageDigestUtil.MD5.digestToString(null, "UTF-8"));
        assertNull(MessageDigestUtil.MD5.digestBytes(null));
        assertNull(MessageDigestUtil.MD5.digestBytesToString(null));

        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.MD5.digest(sourceTxt)));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.MD5.digest(sourceTxt, "UTF-8")));
        assertEquals(expectedTxt, MessageDigestUtil.MD5.digestToString(sourceTxt));
        assertEquals(expectedTxt, MessageDigestUtil.MD5.digestToString(sourceTxt, "UTF-8"));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.MD5.digestBytes(sourceTxtBytes)));
        assertEquals(expectedTxt, MessageDigestUtil.MD5.digestBytesToString(sourceTxtBytes));

    }

    @Test
    public void sha1() throws Exception {
        String sourceTxt = "sha1";
        byte[] sourceTxtBytes = "sha1".getBytes();
        String expectedTxt = "415ab40ae9b7cc4e66d6769cb2c08106e8293b48";
        assertNull(MessageDigestUtil.SHA1.digest(null));
        assertNull(MessageDigestUtil.SHA1.digest(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA1.digestToString(null));
        assertNull(MessageDigestUtil.SHA1.digestToString(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA1.digestBytes(null));
        assertNull(MessageDigestUtil.SHA1.digestBytesToString(null));

        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA1.digest(sourceTxt)));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA1.digest(sourceTxt, "UTF-8")));
        assertEquals(expectedTxt, MessageDigestUtil.SHA1.digestToString(sourceTxt));
        assertEquals(expectedTxt, MessageDigestUtil.SHA1.digestToString(sourceTxt, "UTF-8"));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA1.digestBytes(sourceTxtBytes)));
        assertEquals(expectedTxt, MessageDigestUtil.SHA1.digestBytesToString(sourceTxtBytes));
    }

    @Test
    public void sha256() throws Exception {
        String sourceTxt = "sha256";
        byte[] sourceTxtBytes = "sha256".getBytes();
        String expectedTxt = "5d5b09f6dcb2d53a5fffc60c4ac0d55fabdf556069d6631545f42aa6e3500f2e";
        assertNull(MessageDigestUtil.SHA256.digest(null));
        assertNull(MessageDigestUtil.SHA256.digest(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA256.digestToString(null));
        assertNull(MessageDigestUtil.SHA256.digestToString(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA256.digestBytes(null));
        assertNull(MessageDigestUtil.SHA256.digestBytesToString(null));

        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA256.digest(sourceTxt)));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA256.digest(sourceTxt, "UTF-8")));
        assertEquals(expectedTxt, MessageDigestUtil.SHA256.digestToString(sourceTxt));
        assertEquals(expectedTxt, MessageDigestUtil.SHA256.digestToString(sourceTxt, "UTF-8"));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA256.digestBytes(sourceTxtBytes)));
        assertEquals(expectedTxt, MessageDigestUtil.SHA256.digestBytesToString(sourceTxtBytes));
    }

    @Test
    public void sha512() throws Exception {
        String sourceTxt = "sha512";
        byte[] sourceTxtBytes = "sha512".getBytes();
        String expectedTxt = "1f9720f871674c18e5fecff61d92c1355cd4bfac25699fb7ddfe7717c9669b4d085193982402156122dfaa706885fd64741704649795c65b2a5bdec40347e28a";
        assertNull(MessageDigestUtil.SHA512.digest(null));
        assertNull(MessageDigestUtil.SHA512.digest(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA512.digestToString(null));
        assertNull(MessageDigestUtil.SHA512.digestToString(null, "UTF-8"));
        assertNull(MessageDigestUtil.SHA512.digestBytes(null));
        assertNull(MessageDigestUtil.SHA512.digestBytesToString(null));

        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA512.digest(sourceTxt)));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA512.digest(sourceTxt, "UTF-8")));
        assertEquals(expectedTxt, MessageDigestUtil.SHA512.digestToString(sourceTxt));
        assertEquals(expectedTxt, MessageDigestUtil.SHA512.digestToString(sourceTxt, "UTF-8"));
        assertEquals(expectedTxt, Bytes.toHexLowerString(MessageDigestUtil.SHA512.digestBytes(sourceTxtBytes)));
        assertEquals(expectedTxt, MessageDigestUtil.SHA512.digestBytesToString(sourceTxtBytes));
    }


}