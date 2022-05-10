package EX03MidExamRetake;

import java.util.Scanner;

public class EX01CounterStrike {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String inputCommand = scanner.nextLine();

        int wins = 0;
        int currentEnergy = initialEnergy;
        boolean isOutOfEnergy = false;

        while (!inputCommand.equals("End of battle")) {
            int distance = Integer.parseInt(inputCommand);
            if (currentEnergy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wins, currentEnergy);
                isOutOfEnergy = true;
                break;
            } else {
                currentEnergy -= distance;
                wins++;
                if (wins % 3 == 0) {
                    currentEnergy += wins;
                }
            }
            inputCommand = scanner.nextLine();
        }
        if (!isOutOfEnergy) {
            System.out.printf("Won battles: %d. Energy left: %d", wins, currentEnergy);
        }
    }
}