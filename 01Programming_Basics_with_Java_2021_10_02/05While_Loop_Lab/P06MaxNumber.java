package whileLoop;

import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxNum = Integer.MIN_VALUE;

        while (!input.equals("Stop")) {
            int currentNum = Integer.parseInt(input);
            if (currentNum > maxNum) {
                maxNum = currentNum;
            }
            input = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}