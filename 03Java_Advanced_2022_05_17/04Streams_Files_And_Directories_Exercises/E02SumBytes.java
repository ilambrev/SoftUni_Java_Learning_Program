package E04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E02SumBytes {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/input.txt"))) {

            String line = bufferedReader.readLine();
            long sumOfSymbolsCodes = 0;

            while (line != null) {
                for (char s : line.toCharArray()) {
                    sumOfSymbolsCodes += s;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sumOfSymbolsCodes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
