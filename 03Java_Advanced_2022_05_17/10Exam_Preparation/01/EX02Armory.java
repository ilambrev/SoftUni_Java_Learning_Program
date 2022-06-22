package EX01RetakeExam;

import java.util.Scanner;

public class EX02Armory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int armorySize = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[armorySize][armorySize];

        int[] coordinates = {-1, -1};

        initializeArmory(armory, scanner);

        findPosition(armory, coordinates, 'A');

        int sumPaidForSwords = 0;

        while (sumPaidForSwords < 65) {
            String command = scanner.nextLine();
            if (moveOutOfArmory(armory, command, coordinates)) {
                System.out.println("I do not need more swords!");
                break;
            } else {
                sumPaidForSwords += makeMove(armory, command, coordinates);
            }
        }

        if (sumPaidForSwords >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", sumPaidForSwords);

        printArmory(armory);
    }

    private static void initializeArmory(char[][] armory, Scanner scanner) {
        for (int i = 0; i < armory.length; i++) {
            char[] row = scanner.nextLine().toCharArray();
            armory[i] = row;
        }
    }

    private static void findPosition(char[][] armory, int[] coordinates, char item) {
        boolean coordinatesFound = false;
        for (int i = 0; i < armory.length; i++) {
            if (coordinatesFound) {
                break;
            }
            for (int j = 0; j < armory[i].length; j++) {
                if (armory[i][j] == item) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    coordinatesFound = true;
                    break;
                }
            }
        }
    }

    public static boolean moveOutOfArmory(char[][] armory, String direction, int[] coordinates) {
        int officerRow = coordinates[0];
        int officerCol = coordinates[1];
        switch (direction) {
            case "up":
                if (officerRow - 1 < 0) {
                    armory[officerRow][officerCol] = '-';
                    return true;
                }
                break;
            case "down":
                if (officerRow + 1 > armory.length - 1) {
                    armory[officerRow][officerCol] = '-';
                    return true;
                }
                break;
            case "left":
                if (officerCol - 1 < 0) {
                    armory[officerRow][officerCol] = '-';
                    return true;
                }
                break;
            case "right":
                if (officerCol + 1 > armory.length - 1) {
                    armory[officerRow][officerCol] = '-';
                    return true;
                }
                break;
        }

        return false;
    }

    public static int makeMove(char[][] armory, String direction, int[] coordinates) {
        int moneySpent = 0;
        int officerRow = coordinates[0];
        int officerCol = coordinates[1];
        armory[officerRow][officerCol] = '-';

        switch (direction) {
            case "up":
                if (armory[officerRow - 1][officerCol] == 'M') {
                    armory[officerRow - 1][officerCol] = '-';
                    findPosition(armory, coordinates, 'M');
                    officerRow = coordinates[0];
                    officerCol = coordinates[1];
                } else if (Character.isDigit(armory[officerRow - 1][officerCol])) {
                    moneySpent += Integer.parseInt(String.valueOf(armory[officerRow - 1][officerCol]));
                    officerRow -= 1;
                } else {
                    officerRow -= 1;
                }
                break;
            case "down":
                if (armory[officerRow + 1][officerCol] == 'M') {
                    armory[officerRow + 1][officerCol] = '-';
                    findPosition(armory, coordinates, 'M');
                    officerRow = coordinates[0];
                    officerCol = coordinates[1];
                } else if (Character.isDigit(armory[officerRow + 1][officerCol])) {
                    moneySpent += Integer.parseInt(String.valueOf(armory[officerRow + 1][officerCol]));
                    officerRow += 1;
                } else {
                    officerRow += 1;
                }
                break;
            case "left":
                if (armory[officerRow][officerCol - 1] == 'M') {
                    armory[officerRow][officerCol - 1] = '-';
                    findPosition(armory, coordinates, 'M');
                    officerRow = coordinates[0];
                    officerCol = coordinates[1];
                } else if (Character.isDigit(armory[officerRow][officerCol - 1])) {
                    moneySpent += Integer.parseInt(String.valueOf(armory[officerRow][officerCol - 1]));
                    officerCol -= 1;
                } else {
                    officerCol -= 1;
                }
                break;
            case "right":
                if (armory[officerRow][officerCol + 1] == 'M') {
                    armory[officerRow][officerCol + 1] = '-';
                    findPosition(armory, coordinates, 'M');
                    officerRow = coordinates[0];
                    officerCol = coordinates[1];
                } else if (Character.isDigit(armory[officerRow][officerCol + 1])) {
                    moneySpent += Integer.parseInt(String.valueOf(armory[officerRow][officerCol + 1]));
                    officerCol += 1;
                } else {
                    officerCol += 1;
                }
                break;
        }

        armory[officerRow][officerCol] = 'A';
        coordinates[0] = officerRow;
        coordinates[1] = officerCol;

        return moneySpent;
    }

    private static void printArmory(char[][] armory) {
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                System.out.print(armory[i][j]);
            }
            System.out.println();
        }
    }

}