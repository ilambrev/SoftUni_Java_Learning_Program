package forLoop;

import java.util.Scanner;

public class P07SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= num; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            sum = sum + n;
        }
        System.out.println(sum);
    }
}
