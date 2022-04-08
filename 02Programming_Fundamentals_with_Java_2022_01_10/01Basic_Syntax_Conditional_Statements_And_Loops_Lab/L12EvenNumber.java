package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class L12EvenNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = scanner.nextInt();
        }
        System.out.println("The number is: " + Math.abs(number));
    }
}