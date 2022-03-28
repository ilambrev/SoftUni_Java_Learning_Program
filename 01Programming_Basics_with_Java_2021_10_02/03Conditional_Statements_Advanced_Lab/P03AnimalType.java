package conditionalStatementsAdvanced;

import java.util.Scanner;

public class P03AnimalType {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();

        if (animal.equals("dog")) {
            System.out.println("mammal");
            } else if (animal.equals("crocodile") || animal.equals("tortoise") || animal.equals("snake")) {
            System.out.println("reptile");
        } else {
            System.out.println("unknown");
        }
    }
}