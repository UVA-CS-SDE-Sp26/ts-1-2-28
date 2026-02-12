import java.util.List;

public interface FileHandler {

    /**
     * Returns a list of filenames available in the data directory.
     *
     *
     */
    List<String> fileList();

    /**
     * Returns the contents of the file corresponding to the given number.
     * If the request is invalid, returns an empty string.
     */
    String fileReturn(String fileNumber);
}
