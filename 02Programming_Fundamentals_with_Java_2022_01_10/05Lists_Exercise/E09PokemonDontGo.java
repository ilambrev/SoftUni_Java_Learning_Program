package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E09PokemonDontGo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" +");

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        int sumOfRemovedElements = 0;

        while (!numbersList.isEmpty()) {
            int inputIndex = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (inputIndex > numbersList.size() - 1) {
                removedElement = numbersList.get(numbersList.size() - 1);
                numbersList.set(numbersList.size() - 1, numbersList.get(0));
            } else if (inputIndex < 0) {
                removedElement = numbersList.get(0);
                numbersList.set(0, numbersList.get(numbersList.size() - 1));
            } else {
                removedElement = numbersList.get(inputIndex);
                numbersList.remove(inputIndex);
            }
            for (int i = 0; i < numbersList.size(); i++) {
                if (numbersList.get(i) <= removedElement) {
                    numbersList.set(i, numbersList.get(i) + removedElement);
                } else {
                    numbersList.set(i, numbersList.get(i) - removedElement);
                }
            }

            sumOfRemovedElements += removedElement;
        }

        System.out.println(sumOfRemovedElements);
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

}