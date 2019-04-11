import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ase3{
  private static final String ALGO = "AES";
  private static final byte[] keyValue =
            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public static String encrypt(String data,String keys) throws Exception {
        Key key = generateKey(keys);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData,String keys) throws Exception {
        Key key = generateKey(keys);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey(String keys) throws Exception {
        char []salt="rakki Nane".toCharArray(); 
        while(keys.length()<16)
         {
             int len=16-keys.length();
             for(int i=0;i<len;i++)
             {
               keys+=salt[i];
             }
         }
        
        return new SecretKeySpec(keys.getBytes("UTF-8"), ALGO);
    }
   public static void main(String args[]) throws Exception
   {
      System.out.println(encrypt("rakki","1234567891234"));
      String a=encrypt("rakki","1234567891234");
      System.out.println(decrypt(a,"1234567891234"));
      
      
      String a1="rakki";
      System.out.println(a1.getBytes());
      String a2="rakki";
      System.out.println(a2.getBytes());
      
   }
}
