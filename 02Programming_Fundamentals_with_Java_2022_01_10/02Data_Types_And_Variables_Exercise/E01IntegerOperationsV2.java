package E02DataTypesAndVariables;

import java.util.Scanner;

public class E01IntegerOperationsV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[4];

        for (int i = 0; i <= 3; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(((numbers[0] + numbers[1]) / numbers[2]) * numbers[3]);
    }
}