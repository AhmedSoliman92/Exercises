import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncryptFile {

    public static void main(String[] args) {
        try{
            Key key= KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher=Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            File file=Path.of("res/text.txt").toFile();
            File cipherFile=Path.of("res/cipheredText.txt").toFile();
            if (cipherFile.exists()){
                cipherFile.delete();
            }
            try(
                    FileInputStream fileInputStream=new FileInputStream(file);
                    FileOutputStream fileOutputStream=new FileOutputStream(cipherFile);
                    CipherOutputStream cipherOutputStream=new CipherOutputStream(fileOutputStream,cipher)){
                        cipherOutputStream.write(cipher.getIV());
                        byte[] bytes=new byte[1024];
                        int length;
                        while((length=fileInputStream.read(bytes))>0){
                            cipherOutputStream.write(bytes,0,length);
                        }
                    }
        }catch(NoSuchAlgorithmException noSuchAlgorithmException){
            noSuchAlgorithmException.printStackTrace();
        }catch (NoSuchPaddingException noSuchPaddingException){
            noSuchPaddingException.printStackTrace();
        }catch(InvalidKeyException invalidKeyException){
            invalidKeyException.printStackTrace();
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
