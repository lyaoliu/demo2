package com.example.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * DesUtils class
 *
 * @author lyliu
 * @date 2019/05/27 18:18
 */
public class DesUtils {
    private static String strDefaultKey = "seeyonssokey";
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public DesUtils() {
    }

    public String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(this.encryptCipher.doFinal(strIn.getBytes()));
    }

    public String decrypt(String strIn) throws Exception {
        return new String(this.decryptCipher.doFinal(hexStr2ByteArr(strIn)));
    }

    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        StringBuffer sb = new StringBuffer(iLen * 2);

        for(int i = 0; i < iLen; ++i) {
            int intTmp;
            for(intTmp = arrB[i]; intTmp < 0; intTmp += 256) {
            }

            if (intTmp < 16) {
                sb.append("0");
            }

            sb.append(Integer.toString(intTmp, 16));
        }

        return sb.toString();
    }

    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];

        for(int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte)Integer.parseInt(strTmp, 16);
        }

        return arrOut;
    }

    private static Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8];

        for(int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
            arrB[i] = arrBTmp[i];
        }

        Key key = new SecretKeySpec(arrB, "DES");
        return key;
    }

    public static String encrypt(String strIn, String secretkey) throws Exception {
        Key key = getKey(secretkey.getBytes("utf-8"));
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, key);
        return byteArr2HexStr(cipher.doFinal(strIn.getBytes("utf-8")));
    }

    public static String decrypt(String strIn, String secretkey) throws Exception {
        Key key = getKey(secretkey.getBytes("utf-8"));
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, key);
        byte[] param = cipher.doFinal(hexStr2ByteArr(strIn));
        return new String(param, "utf-8");
    }

    public static void main(String[] args) {
        try {
            System.out.println("FUrxm58mGAZszPunCjzuZ55iZG0+zpc8XPc1GEO0GXc=".length());
            System.out.println("0yNUl68Q/MRkLKehGiUJMS3n2pbLBBONT/kGUTUJJYU=".length());
            String test = "yf1zfdxc_cyj";
            System.out.println("加密前的字符：" + test);
            System.out.println("加密后的字符：" + encrypt(test, strDefaultKey));
            System.out.println("解密后的字符：" + decrypt(encrypt(test, strDefaultKey), strDefaultKey));
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

}
