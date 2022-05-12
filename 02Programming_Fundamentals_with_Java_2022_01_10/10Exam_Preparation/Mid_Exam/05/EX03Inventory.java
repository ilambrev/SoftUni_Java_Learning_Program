package EX05MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX03Inventory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> collectedItems = stringToList(scanner);

        String inputOfCommands = scanner.nextLine();

        while (!inputOfCommands.equals("Craft!")) {
            String[] commandsAndParameters = inputOfCommands.split("\\s-\\s");
            String command = commandsAndParameters[0];
            String item = commandsAndParameters[1];
            switch (command) {
                case "Collect":
                    if (!checkIfItemIsInList(collectedItems, item)) {
                        collectedItems.add(item);
                    }
                    break;
                case "Drop":
                    if (checkIfItemIsInList(collectedItems, item)) {
                        collectedItems.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if (checkIfItemIsInList(collectedItems, oldItem)) {
                        for (int i = 0; i < collectedItems.size(); i++) {
                            if (collectedItems.get(i).equals(oldItem)) {
                                collectedItems.add((i + 1), newItem);
                                break;
                            }
                        }
                    }
                    break;
                case "Renew":
                    if (checkIfItemIsInList(collectedItems, item)) {
                        for (int i = 0; i < collectedItems.size(); i++) {
                            if (collectedItems.get(i).equals(item)) {
                                collectedItems.add(item);
                                collectedItems.remove(i);
                                break;
                            }
                        }
                    }
                    break;
            }

            inputOfCommands = scanner.nextLine();
        }

        printItemsList(collectedItems);
    }

    private static List<String> stringToList(Scanner scanner) {
        String[] inputString = scanner.nextLine().split(", ");
        List<String> stringsList = new ArrayList<>();

        for (int i = 0; i < inputString.length; i++) {
            stringsList.add(inputString[i]);
        }
        return stringsList;
    }

    private static boolean checkIfItemIsInList(List<String> listToCheck, String item) {
        boolean isItemInList = false;
        for (int i = 0; i < listToCheck.size(); i++) {
            if (listToCheck.get(i).equals(item)) {
                isItemInList = true;
                break;
            }
        }
        return isItemInList;
    }

    private static void printItemsList(List<String> collectedItems) {
        for (int i = 0; i < collectedItems.size(); i++) {
            System.out.print(collectedItems.get(i));
            if (i < collectedItems.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}