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
        return decrypt (data, key);
    }
    public static String decrypt (String data, String key){
        if (verifyKey(key)) {
            String decryptString = "";
            decryptString = decryptString + decryptCharacter(data.charAt(0), key);
            return "";
        }
        else {
            return data; //include key validation here...
        }
    }
    private static char decryptCharacter (char x, String key){
//If character is not in key, just return it
        return 'a';
    }

    private static boolean verifyKey (String key2) {
/*
look for the newline, count the index, check the first 10 characters to be uppercase (then check
index 26-36 to be lower case or numbers, if there are enough characters before the newline),
lowercase (check 26-36 to be numbers if they don't run into the newline), or numbers; lowercase
and numbers check for the uppercase and each other up until the newline too (so the default key is
uppercase, lowercase, numbers but the provided keys could be just one of each or have 2 or 3 in
any order). Keys with incomplete lowercase sections (or uppercase, or numbers) have all those
characters ignored when that key is applied (and the decrypt method accounts for that)
 */
        return false;
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
