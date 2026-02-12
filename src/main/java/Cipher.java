/**
 * Decryption Class
 */
interface Decryption {
    String decrypt (String data, String key); //run this with the default key too
}

public class Cipher implements Decryption {
    public String decrypt (String data, String key){
        return ""; //include key validation here...
    }
    private char decryptCharacter (char x, String key){
        return 'a';
    }

    private boolean verifyKey (String key2) {

        return false;
    }
}
