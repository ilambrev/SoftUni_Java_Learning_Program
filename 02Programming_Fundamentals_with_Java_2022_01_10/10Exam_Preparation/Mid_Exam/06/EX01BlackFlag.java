package EX06MidExamRetake;

import java.util.Scanner;

public class EX01BlackFlag {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int plunderDays = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt((scanner.nextLine()));
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double gainedPlunder = 0;

        for (int i = 1; i <= plunderDays; i++) {
            gainedPlunder += dailyPlunder;
            if (i % 3 == 0) {
                gainedPlunder += (0.5 * dailyPlunder);
            }
            if (i % 5 == 0) {
                gainedPlunder -= (gainedPlunder * 0.3);
            }
        }
        if (gainedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", gainedPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.%n", ((gainedPlunder / expectedPlunder) * 100));
        }
    }
}