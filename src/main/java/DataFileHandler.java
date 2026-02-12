import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;

public class DataFileHandler implements FileHandler {
    private final String directoryPath;

    public DataFileHandler() {
        this.directoryPath = "./data";
    }

    public DataFileHandler(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public String fileReturn(String n) {
        // use n -> to int, find number in list from fileList
        // return data from that file
        try {
            int index = Integer.parseInt(n)-1;
            List<String> files = fileList();

            if (index < 0 || index >= files.size()) {
                System.err.println("Invalid file number");
                return "";
            }
            Path filePath = Paths.get(directoryPath, files.get(index));
            return new String(Files.readAllBytes(filePath));

        } catch (NumberFormatException e) {
            System.err.println("Invalid file number format");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        return "";
    }

    @Override
    public List<String> fileList() {
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
