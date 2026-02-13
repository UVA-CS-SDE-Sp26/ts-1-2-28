/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        if (args.length == 0) { // no arguments = list the available files

            // list files to display

            return;
        }
        else if (args.length == 1) { // 1 argument = show specified file using the default decipher key
            String fileNumber = args[0];

            if (!fileNumber.matches("\\d{2}")) {
                System.out.println("error: file number must be two digits (ex. 01, 10");
                return;
            }

            // display file with deciphered text (using default key)

            return;
        }
        else if (args.length == 2) { // 2 arguments = show specified file using the custom decipher key

            String fileNumber = args[0];
            String decipherKey = args[1];

            if (!fileNumber.matches("\\d{2}")) {
                System.out.println("error: file number must be two digits (ex. 01, 10");
                return;
            }

            if (!decipherKey.endsWith(".txt")) {
                System.out.println("error: decipher key must be a string that ends in .txt (ex. key.txt");
                return;
            }

            // display file with deciphered text (using custom key)

            return;
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
