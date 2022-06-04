package L04StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class L04ExtractIntegersV2 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("src/LF04StreamsFilesAndDirectories/input.txt"));
             PrintWriter printWriter = new PrintWriter("src/LF04StreamsFilesAndDirectories/output.txt")) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    printWriter.println(scanner.next());
                } else {
                    scanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}