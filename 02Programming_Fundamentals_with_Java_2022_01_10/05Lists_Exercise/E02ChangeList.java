package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02ChangeList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" ");
        String inputCommands = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        while (!inputCommands.equals("end")) {
            String[] currentCommand = inputCommands.split(" ");
            int element = Integer.parseInt(currentCommand[1]);
            if (currentCommand[0].equals("Delete")) {
                deleteElementFromList(numbersList, element);
            } else if (currentCommand[0].equals("Insert")) {
                int index = Integer.parseInt(currentCommand[2]);
                insertElementToList(numbersList, element, index);
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

    private static void deleteElementFromList(List<Integer> numbersList, int number) {
        int i = 0;
        while (i < numbersList.size()) {
            if (numbersList.get(i) == number) {
                numbersList.remove(i);
            } else {
                i++;
            }
        }
    }

    private static void insertElementToList(List<Integer> numbersList, int number, int index) {
        numbersList.add(index, number);
    }

    private static void printList(List<Integer> numbersList) {
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}