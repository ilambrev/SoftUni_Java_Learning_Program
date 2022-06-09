package E04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E05LineNumbers {
    public static void main(String[] args) {

        int counter = 1;

        try (BufferedReader br = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/inputLineNumbers.txt"));
             PrintWriter pw = new PrintWriter("src/EF04StreamsFilesAndDirectories/output.txt")) {

            String line = br.readLine();

            while (line != null) {
                String newLineFormat = String.format("%d. %s", counter, line);
                pw.println(newLineFormat);
                counter++;
                line = br.readLine();
            }

        } catch (IOException e) {               
            throw new RuntimeException(e);
        }

    }
}
