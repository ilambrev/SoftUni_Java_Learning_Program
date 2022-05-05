package ME09RegularExpressions;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME02RageQuit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputStrings = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<string>[^0-9]+)(?<number>[0-9]+)");
        Matcher matcher = pattern.matcher(inputStrings);
        StringBuilder rageMessage = new StringBuilder();
        Map<Character, Integer> symbols = new HashMap<>();

        while (matcher.find()) {
            String messagePart = matcher.group("string").toUpperCase(Locale.ROOT);
            int timesToRepeat = Integer.parseInt(matcher.group("number"));
            for (int i = 1; i <= timesToRepeat; i++) {
                rageMessage.append(messagePart);
            }
        }
        for (int i = 0; i < rageMessage.length(); i++) {
            if (!symbols.containsKey(rageMessage.charAt(i))) {
                symbols.put(rageMessage.charAt(i), 1);
            }
        }
        System.out.printf("Unique symbols used: %d%n", symbols.size());
        System.out.println(rageMessage);
    }
}