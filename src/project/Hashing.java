/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 *
 * @author rakshith
 */
public class Hashing {
    public static String sha256(String base) {
    try{
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
       
//        System.out.println(key + hex.length + ' '+ key.length() );
//        System.out.println(hexString.length() );
System.out.println(key);
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
    public static void main(String args[]){
        
        String msg=sha256("Rakki");
        System.out.println(msg);
        String msg1=sha256("Rakki");
        System.out.println(msg1);
    
    }
    
}
