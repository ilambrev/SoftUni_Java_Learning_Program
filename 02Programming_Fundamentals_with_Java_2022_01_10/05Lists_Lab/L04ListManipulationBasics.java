package L05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04ListManipulationBasics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfNumbers = scanner.nextLine().split(" ");
        String inputCommands = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();

        readListFromConsole(numbersList, inputOfNumbers);

        while (!inputCommands.equals("end")) {
            String[] currentCommand = inputCommands.split(" ");
            int elementValue = Integer.parseInt(currentCommand[1]);
            int index = 0;

            switch (currentCommand[0]) {
                case "Add":
                    addNumber(numbersList, elementValue);
                    break;
                case "Remove":
                    removeElementByValue(numbersList, elementValue);
                    break;
                case "RemoveAt":
                    index = elementValue;
                    removeElementAtIndex(numbersList, index);
                    break;
                case "Insert":
                    index = Integer.parseInt(currentCommand[2]);
                    insertElementAtIndex(numbersList, elementValue, index);
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

    private static void addNumber(List<Integer> listOfNumbers, int number) {
        listOfNumbers.add(number);
    }

    private static void removeElementByValue(List<Integer> listOfNumbers, int number) {
        int i = 0;
        while (i < listOfNumbers.size()) {
            if (listOfNumbers.get(i).equals(number)) {
                listOfNumbers.remove(i);
            } else {
                i++;
            }
        }
    }

    private static void removeElementAtIndex(List<Integer> listOfNumbers, int index) {
        listOfNumbers.remove(index);
    }

    private static void insertElementAtIndex(List<Integer> listOfNumbers, int number, int index) {
        listOfNumbers.add(index, number);
    }

    private static void printList(List<Integer> numberList) {
        for (int number : numberList) {
            System.out.print(number + " ");
        }
    }

}