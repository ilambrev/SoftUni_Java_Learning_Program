package E03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbols = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbols.containsKey(symbol)) {
                int newValue = symbols.get(symbol) + 1;
                symbols.put(symbol, newValue);
            } else {
                symbols.put(symbol, 1);
            }
        }

        for (Character symbol : symbols.keySet()) {
            System.out.printf("%c: %d time/s%n", symbol, symbols.get(symbol));
        }

    }
}