package E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class E08GetFolderSize {
    public static void main(String[] args) {

        Path folderPath = Paths.get("src/EF04StreamsFilesAndDirectories/Exercises Resources");

        try (Stream<Path> walk = Files.walk(folderPath)) {
            long folderSize = walk.filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).sum();

            System.out.println("Folder size: " + folderSize);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}