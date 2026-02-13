import java.io.File;

/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        if (args.length == 0) { // no arguments = list the available files

            ProgramControl.runNoArguments(); // list files to display

            return;
        }
        else if (args.length == 1) { // 1 argument = show specified file using the default decipher key
            String fileNumber = args[0];

            if (!fileNumber.matches("\\d{2}")) {
                System.out.println("error: file number must be two digits (ex. 01, 10");
                return;
            }

            ProgramControl.runOneArgument(fileNumber); // display file with deciphered text (using default key)

            return;
        }
        else if (args.length == 2) {

            boolean validNumber = args[0].matches("\\d{2}");
            boolean validFile = args[1].endsWith(".txt");

            if (!validNumber && !validFile) {
                System.out.println("error: file number must be two digits (ex. 01, 10 AND decipher key must be a string that ends in .txt (ex. key.txt)");
            }
            else if (!validNumber) {
                System.out.println("error: file number must be two digits");
            }
            else if (!validFile) {
                System.out.println("error: decipher key must be a string that ends in .txt (ex. key.txt)");
            }
            else {
                ProgramControl.runTwoArguments(args[0], args[1]);
            }
<<<<<<< Updated upstream

            ProgramControl.runTwoArguments(fileNumber, new File(decipherKey));// display file with deciphered text (using custom key)

            return;
=======
>>>>>>> Stashed changes
        }
        else {
            if (args.length > 2) {
                System.out.println("error: too many arguments. options are:\n" + "java TopSecret\n" + "java TopSecret [number]\n" + "java TopSecret [number] [decipherkey.txt]");
                return;
            }
        }
        return;
    }
}
