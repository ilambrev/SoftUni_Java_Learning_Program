package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputChars = scanner.nextLine();

        Map<Character, Integer> charsCount = new LinkedHashMap<>();

        for (int i = 0; i < inputChars.length(); i++) {
            if (inputChars.charAt(i) != ' ') {
                char symbol = inputChars.charAt(i);
                if (charsCount.containsKey(symbol)) {
                    int symbolCount = charsCount.get(symbol);
                    charsCount.put(symbol, symbolCount + 1);
                } else {
                    charsCount.put(symbol, 1);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : charsCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}