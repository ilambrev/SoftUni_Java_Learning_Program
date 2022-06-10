package E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class E07MergeTwoFilesV2 {
    public static void main(String[] args) {

        Path inputFileOne = Paths.get("src/EF04StreamsFilesAndDirectories/inputOne.txt");
        Path inputFileTwo = Paths.get("src/EF04StreamsFilesAndDirectories/inputTwo.txt");
        Path outputFile = Paths.get("src/EF04StreamsFilesAndDirectories/output.txt");

        try {
            List<String> fileOne = Files.readAllLines(inputFileOne);
            List<String> fileTwo = Files.readAllLines(inputFileTwo);

            Files.write(outputFile, fileOne, StandardOpenOption.APPEND);
            Files.write(outputFile, fileTwo, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}