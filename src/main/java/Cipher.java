/**
 * Decryption Class
 */
interface Decryption {
    String decrypt (String data);
    String decrypt (String data, String key2);
}

public class Cipher implements Decryption {
    public String decrypt (String data){
        return "";
    }
    public String decrypt (String data, String key2){
        return "";
    }

    private char decryptCharacter (char x){
        return 'a';
    }
    private char decryptCharacter (char x, String key2){
        return 'a';
    }
}
