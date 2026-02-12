import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;

public class DataFileHandler {

    public static String fileReturn(String n) {
        // use n -> to int, find number in list from fileList
        // return data from that file
        String directoryPath = "./data";
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

    public static List<String> fileList() {
        String directoryPath = "./data";
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
