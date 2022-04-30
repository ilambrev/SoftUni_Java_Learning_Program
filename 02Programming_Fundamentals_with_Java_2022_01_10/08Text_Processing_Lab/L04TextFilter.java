package L08TextProcessing;

import java.util.Scanner;

public class L04TextFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(",\\s+");

        StringBuilder text = new StringBuilder();
        text.append(scanner.nextLine());

        for (String bannedWord : bannedWords) {
            int index = text.indexOf(bannedWord);
            String replacement = "*".repeat(bannedWord.length());
            while (index != -1) {
                text.replace(index, (index + bannedWord.length()), replacement);
                index = text.indexOf(bannedWord);
            }
        }

        System.out.println(text);
    }
}