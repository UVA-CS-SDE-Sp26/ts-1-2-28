import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {

    // tests the one argument inputs
    @Test
    void oneDigitNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] oneDigit = new String[]{"5"};
        TopSecret.main(oneDigit);
        assertTrue(out.toString().contains("error: file number must be two digits"));
    }

    @Test
    void threeDigitNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] threeDigits = new String[]{"553"};
        TopSecret.main(threeDigits);
        assertTrue(out.toString().contains("error: file number must be two digits"));
    }

    @Test
    void notaNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] words = new String[]{"tomorrowbytogether"};
        TopSecret.main(words);
        assertTrue(out.toString().contains("error: file number must be two digits"));
    }

    // tests the two argument inputs
    @Test
    void notaValidFile() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] invalidFile = new String[]{"05", "seventeen.csv"};
        TopSecret.main(invalidFile);
        assertTrue(out.toString().contains("error: decipher key must be a string that ends in .txt (ex. key.txt)"));
    }

    @Test
    void notaValidNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] invalidFile = new String[]{"5", "seventeen.txt"};
        TopSecret.main(invalidFile);
        assertTrue(out.toString().contains("error: file number must be two digits"));
    }

    @Test
    void inavlidNumberandFile() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] invalidFile = new String[]{"5", "seventeen.csv"};
        TopSecret.main(invalidFile);
        assertTrue(out.toString().contains("error: file number must be two digits (ex. 01, 10 AND decipher key must be a string that ends in .txt (ex. key.txt)"));
    }

    // tests more than two argument inputs
    @Test
    void moreThanTwoCorrectArguments() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] invalidFile = new String[]{"05", "seventeen.csv", "06"};
        TopSecret.main(invalidFile);
        assertTrue(out.toString().contains("error: too many arguments. options are:\n" + "java TopSecret\n" + "java TopSecret [number]\n" + "java TopSecret [number] [decipherkey.txt]"));
    }

    @Test
    void moreThanTwoIncorrectArguments() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] invalidFile = new String[]{"5", "seventeen.csv", "6"};
        TopSecret.main(invalidFile);
        assertTrue(out.toString().contains("error: too many arguments. options are:\n" + "java TopSecret\n" + "java TopSecret [number]\n" + "java TopSecret [number] [decipherkey.txt]"));
    }
}