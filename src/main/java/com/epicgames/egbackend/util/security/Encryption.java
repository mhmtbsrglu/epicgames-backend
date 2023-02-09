package com.epicgames.egbackend.util.security;


import jakarta.xml.bind.DatatypeConverter;
import lombok.experimental.UtilityClass;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Objects;

@UtilityClass
public class Encryption {

    public int salt_length = 16;
    public int iv_length = 12;

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        System.out.println(encrypt("epicgames"));
        System.out.println(decryptPassword("8DE30E9BA85EA649A6F6FC255BF7A6D45531B41EEF880186F3A5205BEE975A4A3BC3E345A3B538ADF9A01275174235F6066DF85CDA"));
    }

    public String encrypt(String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        //Rastgele iv_length uzunluğunda tek kullanımlık sayıyı iv için üret
        byte[] iv = getRandomNonce(iv_length);
        //Rastgele iv_length uzunluğunda tek kullanımlık sayıyı salt için üret. Tuzlama işlemi için kullanılacak
        byte[] salt = getRandomNonce(salt_length);
        byte[] encryptedText = doEncryption(Cipher.ENCRYPT_MODE,password.getBytes(), iv,salt);
        byte[] encryptedTextIv = ByteBuffer.allocate(iv.length + salt.length + encryptedText.length)
                .put(iv)
                .put(salt).put(encryptedText).array();
        return DatatypeConverter.printHexBinary(encryptedTextIv);
    }

    public static String decryptPassword(String encPassword) throws InvalidAlgorithmParameterException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] encryptedTextWithIv = DatatypeConverter.parseHexBinary(encPassword);
        ByteBuffer bb = ByteBuffer.wrap(encryptedTextWithIv);
        byte[] iv = new byte[iv_length];
        bb.get(iv);

        byte[] salt = new byte[salt_length];
        bb.get(salt);

        byte[] encryptedText = new byte[bb.remaining()];
        bb.get(encryptedText);

        return new String(Objects.requireNonNull(doEncryption(Cipher.DECRYPT_MODE, encryptedText, iv, salt)));
    }

    /*
    Nonce = Kriptografide "number used only once" tek kullanımlık sayı olarak bilinen rastgele sayılardır.
     */
    public byte[] getRandomNonce(int length){
        byte[] nonce = new byte[length];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }


    private static byte[] doEncryption(int mode, byte[] input, byte[] iv, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        KeySpec spec = new PBEKeySpec("SecretKeySecretKey".toCharArray(), salt, 65536, 256);
        SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        GCMParameterSpec paramSpec = new GCMParameterSpec(128, iv);

        cipher.init(mode, secretKey, paramSpec);

        return cipher.doFinal(input);
    }



}
