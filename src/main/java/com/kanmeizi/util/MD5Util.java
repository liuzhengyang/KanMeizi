package com.kanmeizi.util;

import java.security.MessageDigest;


public class MD5Util {
//    private static final String[] hexDigits = {
//            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
//            "a", "b", "c", "d", "e", "f"};
//
//
//    private String byteArrayToHexString(byte[] b) {
//
//        StringBuffer resultSb = new StringBuffer();
//
//        for (int i = 0; i < b.length; i++) {
//
//            resultSb.append(byteToHexString(b[i]));
//
//        }
//
//        return resultSb.toString();
//
//    }
//
//
//    private String byteToHexString(byte b) {
//
//        int n = b;
//
//        if (n < 0) {
//
//            n += 256;
//
//        }
//
//        int d1 = n / 16;
//
//        int d2 = n % 16;
//
//        return hexDigits[d1] + hexDigits[d2];
//
//    }
//
//
//    public String MD5Encode(String originString) {
//
//        String resultString = "";
//
//        try {
//
//            MessageDigest md = MessageDigest.getInstance("MD5");
//
//            resultString = byteArrayToHexString(md.digest(originString.getBytes()));
//
//        } catch (Exception ex) {
//
//            ex.printStackTrace();
//
//        }
//
//        return resultString;
//
//    }
//
//    public static void main(String[] args){
//        System.out.println(new MD5Util().MD5Encode("1"));
//
//    }

    public final static String encrypt(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

}
