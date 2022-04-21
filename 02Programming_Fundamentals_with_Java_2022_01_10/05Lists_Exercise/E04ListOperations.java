package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04ListOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" ");
        String inputCommands = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        while (!inputCommands.equals("End")) {
            String[] currentCommand = inputCommands.split(" +");

            switch (currentCommand[0]) {
                case "Add":
                    addNumberToList(numbersList, Integer.parseInt(currentCommand[1]));
                    break;
                case "Insert":
                    addNumberAtIndex(numbersList, Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                    break;
                case "Remove":
                    removeNumberAtIndex(numbersList, Integer.parseInt(currentCommand[1]));
                    break;
                case "Shift":
                    if (currentCommand[1].equals("left")) {
                        shiftElementsLeft(numbersList, Integer.parseInt(currentCommand[2]));
                    } else if (currentCommand[1].equals("right")) {
                        shiftElementsRight(numbersList, Integer.parseInt(currentCommand[2]));
                    }
                    break;
            }

            inputCommands = scanner.nextLine();
        }

        printList(numbersList);
    }


    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static void addNumberToList(List<Integer> numbersList, int number) {
        numbersList.add(number);
    }

    private static void addNumberAtIndex(List<Integer> numbersList, int number, int index) {
        if ((numbersList.size() > 0 && (index > numbersList.size() - 1)) || index < 0) {
            System.out.println("Invalid index");
        } else {
            numbersList.add(index, number);
        }
    }

    private static void removeNumberAtIndex(List<Integer> numbersList, int index) {
        if ((numbersList.size() > 0 && (index > numbersList.size() - 1)) || index < 0) {
            System.out.println("Invalid index");
        } else {
            numbersList.remove(index);
        }
    }

    private static void shiftElementsLeft(List<Integer> numbersList, int moves) {
        for (int i = 1; i <= moves; i++) {
            numbersList.add(numbersList.get(0));
            numbersList.remove(0);
        }
    }

    private static void shiftElementsRight(List<Integer> numbersList, int moves) {
        if (numbersList.size() > 0) {
            for (int i = 1; i <= moves; i++) {
                numbersList.add(0, numbersList.get(numbersList.size() - 1));
                numbersList.remove(numbersList.size() - 1);
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