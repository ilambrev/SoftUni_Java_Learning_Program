package e02ConditionalStatements;

import java.util.Scanner;

public class E01SumSeconds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int time1InSec = Integer.parseInt(scanner.nextLine());
        int time2InSec = Integer.parseInt(scanner.nextLine());
        int time3InSec = Integer.parseInt(scanner.nextLine());
        int totalTimeInSec = time1InSec + time2InSec + time3InSec;
        int minutes = totalTimeInSec / 60;
        int seconds = totalTimeInSec % 60;

        if (seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}