//Team Member C: Program Controller

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProgramControl {

    // called by A when no arguments: list files
    public static void runNoArguments() {
        try {

            List<String> files = DataFileHandler.fileList();

            if (files.isEmpty()) {
                System.out.println("no files found");
                return;
            }

            for (int i = 0; i < files.size(); i++) {
                System.out.printf("%02d %s%n", i + 1, files.get(i));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("error listing files: " + e.getMessage());
        }
    }

    // called by A when 1 argument: file with default key
    public static void runOneArgument(String fileNumber) {
        try {
            String content = DataFileHandler.fileReturn(fileNumber);

            if (content.isEmpty()) {
                System.out.println("file is empty or not found");
                return;
            }

            // Decipher using default key
            String readable = Cipher.decrypt(content); // call instance method
            System.out.println(readable);
        } catch (IllegalArgumentException e) {
            System.out.println("error reading file: " + e.getMessage());
        }
    }

    // called by A when 2 arguments: file with custom key
    public static void runTwoArguments(String fileNumber, File fileKey) {
        try {
            String content = DataFileHandler.fileReturn(fileNumber);

            if (content.isEmpty()) {
                System.out.println("file is empty or not found");
                return;
            }
            String alternateKey = parseKey(new File("ciphers", fileKey.getName()));
            //String alternateKey = parseKey(fileKey);
            if (!Cipher.verifyKey(alternateKey)){
                System.out.println("the alternate key is invalid or not in the correct format)");
                return;
            }
            String readable = Cipher.decrypt(content, alternateKey);
            System.out.println(readable);
        } catch (IllegalArgumentException e) {
            System.out.println("error reading or deciphering file: " + e.getMessage());
        }
    }

    private static String parseKey (File fileKey){
        String returnString = "";
        try (BufferedReader bufferedTestFileReader = new BufferedReader(new FileReader(fileKey))) {

            String line = "";
            while ((line = bufferedTestFileReader.readLine()) != null) {
                returnString = returnString + line;
                returnString = returnString + "\n";
            }
            if (returnString.charAt(returnString.length()-1) == '\n'){
                returnString = returnString.substring(0, returnString.length() - 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }

        return returnString;
    }

}