package E02DataTypesAndVariables;

import java.util.Scanner;

public class E11Snowballs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ballsNumber = Integer.parseInt(scanner.nextLine());

        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        double bestSnowBall = Double.MIN_VALUE;

        for (int i = 1; i <= ballsNumber; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);
            if (snowballValue > bestSnowBall) {
                bestSnowBall = snowballValue;
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, bestSnowBall, bestQuality );
    }
}