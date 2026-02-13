//Team Member C: Program Controller

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProgramControl {

    // called by A when no arguments: list files
    public static void runNoArguments() {
        try {

            List<String> files = DataFileHandler.fileList();
            files.sort(String::compareToIgnoreCase);

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
            String readable = new Cipher().decrypt(content); // call instance method
            System.out.println(readable);
        } catch (IllegalArgumentException e) {
            System.out.println("error reading file: " + e.getMessage());
        }
    }

    // called by A when 2 arguments: file with custom key
    public static void runTwoArguments(String fileNumber, String fileKey) {
        try {
            String content = DataFileHandler.fileReturn(fileNumber);

            if (content.isEmpty()) {
                System.out.println("file is empty or not found");
                return;
            }

            String readable = Cipher.decrypt(content, parseKey(fileKey));
            System.out.println(readable);
        } catch (IllegalArgumentException e) {
            System.out.println("error reading or deciphering file: " + e.getMessage());
        }
    }

    private static String parseKey (String fileKey){
        String returnString = "";
        try (BufferedReader bufferedTestFileReader = new BufferedReader(new FileReader(fileKey))) {

            String line = "";
            while ((line = bufferedTestFileReader.readLine()) != null) {
                returnString = returnString + line;
                returnString = returnString + "\n";
            }
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }

        return returnString;
    }

}