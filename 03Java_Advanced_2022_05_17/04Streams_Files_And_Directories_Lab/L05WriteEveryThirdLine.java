package L04StreamsFilesAndDirectories;

import java.io.*;

public class L05WriteEveryThirdLine {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/LF04StreamsFilesAndDirectories/input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("src/LF04StreamsFilesAndDirectories/output.txt"))) {

            int numberOfLine = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                numberOfLine++;
                if (numberOfLine % 3 == 0) {
                    printWriter.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}