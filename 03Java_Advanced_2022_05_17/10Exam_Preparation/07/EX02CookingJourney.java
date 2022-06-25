package EX07RetakeExam;

import java.util.Scanner;

public class EX02CookingJourney {
    static int playerRow;
    static int playerCol;
    static int pillarRow;
    static int pillarCol;
    static int earnedMoney;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pastryShopSize = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = new char[pastryShopSize][pastryShopSize];

        for (int i = 0; i < pastryShop.length; i++) {
            String rowString = scanner.nextLine();
            for (int j = 0; j < rowString.length(); j++) {
                pastryShop[i][j] = rowString.charAt(j);
                if (pastryShop[i][j] == 'S') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        boolean playerOutOfShop = false;

        while (earnedMoney < 50) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    playerOutOfShop = playerMove(pastryShop, -1, 0);
                    break;
                case "down":
                    playerOutOfShop = playerMove(pastryShop, 1, 0);
                    break;
                case "left":
                    playerOutOfShop = playerMove(pastryShop, 0, -1);
                    break;
                case "right":
                    playerOutOfShop = playerMove(pastryShop, 0, 1);
                    break;
            }

            if (playerOutOfShop) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
        }

        if (earnedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + earnedMoney);

        printPastryShop(pastryShop);

    }

    private static boolean playerMove(char[][] pastryShop, int rowModifier, int colModifier) {
        int nextRow = playerRow + rowModifier;
        int nextCol = playerCol + colModifier;

        pastryShop[playerRow][playerCol] = '-';

        if (nextRow < 0 || nextRow > pastryShop.length - 1 || nextCol < 0 || nextCol > pastryShop[nextRow].length - 1) {
            return true;
        }

        if (String.valueOf(pastryShop[nextRow][nextCol]).matches("\\d+")) {
            earnedMoney += Integer.parseInt(String.valueOf(pastryShop[nextRow][nextCol]));
        } else if (pastryShop[nextRow][nextCol] == 'P') {
            pastryShop[nextRow][nextCol] = '-';
            findPillar(pastryShop);
            nextRow = pillarRow;
            nextCol = pillarCol;
        }

        pastryShop[nextRow][nextCol] = 'S';
        playerRow = nextRow;
        playerCol = nextCol;

        return false;
    }

    private static void findPillar(char[][] pastryShop) {
        for (int i = 0; i < pastryShop.length; i++) {
            for (int j = 0; j < pastryShop[i].length; j++) {
                if (pastryShop[i][j] == 'P') {
                    pillarRow = i;
                    pillarCol = j;
                    break;
                }
            }
        }
    }

    private static void printPastryShop(char[][] pastryShop) {
        for (int i = 0; i < pastryShop.length; i++) {
            for (int j = 0; j < pastryShop[i].length; j++) {
                System.out.print(pastryShop[i][j]);
            }
            System.out.println();
        }
    }

}