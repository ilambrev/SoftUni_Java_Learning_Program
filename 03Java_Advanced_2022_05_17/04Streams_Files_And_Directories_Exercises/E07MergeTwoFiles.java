package E04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E07MergeTwoFiles {
    public static void main(String[] args) {

        try (BufferedReader brOne = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/inputOne.txt"));
             BufferedReader brTwo = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/inputTwo.txt"));
             PrintWriter pw = new PrintWriter("src/EF04StreamsFilesAndDirectories/output.txt")) {

            String line = brOne.readLine();
            while (line != null) {
                pw.println(line);
                line = brOne.readLine();
            }

            line = brTwo.readLine();
            while (line != null) {
                pw.println(line);
                line = brTwo.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}