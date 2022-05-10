package EX03MidExamRetake;

import java.util.Scanner;

public class EX02ShootForTheWin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfTargets = scanner.nextLine().split(" +");
        String command = scanner.nextLine();

        int[] targetSequence = new int[inputOfTargets.length];

        int shotTargets = 0;

        inputToNumbers(targetSequence, inputOfTargets);

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            if (index >= 0 && index < targetSequence.length) {
                if (targetSequence[index] != -1) {
                    shotTargets++;
                    int targetValue = targetSequence[index];
                    targetSequence[index] = -1;
                    for (int i = 0; i < targetSequence.length; i++) {
                        if (targetSequence[i] <=  targetValue && targetSequence[i] != -1) {
                            targetSequence[i] += targetValue;
                        } else if (targetSequence[i] >  targetValue && targetSequence[i] != -1) {
                            targetSequence[i] -= targetValue;
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargets);
        printArray(targetSequence);
    }

    private static void inputToNumbers(int[] targetsSequence, String[] inputOfTargets) {
        for (int i = 0; i < inputOfTargets.length; i++) {
            targetsSequence[i] = Integer.parseInt(inputOfTargets[i]);
        }
    }

    private static void printArray(int[] numbersArr) {
        for (int i = 0; i < numbersArr.length; i++) {
            System.out.print(numbersArr[i] + " ");
        }
    }

}