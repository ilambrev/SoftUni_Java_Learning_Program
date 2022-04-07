package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class L07TheatrePromotion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int personAge = Integer.parseInt(scanner.nextLine());

        int ticketPrice = 0;
        boolean ageValue = true;

        if (personAge >= 0 && personAge <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    ticketPrice = 12;
                    break;
                case "Weekend":
                    ticketPrice = 15;
                    break;
                case "Holiday":
                    ticketPrice = 5;
                    break;
            }
        } else if (personAge <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    ticketPrice = 18;
                    break;
                case "Weekend":
                    ticketPrice = 20;
                    break;
                case "Holiday":
                    ticketPrice = 12;
                    break;
            }
        } else if (personAge <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    ticketPrice = 12;
                    break;
                case "Weekend":
                    ticketPrice = 15;
                    break;
                case "Holiday":
                    ticketPrice = 10;
                    break;
            }
        } else {
            ageValue = false;
        }
        if (ageValue && personAge >= 0) {
            System.out.println(ticketPrice + "$");
        } else {
            System.out.println("Error!");
        }
    }
}