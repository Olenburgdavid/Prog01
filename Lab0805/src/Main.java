import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
	if (args.length != 2){
        System.out.println("Usage: java Main TextToRemove FileToProcess ");
        System.exit(1);
    }
	File inputFile = new File(args[1]);
        if (!inputFile.exists()) {
            System.err.println("Input file " + args[1] + " does not exist. ");
            System.exit(2);
        }

        if (args[0].isEmpty()){
            System.err.println("The text to remove cant be empty: ");
            System.exit(3);
        }

        File tempFile = File.createTempFile("tmp", ".txt");

        try (
            Scanner scan = new Scanner(inputFile);
            PrintWriter printWriter = new PrintWriter(tempFile);
            ){
    while (scan.hasNext()){
            printWriter.println(scan.nextLine().replaceAll(args[0], ""));
            }
    }
        Files.copy(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING );
}
}
