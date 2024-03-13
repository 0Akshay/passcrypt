package passcrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import java.nio.charset.StandardCharsets;  

public class DesProgram {
    static String encryptThis(String m, String p) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String message = m;
        byte[] myMessage = message.getBytes();

        SecretKeyFactory MyKeyFactory = SecretKeyFactory.getInstance("DES");
        String Password = p;
        byte[] mybyte = Password.getBytes();
        DESKeySpec myMaterial = new DESKeySpec(mybyte);
        SecretKey myDesKey = MyKeyFactory.generateSecret(myMaterial);

        Cipher myCipher = Cipher.getInstance("DES");

        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] myEncryptedBytes = myCipher.doFinal(myMessage);

        String encrypteddata = new String(myEncryptedBytes, StandardCharsets.ISO_8859_1);

        return encrypteddata;
    }

    static String decryptThis(String e, String p) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] myEncryptedBytes = e.getBytes(StandardCharsets.ISO_8859_1);

        SecretKeyFactory MyKeyFactory = SecretKeyFactory.getInstance("DES");
        String Password = p;
        byte[] mybyte = Password.getBytes();
        DESKeySpec myMaterial = new DESKeySpec(mybyte);
        SecretKey myDesKey = MyKeyFactory.generateSecret(myMaterial);

        Cipher myCipher = Cipher.getInstance("DES");
        
        //setting decryption mode
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] myDecryptedBytes = myCipher.doFinal(myEncryptedBytes);

        String decrypteddata = new String(myDecryptedBytes);

        return decrypteddata;
    }
}
