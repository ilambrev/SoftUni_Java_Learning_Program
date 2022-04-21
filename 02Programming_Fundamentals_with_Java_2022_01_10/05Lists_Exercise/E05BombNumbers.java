package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05BombNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputOfNumbers = scanner.nextLine().split(" +");
        String[] bombParameters = scanner.nextLine().split(" +");

        int bombNumber = Integer.parseInt(bombParameters[0]);
        int bombPower = Integer.parseInt(bombParameters[1]);
        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == bombNumber) {
                if (i >= bombPower && (i + bombPower) < numbersList.size()) {
                    for (int j = i + bombPower; j >= (i - bombPower); j--) {
                        numbersList.remove(j);
                    }
                    i = i - (bombPower + 1);
                } else if (i < bombPower && (i + bombPower) < numbersList.size()) {
                    for (int j = i + bombPower; j >= 0; j--) {
                        numbersList.remove(j);
                    }
                    i = i - 1;
                } else if (i >= bombPower && (i + bombPower) >= numbersList.size()) {
                    for (int j = numbersList.size() - 1; j >= (i - bombPower); j--) {
                        numbersList.remove(j);
                    }
                    i = i - (bombPower + 1);
                } else {
                    for (int j = numbersList.size() - 1; j >= 0; j--) {
                        numbersList.remove(j);
                    }
                }
            }
        }

        System.out.println(printSumOfNumbers(numbersList));
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