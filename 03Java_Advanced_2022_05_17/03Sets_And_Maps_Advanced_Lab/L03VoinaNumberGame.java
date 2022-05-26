package L03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class L03VoinaNumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int n = 50;

        while (n-- > 0) {
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}