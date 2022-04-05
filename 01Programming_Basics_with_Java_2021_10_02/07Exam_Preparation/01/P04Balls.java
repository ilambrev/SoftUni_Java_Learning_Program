package E2020_07_18And19;

import java.util.Scanner;

public class P04Balls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int redBalls = 0;
        int orangeBalls = 0;
        int yellowBalls = 0;
        int whiteBalls = 0;
        int blackBalls = 0;
        int otherBalls = 0;
        double totalPoints = 0;

        for (int i = 1; i <= n; i++) {
            String ballColor = scanner.nextLine();
            if (ballColor.equals("red")) {
                totalPoints = totalPoints + 5;
                redBalls = redBalls + 1;
            } else if (ballColor.equals("orange")) {
                totalPoints = totalPoints + 10;
                orangeBalls = orangeBalls + 1;
            } else if (ballColor.equals("yellow")) {
                totalPoints = totalPoints + 15;
                yellowBalls = yellowBalls + 1;
            } else if (ballColor.equals("white")) {
                totalPoints = totalPoints + 20;
                whiteBalls = whiteBalls + 1;
            } else if (ballColor.equals("black")) {
                totalPoints = Math.floor(totalPoints / 2);
                blackBalls = blackBalls + 1;
            }

            else {
                otherBalls = otherBalls + 1;
            }
        }

        System.out.printf("Total points: %.0f%n", totalPoints);
        System.out.printf("Points from red balls: %d%n", redBalls);
        System.out.printf("Points from orange balls: %d%n", orangeBalls);
        System.out.printf("Points from yellow balls: %d%n", yellowBalls);
        System.out.printf("Points from white balls: %d%n", whiteBalls);
        System.out.printf("Other colors picked: %d%n", otherBalls);
        System.out.printf("Divides from black balls: %d", blackBalls);
    }
}