import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // capture console output
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // restore normal console
    }

    @Test
    void runNoArguments() {
        ProgramControl.runNoArguments(); // run the method

        String output = outContent.toString().trim(); // capture printed output
        String[] lines = output.split("\\r?\\n"); // split by newlines

        // should be exactly 3 lines (for 3 files)
        assertEquals(3, lines.length, "Should print 3 files");

        // check that each line has the correct format
        assertEquals("01 file1.txt", lines[0]);
        assertEquals("02 file2.txt", lines[1]);
        assertEquals("03 file3.txt", lines[2]);
    }

    @Test
    void runOneArgument() {
        ProgramControl.runOneArgument("01");

        String output = outContent.toString().trim();

        // decrypted content matches expected plaintext
        assertEquals("FILE ONE CONTENT", output);
    }

    //fix this!!!
    /*
    @Test
    void runTwoArguments() {
        ProgramControl.runTwoArguments("01", "mykey.txt");
        String output = outContent.toString().trim();

        // Example check: decrypted text should reflect using the custom key
        assertEquals("EXPECTED DECRYPTED CONTENT", output);;
    }

     */
}