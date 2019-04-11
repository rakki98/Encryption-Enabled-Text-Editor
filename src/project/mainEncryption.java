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
import java.io.BufferedReader;
    import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class mainEncryption {
 public static void main(String args[]) throws Exception
 {   Scanner sc=new Scanner(System.in);
     int key;
     System.out.println("Enter the key");
     key=sc.nextInt();
     String file="rakki";
	 InputStream inStr=new FileInputStream("/home/rakshith/NetBeansProjects/Project/"+file+".txt");
          OutputStream outStr=new FileOutputStream("/home/rakshith/NetBeansProjects/Project/rakki.enc");
          BufferedReader br = new BufferedReader(new FileReader("/home/rakshith/NetBeansProjects/Project/"+file+".txt"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                     System.out.println(line);
                    }
                    
	 encryption en=new encryption(key);
	 en.encrypt(inStr, outStr);
	 

	 
 }
}


