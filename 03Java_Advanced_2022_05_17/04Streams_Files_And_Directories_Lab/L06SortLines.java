package L04StreamsFilesAndDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L06SortLines {
    public static void main(String[] args) {

        String path = "src/LF04StreamsFilesAndDirectories/input.txt";

        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/LF04StreamsFilesAndDirectories/output.txt"))) {
            List<String> textLines = Files.readAllLines(Paths.get(path));
            textLines.sort(null);
            for (String line : textLines) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
