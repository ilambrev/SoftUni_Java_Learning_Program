package EX03FinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02MirrorWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> pairs = new ArrayList<>();
        int pairsFound = 0;

        while (matcher.find()) {
            pairsFound++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            if (wordOne.length() == wordTwo.length()) {
                StringBuilder reverse = new StringBuilder(wordOne);
                if (reverse.reverse().toString().equals(wordTwo)) {
                    String pair = wordOne + " <=> " + wordTwo;
                    pairs.add(pair);
                }
            }
        }

        if (pairsFound == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairsFound + " word pairs found!");
        }
        if (pairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:" + System.lineSeparator() + String.join(", ", pairs));
        }
    }
}