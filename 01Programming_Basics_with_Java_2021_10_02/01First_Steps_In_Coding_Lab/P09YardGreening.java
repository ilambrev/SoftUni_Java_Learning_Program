package firstSteps;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double yardArea = Double.parseDouble(scanner.nextLine());
        double price = yardArea * 7.61;
        double discount = 0.18 * price;

        System.out.println("The final price is: " + (price - discount) + " lv.");
        System.out.println("The discount is: " + discount + " lv.");
    }
}
