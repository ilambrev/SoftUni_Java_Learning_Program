package L04StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class L04ExtractIntegers {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("src/LF04StreamsFilesAndDirectories/input.txt"));
             PrintWriter printWriter = new PrintWriter("src/LF04StreamsFilesAndDirectories/output.txt")) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    boolean isDigitsString = true;
                    String word = words[i];
                    if (word.length() > 0) {
                        for (int j = 0; j < words[i].length(); j++) {
                            if (!Character.isDigit(word.charAt(j))) {
                                isDigitsString = false;
                                break;
                            }
                        }
                    } else {
                        isDigitsString = false;
                    }
                    if (isDigitsString) {
                        printWriter.println(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}