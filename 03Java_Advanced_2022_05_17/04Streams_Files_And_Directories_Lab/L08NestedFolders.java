package L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L08NestedFolders {
    public static void main(String[] args) {

        try {
            File directory = new File("src/LF04StreamsFilesAndDirectories/Files-and-Streams");

            Deque<File> directories = new ArrayDeque<>();

            List<String> dirNames = new ArrayList<>();
            dirNames.add(directory.getName());

            directories.offer(directory);

            while (!directories.isEmpty()) {
                File currentDirectory = directories.poll();

                File[] nestedDirectories = currentDirectory.listFiles();

                if (nestedDirectories != null) {
                    for (File dir : nestedDirectories) {
                        if (dir.isDirectory()) {
                            directories.offer(dir);
                            dirNames.add(dir.getName());
                        }
                    }
                }
            }

            dirNames.forEach(System.out::println);
            System.out.printf("%d folders%n", dirNames.size());

        } catch (NullPointerException e) {
            System.out.println("No such directory!");
        }

    }
}