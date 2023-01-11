package com.works.services;

import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TinkEncDec {

    @Value("${tink.key128Bit}")
    private String key128Bit;

    @Value("${tink.associatedData}")
    private String associatedData;

    public String encrypt( String plainText ) {

        String cipherText = "";
        try {
            long start = System.currentTimeMillis();
            AesGcmJce aesGcmJce = new AesGcmJce(key128Bit.getBytes());
            byte[] byteEncrypt = aesGcmJce.encrypt(plainText.getBytes(), associatedData.getBytes());
            cipherText = new String(byteEncrypt, "ISO-8859-1");
            long end = System.currentTimeMillis();
            long bettween = end - start;
            System.out.println(bettween);
        } catch (Exception e) {
            System.err.println("Encrypt Error :" + e);
        }
        System.out.println(cipherText);
        cipherText = Base64.encode(cipherText.getBytes());
        System.out.println(cipherText);
        return cipherText;
    }

    public String decrypt( String cipherText ) {
        String planText = "";
        try {
            cipherText = new String( Base64.decode(cipherText) );
            byte[] convertEncode = cipherText.getBytes("ISO-8859-1");
            AesGcmJce aesGcmJce = new AesGcmJce(key128Bit.getBytes());
            byte[] descBytes = aesGcmJce.decrypt(convertEncode, associatedData.getBytes());
            planText = new String(descBytes);
        } catch (Exception e) {
            System.err.println("decrypt Error : " + e);
        }
        return planText;
    }


}
