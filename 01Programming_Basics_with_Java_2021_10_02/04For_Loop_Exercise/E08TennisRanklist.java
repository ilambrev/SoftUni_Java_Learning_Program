package e04ForLoop;

import java.util.Scanner;

public class E08TennisRanklist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tournamentNumber = Integer.parseInt(scanner.nextLine());
        int initialPoints = Integer.parseInt(scanner.nextLine());

        double tournamentPoints = 0;
        double tournamentWins = 0;

        for (int i = 1; i <= tournamentNumber; i++) {
            String tournamentStage = scanner.nextLine();
            switch (tournamentStage) {
                case "W":
                    tournamentPoints = tournamentPoints + 2000;
                    tournamentWins++;
                    break;
                case "F":
                    tournamentPoints = tournamentPoints + 1200;
                    break;
                case "SF":
                    tournamentPoints = tournamentPoints + 720;
                    break;
            }
        }
        System.out.printf("Final points: %.0f%n", tournamentPoints + initialPoints);
        System.out.printf("Average points: %.0f%n", Math.floor(tournamentPoints / tournamentNumber));
        System.out.printf("%.2f%%", tournamentWins / tournamentNumber * 100 );
    }
}