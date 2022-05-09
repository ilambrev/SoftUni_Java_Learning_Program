package EX02MidExam;

import java.util.*;

public class EX03Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputNumberSequence = scanner.nextLine().split(" +");

        List<Integer> numbersList = new ArrayList<>();
        List<Integer> topNumbers = new ArrayList<>();

        inputToList(numbersList, inputNumberSequence);

        if (numbersList.size() > 0) {
            double averageNumber = sumOfNumbers(numbersList) * 1.0 / numbersList.size();

            if (numbersList.size() == 1 || ((averageNumber / numbersList.get(0)) == 1)) {
                System.out.println("No");
            } else {
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) > averageNumber) {
                        topNumbers.add(numbersList.get(i));
                    }
                }
                Collections.sort(topNumbers);
                reverseListOrder(topNumbers);
                if (topNumbers.size() > 5) {
                    int elementsToRemove = topNumbers.size() - 5;
                    for (int i = 1; i <= elementsToRemove; i++) {
                        topNumbers.remove(topNumbers.size() - 1);
                    }
                }
                printList(topNumbers);
            }
        }
    }

    private static void inputToList(List<Integer> numbersList, String[] inputNumberSequence) {
        for (int i = 0; i < inputNumberSequence.length; i++) {
            numbersList.add(Integer.parseInt(inputNumberSequence[i]));
        }
    }

    private static int sumOfNumbers(List<Integer> numbersList) {
        int sumOfNumbers = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sumOfNumbers += numbersList.get(i);
        }
        return sumOfNumbers;
    }

    private static void printList(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(numbersList.get(i) + " ");
        }
    }

    private static void reverseListOrder(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size() / 2; i++) {
            int numberValue = numbersList.get(i);
            numbersList.set(i, numbersList.get(numbersList.size() - 1 - i));
            numbersList.set(numbersList.size() - 1 - i, numberValue);
        }
    }

}
