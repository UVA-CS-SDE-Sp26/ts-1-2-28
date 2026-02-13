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
        assertEquals(5, lines.length, "Should print 5 files");

        // check that each line has the correct format
        assertEquals("01 carnivore.cip", lines[0]);
        assertEquals("02 carnivore.txt", lines[1]);
        assertEquals("03 cointelpro.cip", lines[2]);
        assertEquals("04 cointelpro.txt", lines[3]);
        assertEquals("05 file1.txt", lines[4]);
    }

    @Test
    void runOneArgument() {
        // ensure the file "data/carnivore.txt" exists and Cipher default key "ciphers/1"
        ProgramControl.runOneArgument("05"); // "02" points to carnivore.txt
        String output = outContent.toString().trim();
        assertEquals("GJMF POF DPOUFOU", output); // matches decrypted text
    }

    @Test
    void runTwoArguments() {
        // ensure "mykey.txt" exists in ciphers folder
        ProgramControl.runTwoArguments("05", "ciphers/mykey.txt");
        String output = outContent.toString().trim();
        assertEquals("ILOH RQH FRQWHQW", output); // matches decrypted text using custom key
    }

}