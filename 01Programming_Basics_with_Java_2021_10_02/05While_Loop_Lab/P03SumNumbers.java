package whileLoop;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        while (sum < number) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum = sum + currentNumber;
        }
        System.out.println(sum);
    }
}