package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E07HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int sleepsNumber = Integer.parseInt(scanner.nextLine());

        double apartmentPrice = 0;
        double studioPrice = 0;

        if (month.equals("May") || month.equals("October")) {
            if (sleepsNumber <= 7) {
                studioPrice = sleepsNumber * 50.0;
            } else if (sleepsNumber <= 14) {
                studioPrice = sleepsNumber * 50.0 * 0.95;
            } else {
                studioPrice = sleepsNumber * 50.0 * 0.7;
            }
            apartmentPrice = sleepsNumber * 65.0;
        } else if (month.equals("June") || month.equals("September")) {
            if (sleepsNumber <= 14) {
                studioPrice = sleepsNumber * 75.20;
            } else {
                studioPrice = sleepsNumber * 75.20 * 0.8;
            }
            apartmentPrice = sleepsNumber * 68.70;
        } else if (month.equals("July") || month.equals("August")) {
            studioPrice = sleepsNumber * 76.0;
            apartmentPrice = sleepsNumber * 77.0;
        }

        if (sleepsNumber > 14) {
            apartmentPrice = apartmentPrice * 0.9;
        }
        System.out.printf("Apartment: %.2f lv.%n", apartmentPrice);
        System.out.printf("Studio: %.2f lv.", studioPrice);
    }
}