package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryDigits = new ArrayDeque<>();

        while (decimalNumber > 1) {
            binaryDigits.push(decimalNumber % 2);
            decimalNumber /= 2;
        }
        binaryDigits.push(decimalNumber);

        for (Integer digit : binaryDigits) {
            System.out.print(digit);
        }

    }
}