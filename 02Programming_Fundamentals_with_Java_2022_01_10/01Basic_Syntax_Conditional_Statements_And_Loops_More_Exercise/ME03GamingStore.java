package ME01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class ME03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialBalance = Double.parseDouble(scanner.nextLine());
        String gameTitle = scanner.nextLine();

        double currentBalance = initialBalance;

        while (!gameTitle.equals("Game Time")) {

            switch (gameTitle) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (currentBalance >= 39.99) {
                        currentBalance = currentBalance - 39.99;
                        System.out.println("Bought " + gameTitle);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (currentBalance >= 15.99) {
                        currentBalance = currentBalance - 15.99;
                        System.out.println("Bought " + gameTitle);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if (currentBalance >= 19.99) {
                        currentBalance = currentBalance - 19.99;
                        System.out.println("Bought " + gameTitle);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (currentBalance >= 59.99) {
                        currentBalance = currentBalance - 59.99;
                        System.out.println("Bought " + gameTitle);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (currentBalance >= 29.99) {
                        currentBalance = currentBalance - 29.99;
                        System.out.println("Bought " + gameTitle);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            gameTitle = scanner.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", initialBalance - currentBalance, currentBalance);
        }
    }
}