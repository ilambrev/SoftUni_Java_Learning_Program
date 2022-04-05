package E2020_07_18And19;

import java.util.Scanner;

public class P05BestPlayer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        int maxGoalNum = Integer.MIN_VALUE;
        String bestPlayerName = "";
        boolean isValue = false;

        while (!playerName.equals("END")) {
            int goalNumber = Integer.parseInt(scanner.nextLine());
            if (goalNumber >= 10) {
                System.out.printf("%s is the best player!%n", playerName);
                System.out.printf("He has scored %d goals and made a hat-trick !!!", goalNumber);
                isValue = true;
                break;
            }
            if (goalNumber > maxGoalNum) {
                maxGoalNum = goalNumber;
                bestPlayerName = playerName;
            }
            playerName = scanner.nextLine();
        }
        if (!isValue) {
            System.out.printf("%s is the best player!%n", bestPlayerName);
            if (maxGoalNum >= 3) {
                System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoalNum);
            } else {
                System.out.printf("He has scored %d goals.", maxGoalNum);
            }
        }
    }
}