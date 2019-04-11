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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.*;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class aesfile {
    
    private static final String Algo1="AES";
    private  static Key enckey;
      private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
 
    public static void encrypt1(String key1, File inputFile, File outputFile)  throws Exception
            { enckey=generateKey(key1);
        doCrypto(Cipher.ENCRYPT_MODE, enckey, inputFile, outputFile);
    }
 
    public static void decrypt1(String key1,String key2 ,File inputFile, File outputFile) throws Exception
             {  Key dekey=generateKey(key1);
                 String enc=sha256(key1);
                 String dec=sha256(key2);
                 System.err.println(enc + ' ' +dec);
           
                
                 if(enc.equals(dec))
                 {   
                        doCrypto(Cipher.DECRYPT_MODE, dekey, inputFile, outputFile);
                 }
                 else
                 {
                   System.out.println("error key" );
                 }
             
     }
 
    private static void doCrypto(int cipherMode, Key key, File inputFile,
            File outputFile)   {
        try {
            
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, key);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        }
        catch (Exception e)
        {
            System.err.println(e);      
        }
    }

    
     public static String encrypt(String data,String keys) throws Exception{
      enckey=generateKey(keys);
     
    Cipher c = Cipher.getInstance("AES");
     c.init(Cipher.ENCRYPT_MODE, enckey);
     byte [] encVal=c.doFinal(data.getBytes());
     return new BASE64Encoder().encode(encVal);
     
     
     }
     
     
     
     public static String decrypt(String encryptedData,String keys) throws Exception{
     Key key=generateKey(keys);
     if(key==enckey)
     {
            Cipher c=Cipher.getInstance(Algo1);
            c.init(Cipher.DECRYPT_MODE,key);
            byte []decodedValue=new BASE64Decoder().decodeBuffer(encryptedData);
            byte [] decValue=c.doFinal(decodedValue);
            return new String(decValue);
     }
     else
     {
             return "Invalid Key";
     }
     }
     
     
     public static String sha256(String base) throws Exception {
   
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        char  hex[]=hexString.toString().toCharArray();
        
        String key=String.copyValueOf(hex, 0,16 );
        return key;            
}
    private static Key generateKey(String keys) throws Exception {
       
        String key=sha256(keys);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        
        return secretKeySpec;
    }
    
    
    public static void main(String args[]) throws Exception
    {   

        Scanner sc=new Scanner(System.in);
       System.out.println("Enter the key to encrypt");
       String key=sc.next();
        File inputFile = new File("/home/rakshith/NetBeansProjects/Project/src/project/document.txt");
        File encryptedFile = new File("/home/rakshith/NetBeansProjects/Project/src/project/document1.encrypted");
        File decryptedFile = new File("/home/rakshith/NetBeansProjects/Project/src/project/document12.decrypted");
        encrypt1(key, inputFile, encryptedFile);
        
       System.out.println("Enter the key to decrypt");
       String key2=sc.next();
        
        decrypt1(key2,key, encryptedFile, decryptedFile);
}
}