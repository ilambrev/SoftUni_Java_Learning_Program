package EX05FinalExam;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02EmojiDetector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        Map<String, Integer> emojis = new LinkedHashMap<>();
        BigInteger threshold = BigInteger.ONE;

        threshold = countThreshold(threshold, inputString);
        searchForEmojis(emojis, inputString);

        System.out.println("Cool threshold: " + threshold);
        System.out.println(emojis.size() + " emojis found in the text. The cool ones are:");
        for (Map.Entry<String, Integer> entry : emojis.entrySet()) {
            if (BigInteger.valueOf(entry.getValue()).compareTo(threshold) > 0) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static BigInteger countThreshold(BigInteger threshold, String digitsInString) {
        StringBuilder digits = new StringBuilder();
        String findDigits = "[0-9]+";
        Pattern pattern = Pattern.compile(findDigits);
        Matcher matcher = pattern.matcher(digitsInString);
        while (matcher.find()) {
            digits.append(matcher.group());
        }
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.substring(i, i + 1));
            threshold = threshold.multiply(BigInteger.valueOf(digit));
        }
        return threshold;
    }

    private static void searchForEmojis(Map<String, Integer> emojis, String emojisInString) {
        String findEmoji = "(:{2}|\\*{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(findEmoji);
        Matcher matcher = pattern.matcher(emojisInString);
        while (matcher.find()) {
            int sumOfEmojiLettersCodes = 0;
            for (int i = 0; i < matcher.group("emoji").length(); i++) {
                sumOfEmojiLettersCodes += matcher.group("emoji").charAt(i);
            }
            emojis.put(matcher.group(), sumOfEmojiLettersCodes);
        }
    }

}