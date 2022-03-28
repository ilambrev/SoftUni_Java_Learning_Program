package conditionalStatementsAdvanced;

import java.util.Scanner;

public class P09FruitOrVegetable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String productName = scanner.nextLine();

        if (productName.equals("banana") ||
                productName.equals("apple") ||
                productName.equals("kiwi") ||
                productName.equals("cherry") ||
                productName.equals("lemon") ||
                productName.equals("grapes")) {
            System.out.println("fruit");
        } else if (productName.equals("tomato") ||
                productName.equals("cucumber") ||
                productName.equals("pepper") ||
                productName.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}