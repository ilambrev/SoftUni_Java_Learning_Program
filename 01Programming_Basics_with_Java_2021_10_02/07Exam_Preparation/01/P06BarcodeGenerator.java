package E2020_07_18And19;

import java.util.Scanner;

public class P06BarcodeGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());


        for (int i = (firstNum / 1000) % 10; i <= (secondNum / 1000) % 10; i++) {
            for (int j = (firstNum / 100) % 10; j <= (secondNum / 100) % 10; j++) {
                for (int k = (firstNum / 10) % 10; k <= (secondNum / 10) % 10; k++) {
                    for (int l = firstNum % 10; l <= secondNum % 10; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }

    }
}