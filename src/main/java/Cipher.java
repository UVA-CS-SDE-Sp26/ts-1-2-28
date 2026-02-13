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
        return decrypt(data, key);
    }
    public static String decrypt (String data, String key){
        if (verifyKey(key)) {
            String decryptString = "";
            for (int i = 0; i < data.length() - 1; i++){
                decryptString = decryptString + decryptCharacter(data.charAt(i), key);
            }
            return decryptString;
        }
        else {
            return data;
        }
    }
    private static char decryptCharacter (char x, String key){
        //If character is not in key, just return it, otherwise decrypt it
        if (key.indexOf(x) != -1) {
            return key.charAt(key.indexOf("/n") + key.indexOf(x));
        }
        else {
            return x;
        }
    }

    private static boolean verifyKey(String key2) {
        int newlineIndex = key2.indexOf("/n");
        if (newlineIndex != -1) {
            if (key2.startsWith("1234567890")){
                String remaining = key2.substring(10,newlineIndex);
                if (remaining.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
                    String stillRemaining = remaining.substring(26,newlineIndex - 10);
                    return stillRemaining.equals("abcdefghijklmnopqrstuvwxyz");
                }
                else if (remaining.startsWith("abcdefghijklmnopqrstuvwxyz")){
                    String stillRemaining = remaining.substring(26,newlineIndex - 10);
                    return stillRemaining.equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                }
                else {return false;}
            }
            else if (key2.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
                String remaining = key2.substring(26,newlineIndex);
                if (remaining.startsWith("1234567890")) {
                    return remaining.substring(26, newlineIndex - 26).equals("abcdefghijklmnopqrstuvwxyz");
                }
                else if (remaining.startsWith("abcdefghijklmnopqrstuvwxyz")) {
                    return remaining.substring(26, newlineIndex - 26).equals("1234567890");
                }
                else {return false;}
            }
            else if (key2.startsWith("abcdefghijklmnopqrstuvwxyz")){
                String remaining = key2.substring(26,newlineIndex);
                if (remaining.startsWith("1234567890")) {
                    return remaining.substring(26, newlineIndex - 26).equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                }
                else if (remaining.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
                    return remaining.substring(26, newlineIndex - 26).equals("1234567890");
                }
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
