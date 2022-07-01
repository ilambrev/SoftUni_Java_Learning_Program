package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(input + ":");

        for (Suit s : Suit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", s.ordinal(), s.name());
        }

    }
}