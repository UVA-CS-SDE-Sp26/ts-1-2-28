import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataFileHandlerTest {

    @Test
    void fileReturn_returnsCorrectContents() {
        assertEquals("FILE ONE CONTENT", DataFileHandler.fileReturn("01").trim());
        assertEquals("FILE TWO CONTENT", DataFileHandler.fileReturn("02").trim());
        assertEquals("FILE THREE CONTENT", DataFileHandler.fileReturn("03").trim());
    }
    @Test
    void fileReturn_invalidIndex() {
        assertEquals("", DataFileHandler.fileReturn("0"));
        assertEquals("", DataFileHandler.fileReturn("99"));

    }
    @Test
    void fileReturn_nonNumber() {
        assertEquals("", DataFileHandler.fileReturn("abc"));
    }
    @Test
    void fileList_returnsList() {
        List<String> list = DataFileHandler.fileList();
        assertEquals(3, list.size());
        assertTrue(list.contains("file1.txt"));
        assertTrue(list.contains("file2.txt"));
        assertTrue(list.contains("file3.txt"));
    }
}
