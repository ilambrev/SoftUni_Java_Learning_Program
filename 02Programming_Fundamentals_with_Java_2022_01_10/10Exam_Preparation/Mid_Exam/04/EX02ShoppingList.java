package EX04MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02ShoppingList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> groceriesList = inputToList(scanner, "!+");
        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("Go Shopping!")) {
            String[] commands = inputCommands.split("\\s+");
            int index = 0;
            switch (commands[0]) {
                case "Urgent":
                    if (!checkIfElementExist(groceriesList, commands[1])) {
                        groceriesList.add(0,commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if (checkIfElementExist(groceriesList, commands[1])) {
                        groceriesList.remove(commands[1]);
                    }
                    break;
                case "Correct":
                    if (checkIfElementExist(groceriesList, commands[1])) {
                        groceriesList.set(findElementIndex(groceriesList, commands[1]), commands[2]);
                    }
                    break;
                case "Rearrange":
                    if (checkIfElementExist(groceriesList, commands[1])) {
                        index = findElementIndex(groceriesList, commands[1]);
                        groceriesList.add(groceriesList.get(index));
                        groceriesList.remove(index);
                    }
                    break;
            }

            inputCommands = scanner.nextLine();
        }

        printList(groceriesList, ", ");
    }

    private static List<String> inputToList(Scanner scanner, String separator) {
        String[] inputString = scanner.nextLine().split(separator);
        List<String> groceries = new ArrayList<>();
        for (int i = 0; i < inputString.length; i++) {
            groceries.add(inputString[i]);
        }
        return groceries;
    }

    private static boolean checkIfElementExist(List<String> inputList, String item) {
        boolean isItemInList = false;
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).equals(item)) {
                isItemInList = true;
                break;
            }
        }
        return isItemInList;
    }

    private static int findElementIndex(List<String> inputList, String item) {
        int index = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void printList(List<String> outputList, String separator) {
        for (int i = 0; i < outputList.size(); i++) {
            System.out.print(outputList.get(i));
            if (i < outputList.size() - 1) {
                System.out.print(separator);
            }
        }
    }

}