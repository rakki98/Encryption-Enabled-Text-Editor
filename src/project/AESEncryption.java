/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author rakshith
 */

import javax.crypto.*;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class AESEncryption {
    
    private static final String Algo1="AES";
    private  static Key enckey;
    
     public static String encrypt(String data,String keys) throws Exception{
      enckey=generateKey(keys);
     
    Cipher c = Cipher.getInstance("AES");
     c.init(Cipher.ENCRYPT_MODE, enckey);
     byte [] encVal=c.doFinal(data.getBytes());
     return new BASE64Encoder().encode(encVal);
     
     
     }
     
     
     
     public static String decrypt(String encryptedData,String keys) throws Exception{
     Key key=generateKey(keys);
     if(key.hashCode()==enckey.hashCode())
     {
            Cipher c=Cipher.getInstance(Algo1);
            c.init(Cipher.DECRYPT_MODE,key);
            byte []decodedValue=new BASE64Decoder().decodeBuffer(encryptedData);
            byte [] decValue=c.doFinal(decodedValue);
            return new String(decValue);
     }
     else
     {   System.out.println("error key" + key.hashCode() + enckey.hashCode());
             return "Invalid Key";
     }
     }
    private static Key generateKey(String keys) throws Exception{
       
       MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(keys.getBytes());
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        char  hex[]=hexString.toString().toCharArray();
        
        String key=String.copyValueOf(hex, 0,16 );
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        
        return secretKeySpec;
    }
    
    
    public static void main(String args[]) throws Exception
    {   Scanner sc=new Scanner(System.in);
        String encrypt="My name is Rakshith Gowda GS";
        System.out.println("Before Encryption "+ encrypt);
        System.out.println("Enter the key to encrypt");
        
        String key=sc.next();
        String encrypted=encrypt(encrypt,"rakki123");
         System.out.println("After Encryption "+ encrypted);
        System.out.println("Enter the key to decrypt");
        String key2=sc.next();

        
        String decrypted=decrypt(encrypted,"rakki123");
        System.out.println("After Decryption "+ decrypted);
    
}
}