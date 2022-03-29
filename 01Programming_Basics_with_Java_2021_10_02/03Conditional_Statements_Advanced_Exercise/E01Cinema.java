package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E01Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String showType = scanner.nextLine();
        int rawNumber = Integer.parseInt(scanner.nextLine());
        int columnNumber = Integer.parseInt(scanner.nextLine());

        double income = 0;

        switch (showType) {
            case "Premiere":
                income = rawNumber * columnNumber * 12.00;
                break;
            case "Normal":
                income = rawNumber * columnNumber * 7.50;
                break;
            case "Discount":
                income = rawNumber * columnNumber * 5.00;
                break;
        }
        System.out.printf("%.2f leva", income);
    }
}