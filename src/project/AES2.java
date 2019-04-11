package project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;



public class AES2 {

  public static final String CIPHER_ALGORITHM = "AES";
  public static final String KEY_ALGORITHM = "AES";
  public static final String PASSWORD_HASH_ALGORITHM = "SHA-256";
  
  private File file;
  private Provider provider;
  
  public AES2(File file) {
    this.file = file;
    
  }
  
  public InputStream getInputStream(char[] password) throws NoSuchAlgorithmException, NoSuchPaddingException, FileNotFoundException, InvalidKeyException, UnsupportedEncodingException {
    Cipher cipher = buildCipher(password, Cipher.DECRYPT_MODE);
    return new CipherInputStream(new FileInputStream(file), cipher);
  }

  public OutputStream getOutputStream(char[] password) throws NoSuchAlgorithmException, NoSuchPaddingException, FileNotFoundException, InvalidKeyException, UnsupportedEncodingException {
    Cipher cipher = buildCipher(password, Cipher.ENCRYPT_MODE);
    return new CipherOutputStream(new FileOutputStream(file), cipher);
  }
  
  private Cipher buildCipher(char[] password, int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    Key key = buildKey(password);
    cipher.init(mode, key);
    return cipher;
  }

  private Key buildKey(char[] password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest digester = MessageDigest.getInstance(PASSWORD_HASH_ALGORITHM);
    digester.update(String.valueOf(password).getBytes("UTF-8"));
    byte[] key = digester.digest();
    SecretKeySpec spec = new SecretKeySpec(key, KEY_ALGORITHM);
    return spec;
  }


}