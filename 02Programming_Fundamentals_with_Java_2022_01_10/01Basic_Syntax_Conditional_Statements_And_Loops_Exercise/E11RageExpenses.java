package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E11RageExpenses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double expenses = 0;

        int brokenHeadsets = lostGamesCount / 2;
        int brokenMises = lostGamesCount / 3;
        int brokenKeyboards = lostGamesCount / 6;
        int brokenDisplays = brokenKeyboards / 2;

        expenses = brokenHeadsets * headsetPrice + brokenMises * mousePrice + brokenKeyboards * keyboardPrice + brokenDisplays * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}