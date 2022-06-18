package E02MultidimensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] chamber = new char[15][15];

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000.0;
        int cloudSpell = 3500;
        int eruptionSpell = 6000;

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        String currentSpell = "";
        int playerRow = 7;
        int playerCol = 7;
        boolean hitByCloud = false;

        while (playerHitPoints > 0 && heiganHitPoints > 0) {
            String[] spellParams = scanner.nextLine().split("\\s+");
            String spell = spellParams[0];
            int row = Integer.parseInt(spellParams[1]);
            int col = Integer.parseInt(spellParams[2]);

            if (row < -1 || row > 15 || col < -1 || col > 15) {
                break;
            }

            heiganHitPoints -= damageToHeigan;

            if (heiganHitPoints <= 0) {
                if (hitByCloud) {
                    playerHitPoints -= cloudSpell;
                }
                break;
            }

            if (hitByCloud) {
                playerHitPoints -= cloudSpell;
                hitByCloud = false;
                if (playerHitPoints <= 0) {
                    break;
                }
            }

            arrangeChamber(chamber);

            castSpell(chamber, row, col);
            if (chamber[playerRow][playerCol] == 'd') {
                String turn = playerMove(chamber, playerRow, playerCol);
                switch (turn) {
                    case "up":
                        playerRow--;
                        break;
                    case "right":
                        playerCol++;
                        break;
                    case "down":
                        playerRow++;
                        break;
                    case "left":
                        playerCol--;
                        break;
                    default:
                        if (spell.equals("Cloud")) {
                            playerHitPoints -= cloudSpell;
                            hitByCloud = true;
                        } else if (spell.equals("Eruption")) {
                            playerHitPoints -= eruptionSpell;
                        }
                        break;
                }
            }

            currentSpell = spell;
        }

        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }
        if (playerHitPoints <= 0) {
            if (currentSpell.equals("Eruption")) {
                System.out.printf("Player: Killed by %s%n", currentSpell);
            } else {
                System.out.printf("Player: Killed by Plague %s%n", currentSpell);
            }
        } else {
            System.out.printf("Player: %d%n", playerHitPoints);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);

    }

    private static void arrangeChamber(char[][] chamber) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                chamber[i][j] = 'h';
            }
        }
    }

    private static void castSpell(char[][] chamber, int row, int col) {
        int beginRow = Math.max(row - 1, 0);
        int beginCol = Math.max(col - 1, 0);
        int endRow = Math.min(row + 1, chamber.length - 1);
        int endCol = Math.min(col + 1, chamber.length - 1);
        for (int i = beginRow; i <= endRow; i++) {
            for (int j = beginCol; j <= endCol; j++) {
                chamber[i][j] = 'd';
            }
        }

    }

    private static String playerMove(char[][] chamber, int playerRow, int playerCol) {
        if (playerRow - 1 >= 0 && chamber[playerRow - 1][playerCol] != 'd') {
            return "up";
        } else if (playerCol + 1 <= chamber.length - 1 && chamber[playerRow][playerCol + 1] != 'd') {
            return "right";
        } else if (playerRow + 1 <= chamber.length - 1 && chamber[playerRow + 1][playerCol] != 'd') {
            return "down";
        } else if (playerCol - 1 >= 0 && chamber[playerRow][playerCol - 1] != 'd') {
            return "left";
        } else {
            return "no turn";
        }

    }

}