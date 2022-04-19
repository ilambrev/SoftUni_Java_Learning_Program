package ME04Methods;

import java.util.Scanner;

public class ME05MultiplicationSign {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[]{num1, num2, num3};

        findMultiplicationSign(numbers);
    }

    private static void findMultiplicationSign(int[] numbers) {
        int negativeNumbersCount = 0;
        int zeroNumbersCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeNumbersCount++;
            } else if (numbers[i] == 0) {
                zeroNumbersCount++;
            }
        }
        if (zeroNumbersCount > 0) {
            System.out.println("zero");
        } else if ((negativeNumbersCount % 2 == 0 && zeroNumbersCount == 0)) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

}