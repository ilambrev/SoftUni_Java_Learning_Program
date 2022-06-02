package L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class L02WriteToFile {
    public static void main(String[] args) {

        Set<Character> undesiredSymbols = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        try (FileInputStream fileInputStream = new FileInputStream("src/LF04StreamsFilesAndDirectories/input.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("src/LF04StreamsFilesAndDirectories/output.txt")) {
            int symbol = fileInputStream.read();
            while (symbol != -1) {
                if (!undesiredSymbols.contains((char) symbol)) {
                    fileOutputStream.write((char) symbol);
                }
                symbol = fileInputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
