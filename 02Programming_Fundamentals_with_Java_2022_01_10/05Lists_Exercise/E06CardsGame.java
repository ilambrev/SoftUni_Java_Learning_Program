package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06CardsGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputFirstPlayerCards = scanner.nextLine().split(" ");
        String[] inputSecondPlayerCards = scanner.nextLine().split(" ");

        List<Integer> firstPlayerCards = new ArrayList<>();
        List<Integer> secondPlayerCards = new ArrayList<>();

        readListFromConsole(firstPlayerCards, inputFirstPlayerCards);
        readListFromConsole(secondPlayerCards, inputSecondPlayerCards);

        while (!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                firstPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.remove(0);
                firstPlayerCards.add(secondPlayerCards.get(0));
                secondPlayerCards.remove(0);
            } else if (firstPlayerCards.get(0) < secondPlayerCards.get(0)) {
                secondPlayerCards.add(secondPlayerCards.get(0));
                secondPlayerCards.remove(0);
                secondPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.remove(0);
            } else if (firstPlayerCards.get(0).equals(secondPlayerCards.get(0))) {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        if (firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            System.out.println("Second player wins! Sum: " + printSumOfNumbers(secondPlayerCards));
        } else if (!firstPlayerCards.isEmpty()) {
            System.out.println("First player wins! Sum: " + printSumOfNumbers(firstPlayerCards));
        }
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static int printSumOfNumbers(List<Integer> numbersList) {
        int sum = 0;
        for (int element : numbersList) {
            sum += element;
        }
        return sum;
    }

}