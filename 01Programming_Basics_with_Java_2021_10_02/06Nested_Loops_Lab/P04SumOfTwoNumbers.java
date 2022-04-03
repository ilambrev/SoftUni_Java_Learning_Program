package NestedLoops;

import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isValue = false;

        for (int i = firstNum; i <= secondNum; i++) {
            for (int j = firstNum; j <= secondNum; j++) {
                counter++;
                if ((i + j) == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, i + j);
                    isValue = true;
                    break;
                }
            }
            if (isValue) {
                break;
            }
        }
        if (!isValue) {
            System.out.printf("%d combinations - neither equals %d", counter, magicNum);
        }
    }
}