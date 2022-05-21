package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

//Solution from presentation. Judge Test 4 Wrong Answer????? TODO check if decimalNumber == 0?

public class L03DecimalToBinaryV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryDigits = new ArrayDeque<>();

        if (decimalNumber == 0) {
            binaryDigits.push(decimalNumber);
        }

        while (decimalNumber != 0) {
            binaryDigits.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        while (!binaryDigits.isEmpty()) {
            System.out.print(binaryDigits.pop());
        }

    }
}