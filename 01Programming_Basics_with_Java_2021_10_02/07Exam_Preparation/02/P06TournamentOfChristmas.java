package E2020_03_28And29;

import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tournamentDays = Integer.parseInt(scanner.nextLine());
        double moneyWonForTournament = 0;
        int daysWinCounter = 0;
        int daysLossCounter = 0;

        for (int i = 1; i <= tournamentDays; i++) {
            String sport = scanner.nextLine();
            double moneyWonPerDay = 0;
            int winCounter = 0;
            int lossCounter = 0;
            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                if (result.equals("win")) {
                    moneyWonPerDay = moneyWonPerDay + 20.0;
                    winCounter++;
                } else {
                    lossCounter++;
                }
                sport = scanner.nextLine();
            }
            if (winCounter > lossCounter) {
                moneyWonPerDay = moneyWonPerDay + moneyWonPerDay * 0.1;
                daysWinCounter++;
            } else {
                daysLossCounter++;
            }
            moneyWonForTournament = moneyWonForTournament + moneyWonPerDay;
        }
        if (daysWinCounter > daysLossCounter) {
            System.out.printf("You won the tournament! Total raised money: %.2f", moneyWonForTournament * 1.2);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", moneyWonForTournament);
        }
    }
}