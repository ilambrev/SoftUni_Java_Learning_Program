package L06ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class L03BigFactorial {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger number = new BigInteger(scanner.nextLine());

        BigInteger numberFactorial = BigInteger.valueOf(1);

        if (number.equals(BigInteger.ZERO)) {
            System.out.println(1);
        } else {
            for (BigInteger i = BigInteger.valueOf(1); i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
                numberFactorial = numberFactorial.multiply(i);
            }
            System.out.println(numberFactorial);
        }
    }
}