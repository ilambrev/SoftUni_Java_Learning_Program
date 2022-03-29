package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E02SummerOutfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int degree = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (timeOfDay.equals("Morning")) {
            if (degree >= 10 && degree <= 18) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (degree > 18 && degree <= 24) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degree > 24) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        } else if (timeOfDay.equals("Afternoon")) {
            if (degree >= 10 && degree <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degree > 18 && degree <= 24) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (degree > 24) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        } else if (timeOfDay.equals("Evening")) {
              if ((degree >= 10 && degree <= 18) ||  (degree > 18 && degree <= 24) ||  (degree > 24)) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degree, outfit, shoes);
    }
}