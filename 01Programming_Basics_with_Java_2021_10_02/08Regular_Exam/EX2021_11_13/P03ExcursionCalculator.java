package E2021_11_13;

import java.util.Scanner;

public class P03ExcursionCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double excursionPrice = 0;

        if (peopleNumber <= 5) {
            if (season.equals("spring")) {
                excursionPrice = peopleNumber * 50.00;
            } else if (season.equals("summer")) {
                excursionPrice = peopleNumber * (48.50 * 0.85);
            } else if (season.equals("autumn")) {
                excursionPrice = peopleNumber * 60.00;
            } else {
                excursionPrice = peopleNumber * (86.00 * 1.08);
            }
        } else {
            if (season.equals("spring")) {
                excursionPrice = peopleNumber * 48.00;
            } else if (season.equals("summer")) {
                excursionPrice = peopleNumber * (45.00 * 0.85);
            } else if (season.equals("autumn")) {
                excursionPrice = peopleNumber * 49.50;
            } else {
                excursionPrice = peopleNumber * (85.00 * 1.08);
            }
        }
        System.out.printf("%.2f leva.", excursionPrice);
    }
}