package L06ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class L02SumBigNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = scanner.nextBigInteger();

        BigInteger result = firstNumber.add(secondNumber);

        System.out.println(result);
    }
}