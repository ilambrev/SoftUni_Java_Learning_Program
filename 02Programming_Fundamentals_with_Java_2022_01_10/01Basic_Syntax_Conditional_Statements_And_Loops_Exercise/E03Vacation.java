package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String weekDay = scanner.nextLine();

        double totalPrice = 0;

        if (groupType.equals("Students")) {
            if (weekDay.equals("Friday")) {
                totalPrice = peopleNumber * 8.45;
            } else if (weekDay.equals("Saturday")) {
                totalPrice = peopleNumber * 9.80;
            } else if (weekDay.equals("Sunday")) {
                totalPrice = peopleNumber * 10.46;
            }
            if (peopleNumber >= 30) {
                totalPrice *= 0.85;
            }
        } else if (groupType.equals("Business")) {
            if (peopleNumber >= 100) {
                peopleNumber -= 10;
            }
            if (weekDay.equals("Friday")) {
                totalPrice = peopleNumber * 10.90;
            } else if (weekDay.equals("Saturday")) {
                totalPrice = peopleNumber * 15.60;
            } else if (weekDay.equals("Sunday")) {
                totalPrice = peopleNumber * 16.00;
            }
        } else if (groupType.equals("Regular")) {
            if (weekDay.equals("Friday")) {
                totalPrice = peopleNumber * 15.00;
            } else if (weekDay.equals("Saturday")) {
                totalPrice = peopleNumber * 20.00;
            } else if (weekDay.equals("Sunday")) {
                totalPrice = peopleNumber * 22.50;
            }
            if (peopleNumber >= 10 && peopleNumber <= 20) {
                totalPrice *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}