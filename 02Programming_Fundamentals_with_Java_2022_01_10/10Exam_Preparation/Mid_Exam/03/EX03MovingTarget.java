package EX03MidExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX03MovingTarget {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] targetsState = scanner.nextLine().split(" +");
        String inputCommandString = scanner.nextLine();

        List<Integer> targets = new ArrayList<>();

        targetsInputToList(targets, targetsState);

        while (!inputCommandString.equals("End")) {
            if (!targets.isEmpty()) {
                String[] command = inputCommandString.split(" +");
                int targetIndex = Integer.parseInt(command[1]);
                int targetParameter = Integer.parseInt((command[2]));
                switch (command[0]) {
                    case "Shoot":
                        if (targetIndex >= 0 && targetIndex < targets.size()) {
                            if ((targets.get(targetIndex) - targetParameter) <= 0) {
                                targets.remove(targetIndex);
                            } else {
                                targets.set(targetIndex, targets.get(targetIndex) - targetParameter);
                            }
                        }
                        break;
                    case "Add":
                        if (targetIndex >= 0 && targetIndex < targets.size()) {
                            targets.add(targetIndex, targetParameter);
                        } else {
                            System.out.println("Invalid placement!");
                        }
                        break;
                    case "Strike":
                        if (targetIndex >= 0 && targetIndex < targets.size() && (targetIndex - targetParameter >= 0) && (targetIndex + targetParameter < targets.size())) {
                            for (int i = targetIndex + targetParameter; i >= targetIndex - targetParameter; i--) {
                                targets.remove(i);
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                        break;
                }
            }

            inputCommandString = scanner.nextLine();
        }

        printTargetsList(targets);
    }

    private static void targetsInputToList(List<Integer> numbersList, String[] input) {
        for (int i = 0; i < input.length; i++) {
            numbersList.add(Integer.parseInt(input[i]));
        }
    }

    private static void printTargetsList(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(numbersList.get(i));
            if (i < numbersList.size() - 1) {
                System.out.print("|");
            }
        }
    }

}