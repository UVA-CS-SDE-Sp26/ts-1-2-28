import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Decryption Class
 */
/*interface Decryption {
    String decrypt (String data, String key); //run this with the default key too
}*/

public class Cipher {
    public static String decrypt (String data) {
        String key = fileReturn("1");
        key = key.substring (0,key.length() - 1);//peculiarity of the file handler, remove the last newline
        return decrypt(data, key);
    }

    //for a valid key, returns a decrypted string. for an invalid key, decrypts using the default key
    public static String decrypt (String data, String key){
        if (verifyKey(key)) {
            String decryptString = "";
            int i = 0;
            while (i <= data.length() - 1){
                if (i + 2 >= data.length()){
                    decryptString = decryptString + decryptCharacter(data.charAt(i), key);
                    i++;
                }
                else if (data.substring(i,i+2).equals("\n")){
                    decryptString += data.substring(i,i+2);
                    i = i + 2;
                }
                else if (data.charAt(i) == '\\') {
                    decryptString += data.substring(i,i+2);
                    i = i + 2;
                }
                else {
                    decryptString = decryptString + decryptCharacter(data.charAt(i), key);
                    i++;
                }

            }
            return decryptString;
        }
        else {
            return decrypt(data);
        }
    }
    private static char decryptCharacter (char x, String key){
        //If character is not in key, just return it, otherwise decrypt it
        String secureKey = key.substring(0,key.indexOf("\n"));
        if (secureKey.indexOf(x) != -1) {
            if (((int) x < 123) && ((int) x > 47)) {
                try {
                    if ((int) x < 58) {//x is a number
                        return key.charAt(key.indexOf("\n") + 1 + secureKey.indexOf(x));
                    } else if (((int) x < 91) && ((int) x > 64)) { // x is uppercase
                        return key.charAt(key.indexOf("\n") + 1 + secureKey.indexOf(x));
                    } else if ((int) x > 96) {//x is lowercase
                        return key.charAt(key.indexOf("\n") + 1 + secureKey.indexOf(x));
                    }
                }
                catch (StringIndexOutOfBoundsException e) {
                    return x;
                }
            }
        }
        return x;
    }

    //return true if the key is valid, return false otherwise
    public static boolean verifyKey(String key2) {
        int newlineIndex = key2.indexOf("\n");

        if (newlineIndex != -1) {
            if (key2.substring(0, newlineIndex).length() != key2.substring(newlineIndex + 1).length())
                return false;
            if (key2.startsWith("1234567890")){
                String remaining = key2.substring(10,newlineIndex);
                if (remaining.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
                    String stillRemaining = remaining.substring(26,newlineIndex - 10);
                    return stillRemaining.equals("abcdefghijklmnopqrstuvwxyz") || stillRemaining.isEmpty();
                }
                else if (remaining.startsWith("abcdefghijklmnopqrstuvwxyz")){
                    String stillRemaining = remaining.substring(26,newlineIndex - 10);
                    return stillRemaining.equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ") || stillRemaining.isEmpty();
                }
                else if (remaining.isEmpty()) {return true;}
                else {return false;}
            }
            else if (key2.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
                String remaining = key2.substring(26,newlineIndex);
                if (remaining.startsWith("1234567890")) {
                    String stillRemaining = remaining.substring(10, newlineIndex - 26);
                    return stillRemaining.equals("abcdefghijklmnopqrstuvwxyz") || stillRemaining.isEmpty();
                }
                else if (remaining.startsWith("abcdefghijklmnopqrstuvwxyz")) {
                    String stillRemaining = remaining.substring(26, newlineIndex - 26);
                    return stillRemaining.equals("1234567890") || stillRemaining.isEmpty();
                }
                else if (remaining.isEmpty()) {return true;}
                else {return false;}
            }
            else if (key2.startsWith("abcdefghijklmnopqrstuvwxyz")){
                String remaining = key2.substring(26,newlineIndex);
                if (remaining.startsWith("1234567890")) {
                    String stillRemaining = remaining.substring(10, newlineIndex - 26);
                    return stillRemaining.equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ") || stillRemaining.isEmpty();
                }
                else if (remaining.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
                    String stillRemaining = remaining.substring(26, newlineIndex - 26);
                    return stillRemaining.equals("1234567890") || stillRemaining.isEmpty();
                }
                else if (remaining.isEmpty()) {return true;}
                else {return false;}
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    private static String fileReturn(String n) {//from DataFileHandler class, because that was hardcoded to only run from the docs folder
        // use n -> to int, find number in list from fileList
        // return data from that file
        String directoryPath = "./ciphers";
        String returnString = "";
        try {
            int index = Integer.parseInt(n)-1;
            List<String> files = fileList();

            if (index < 0 || index >= files.size()) {
                System.out.println("Invalid file number");
                return "";
            }

            File targetFile = new File(directoryPath, files.get(index));
            try (BufferedReader bufferedTestFileReader = new BufferedReader(new FileReader(targetFile))) {

                String line = "";
                while ((line = bufferedTestFileReader.readLine()) != null) {
                    returnString = returnString + line;
                    returnString = returnString + "\n";
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file" +  e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid file number format");
        }

        return returnString;
    }

    private static List<String> fileList() {//from DataFileHandler class
        String directoryPath = "./ciphers";
        File dir  = new File(directoryPath);
        String[] filesNames = dir.list();

        if (filesNames == null) {
            return Collections.emptyList();
        }

        List<String> fileList = new ArrayList<>();
        for (String fileName : filesNames) {
            fileList.add(fileName);
        }

        return fileList;

    }
}
