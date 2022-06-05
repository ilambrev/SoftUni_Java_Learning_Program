package E04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E01SumLines {
    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/EF04StreamsFilesAndDirectories/input.txt"))) {
            String row = bufferedReader.readLine();

            while (row != null) {
                long sumOfSymbolsCodes = 0;
                for (int i = 0; i < row.length(); i++) {
                    sumOfSymbolsCodes += row.charAt(i);
                }
                row = bufferedReader.readLine();
                System.out.println(sumOfSymbolsCodes);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}