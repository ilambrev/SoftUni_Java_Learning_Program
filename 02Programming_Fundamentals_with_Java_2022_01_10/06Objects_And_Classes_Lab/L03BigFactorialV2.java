package L06ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class L03BigFactorialV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        BigInteger factorial = BigInteger.ONE;

        if (number == 0) {
            System.out.println(factorial);
        } else {
            for (int i = 1; i <= number; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
        }
    }
}