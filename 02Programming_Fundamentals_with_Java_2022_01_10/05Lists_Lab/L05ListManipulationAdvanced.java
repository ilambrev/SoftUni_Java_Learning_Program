package L05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05ListManipulationAdvanced {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" ");
        String inputCommands = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        while (!inputCommands.equals("end")) {
            String[] currentCommand = inputCommands.split(" ");

            switch (currentCommand[0]) {
                case "Contains":
                    checkIfElementExists(numbersList, Integer.parseInt(currentCommand[1]));
                    break;
                case "Print":
                    if (currentCommand[1].equals("even")) {
                        printEvenElements(numbersList);
                    } else if (currentCommand[1].equals("odd")) {
                        printOddElements(numbersList);
                    }
                    break;
                case "Get":
                    printSumOfAllElements(numbersList);
                    break;
                case "Filter":
                    String operation = currentCommand[1];
                    int valueToCompare = Integer.parseInt(currentCommand[2]);
                    List<Integer> sortedListOfNumbers = filterElementsFromList(numbersList, operation, valueToCompare);
                    printList(sortedListOfNumbers);
                    break;
            }

            inputCommands = scanner.nextLine();
        }
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static void checkIfElementExists(List<Integer> listOfNumbers, int number) {
        boolean isElementNotFound = true;
        for (int element : listOfNumbers) {
            if (element == number) {
                System.out.println("Yes");
                isElementNotFound = false;
                break;
            }
        }

        if (isElementNotFound) {
            System.out.println("No such number");
        }
    }

    private static void printEvenElements(List<Integer> numbersList) {
        for (int number : numbersList) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printOddElements(List<Integer> numbersList) {
        for (int number : numbersList) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printSumOfAllElements(List<Integer> numbersList) {
        int sum = 0;
        for (int number : numbersList) {
            sum += number;
        }
        System.out.println(sum);
    }

    private static List<Integer> filterElementsFromList(List<Integer> numbersList, String operation, int value) {
        List<Integer> sortedListOfNumber = new ArrayList<>();
        switch (operation) {
            case ">":
                for (int element : numbersList) {
                    if (element > value) {
                        sortedListOfNumber.add(element);
                    }
                }
                break;
            case "<":
                for (int element : numbersList) {
                    if (element < value) {
                        sortedListOfNumber.add(element);
                    }
                }
                break;
            case ">=":
                for (int element : numbersList) {
                    if (element >= value) {
                        sortedListOfNumber.add(element);
                    }
                }
                break;
            case "<=":
                for (int element : numbersList) {
                    if (element <= value) {
                        sortedListOfNumber.add(element);
                    }
                }
                break;
        }
        return sortedListOfNumber;
    }

    private static void printList(List<Integer> numbersList) {
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}