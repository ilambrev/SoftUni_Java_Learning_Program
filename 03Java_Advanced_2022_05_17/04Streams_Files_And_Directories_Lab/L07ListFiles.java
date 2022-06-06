package L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class L07ListFiles {
    public static void main(String[] args) {

        try {
            File directory = new File("src/LF04StreamsFilesAndDirectories/Files-and-Streams");

            Arrays.stream(Objects.requireNonNull(directory.listFiles())).forEach(f -> {
                if (f.isFile()) {
                    System.out.printf("%s: [%d]%n", f.getName(), f.length());
                }
            });

        } catch (NullPointerException e) {
            System.out.println("No such directory!");
        }

    }
}