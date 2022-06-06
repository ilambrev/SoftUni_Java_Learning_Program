package E04StreamsFilesAndDirectories;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06WordCount {
    public static void main(String[] args) {

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        try (Scanner wordScanner = new Scanner(new FileReader("src/EF04StreamsFilesAndDirectories/words.txt"));
             Scanner textScanner = new Scanner(new FileReader("src/EF04StreamsFilesAndDirectories/text.txt"));
             PrintWriter pw = new PrintWriter("src/EF04StreamsFilesAndDirectories/results.txt")) {

            while (wordScanner.hasNext()) {
                String word = wordScanner.next();
                wordsCount.put(word, 0);
            }

            while (textScanner.hasNext()) {
                String word = textScanner.next();
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }

            wordsCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(w -> pw.println(w.getKey() + " - " + w.getValue()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}