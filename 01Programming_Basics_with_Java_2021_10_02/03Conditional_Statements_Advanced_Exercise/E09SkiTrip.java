package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E09SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();

        double price = 0;

        int sleeps = days - 1;

        if (roomType.equals("room for one person")) {
            price = sleeps * 18.0;
        } else if (roomType.equals("apartment")) {
            price = sleeps * 25.0;
            if (days < 10) {
                price = price * 0.70;
            } else if (days <= 15) {
                price = price * 0.65;
            } else {
                price = price * 0.50;
            }
        } else if (roomType.equals("president apartment")) {
            price = sleeps * 35.0;
            if (days < 10) {
                price = price * 0.90;
            } else if (days <= 15) {
                price = price * 0.85;
            } else {
                price = price * 0.80;
            }
        }
        if (rating.equals("positive")) {
            price = price * 1.25;
        } else if (rating.equals("negative")) {
            price = price * 0.9;
        }
        System.out.printf("%.2f", price);
    }
}