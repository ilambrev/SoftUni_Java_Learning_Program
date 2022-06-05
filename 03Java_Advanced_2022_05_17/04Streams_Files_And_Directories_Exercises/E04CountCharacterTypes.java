package E04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class E04CountCharacterTypes {
    public static void main(String[] args) {

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileInputStream fis = new FileInputStream("src/EF04StreamsFilesAndDirectories/input.txt");
             PrintWriter pw = new PrintWriter("src/EF04StreamsFilesAndDirectories/output.txt")) {

            int ch = fis.read();
            while (ch != -1) {
                switch (determineSymbol((char) ch)) {
                    case "vowel":
                        vowels++;
                        break;
                    case "consonant":
                        consonants++;
                        break;
                    case "punctuation":
                        punctuation++;
                        break;
                }
                ch = fis.read();
            }
            String result = String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowels, consonants, punctuation);
            pw.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String determineSymbol(char ch) {
        if (Character.isWhitespace(ch)) {
            return "whitespace";
        } else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "vowel";
        } else if (ch == '!' || ch == ',' || ch == '.' || ch == '?') {
            return "punctuation";
        } else {
            return "consonant";
        }
    }

}