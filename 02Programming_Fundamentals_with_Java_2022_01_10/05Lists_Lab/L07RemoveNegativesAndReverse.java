package L05Lists;

import java.util.*;

public class L07RemoveNegativesAndReverse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" ");

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);
        removeNegativeNumbers(numbersList);
        Collections.reverse(numbersList);

        if (numbersList.isEmpty()) {
            System.out.println("empty");
        } else {
            printList(numbersList);
        }
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static void removeNegativeNumbers(List<Integer> numbersList) {
        int i = 0;
        while (i < numbersList.size()) {
            if (numbersList.get(i) < 0) {
                numbersList.remove(i);
            } else {
                i++;
            }
        }
    }

    private static void printList(List<Integer> numbersList) {
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}