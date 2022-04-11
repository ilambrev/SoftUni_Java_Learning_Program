package L02DataTypesAndVariables;

import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sumOfDigits = 0;
        boolean isSpecialNumber = false;

        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            while (currentNumber > 0) {
                sumOfDigits += currentNumber % 10;
                currentNumber /= 10;
            }
            isSpecialNumber = (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11);
            if (isSpecialNumber) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
            sumOfDigits = 0;
        }
    }
}


//    Scanner scanner = new Scanner(System.in);
//    int kolkko = Integer.parseInt(scanner.nextLine());
//    int obshto = 0;
//    int takova = 0;
//    boolean toe = false;
//    for (int ch = 1; ch <= kolkko; ch++) {
//    takova = ch;
//    while (ch > 0) {
//    obshto += ch % 10;
//    ch = ch / 10;
//    }
//    toe = (obshto == 5) || (obshto == 7) || (obshto == 11);
//    System.out.printf("%d -> %b%n", takova, toe);
//    obshto = 0;
//    ch = takova;
//    }
