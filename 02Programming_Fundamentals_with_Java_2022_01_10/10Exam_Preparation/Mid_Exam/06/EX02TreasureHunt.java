package EX06MidExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> loot = inputToList(scanner, "\\|");
        List<String> commands = inputToList(scanner, " ");

        while (!commands.get(0).equals("Yohoho!")) {
            if (loot.isEmpty()) {
                break;
            }
            String command = commands.get(0);
            int itemIndex = 0;
            switch (command) {
                case "Loot":
                    for (int i = 1; i < commands.size(); i++) {
                        if (!checkIfItemExist(loot, commands.get(i))) {
                            loot.add(0, commands.get(i));
                        }
                    }
                    break;
                case "Drop":
                    itemIndex = Integer.parseInt(commands.get(1));
                    if (itemIndex >= 0 && itemIndex < (loot.size() - 1)) {
                        loot.add(loot.get(itemIndex));
                        loot.remove(itemIndex);
                    }
                    break;
                case "Steal":
                    int itemsToRemove = Integer.parseInt(commands.get(1));
                    if (itemsToRemove > loot.size()) {
                        itemsToRemove = loot.size();
                    }
                    while (itemsToRemove != 0) {
                        System.out.print(loot.get(loot.size() - itemsToRemove));
                        if (itemsToRemove > 1) {
                            System.out.print(", ");
                        }
                        loot.remove(loot.size() - itemsToRemove);
                        itemsToRemove--;
                    }
                    System.out.println();
                    break;
            }

            commands = inputToList(scanner, " ");
        }

        if (loot.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", countAverageTreasureGain(loot));
        }
    }

    private static List<String> inputToList(Scanner scanner, String separator) {
        String[] inputString = scanner.nextLine().split(separator);
        List<String> loot = new ArrayList<>();
        for (int i = 0; i < inputString.length; i++) {
            loot.add(inputString[i]);
        }
        return loot;
    }

    private static boolean checkIfItemExist(List<String> inputList, String item) {
        boolean isItemFound = false;
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).equals(item)) {
                isItemFound = true;
                break;
            }
        }
        return isItemFound;
    }

    private static double countAverageTreasureGain(List<String> loot) {
        double averageGain = 0;
        int itemsLength = 0;
        for (int i = 0; i < loot.size(); i++) {
            itemsLength += loot.get(i).length();
        }
        averageGain = itemsLength * 1.0 / loot.size();
        return averageGain;
    }

}