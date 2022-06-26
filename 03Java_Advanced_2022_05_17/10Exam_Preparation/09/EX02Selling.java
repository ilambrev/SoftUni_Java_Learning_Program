package EX09RetakeExam;

import java.util.Scanner;

public class EX02Selling {
    private static int playerRow;
    private static int playerCol;
    private static int pillarRow;
    private static int pillarCol;
    private static int earnedMoney;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bakerySize = Integer.parseInt(scanner.nextLine());

        char[][] bakery = new char[bakerySize][bakerySize];

        for (int i = 0; i < bakery.length; i++) {
            String rowString = scanner.nextLine();
            for (int j = 0; j < rowString.length(); j++) {
                bakery[i][j] = rowString.charAt(j);
                if (bakery[i][j] == 'S') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        boolean playerOutOfTheBakery = false;

        while (earnedMoney < 50) {

            String moveDirection = scanner.nextLine();

            switch (moveDirection) {
                case "up":
                    playerOutOfTheBakery = playerMove(bakery, -1, 0);
                    break;
                case "down":
                    playerOutOfTheBakery = playerMove(bakery, 1, 0);
                    break;
                case "left":
                    playerOutOfTheBakery = playerMove(bakery, 0, -1);
                    break;
                case "right":
                    playerOutOfTheBakery = playerMove(bakery, 0, 1);
                    break;
            }

            if (playerOutOfTheBakery) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

        }

        if (earnedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + earnedMoney);

        printBakery(bakery);

    }

    private static boolean playerMove(char[][] bakery, int rowModifier, int colModifier) {
        int nextRow = playerRow + rowModifier;
        int nextCol = playerCol + colModifier;

        bakery[playerRow][playerCol] = '-';

        if (nextRow < 0 || nextRow > bakery.length - 1 || nextCol < 0 || nextCol > bakery[nextRow].length - 1) {
            return true;
        }

        if (Character.isDigit(bakery[nextRow][nextCol])) {
            earnedMoney += Integer.parseInt(String.valueOf(bakery[nextRow][nextCol]));
        } else if (bakery[nextRow][nextCol] == 'O') {
            bakery[nextRow][nextCol] = '-';
            findPillar(bakery);
            nextRow = pillarRow;
            nextCol = pillarCol;
        }

        bakery[nextRow][nextCol] = 'S';
        playerRow = nextRow;
        playerCol = nextCol;

        return false;
    }

    private static void findPillar(char[][] bakery) {
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j] == 'O') {
                    pillarRow = i;
                    pillarCol = j;
                    return;
                }
            }
        }
    }

    private static void printBakery(char[][] bakery) {
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                System.out.print(bakery[i][j]);
            }
            System.out.println();
        }
    }

}