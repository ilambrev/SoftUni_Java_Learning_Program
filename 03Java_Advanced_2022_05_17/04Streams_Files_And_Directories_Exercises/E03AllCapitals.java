package E04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E03AllCapitals {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/input.txt"));
             PrintWriter printWriter = new PrintWriter("src/EF04StreamsFilesAndDirectories/output.txt")) {

            String line = bufferedReader.readLine();

            while (line != null) {
                printWriter.println(line.toUpperCase());
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}