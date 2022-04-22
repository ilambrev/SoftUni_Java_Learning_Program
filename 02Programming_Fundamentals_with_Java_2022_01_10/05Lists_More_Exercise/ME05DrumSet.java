package ME05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME05DrumSet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        String[] drumSet = scanner.nextLine().split(" +");
        String inputCommand = scanner.nextLine();

        int[] initialDrumSetCondition = new int[drumSet.length];
        List<Integer> currentDrumSetCondition = new ArrayList<>();

        convertArray(initialDrumSetCondition, drumSet);
        arrayToList(currentDrumSetCondition, initialDrumSetCondition);

        while (!inputCommand.equals("Hit it again, Gabsy!")) {
            int powerApplied = Integer.parseInt(inputCommand);
            for (int i = 0; i < currentDrumSetCondition.size(); i++) {
                if (currentDrumSetCondition.get(i) > powerApplied) {
                    currentDrumSetCondition.set(i, currentDrumSetCondition.get(i) - powerApplied);
                } else {
                    if (savings >= initialDrumSetCondition[i] * 3) {
                        currentDrumSetCondition.set(i, initialDrumSetCondition[i]);
                        savings -= (initialDrumSetCondition[i] * 3);
                    } else {
                        currentDrumSetCondition.set(i, 0);
                    }
                }
            }

            inputCommand = scanner.nextLine();
        }

        printList(currentDrumSetCondition);
        System.out.printf("Gabsy has %.2flv.", savings);
    }

    private static void convertArray(int[] numbersArray, String[] stringsArray) {
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = Integer.parseInt(stringsArray[i]);
        }
    }

    private static void arrayToList(List<Integer> numbersList, int[] drumsCondition) {
        for (int i = 0; i < drumsCondition.length; i++) {
            numbersList.add(drumsCondition[i]);
        }
    }

    private static void printList(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) > 0) {
                System.out.print(numbersList.get(i) + " ");
            }
        }
        System.out.println();
    }

}