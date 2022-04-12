package E02DataTypesAndVariables;

import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int spiceProduction = 0;

        while (startYield >= 100) {
            days += 1;
            spiceProduction += (startYield - 26);
            startYield -= 10;
            if (startYield < 100) {
                spiceProduction -= 26;
            }
        }
        System.out.println(days);
        System.out.println(spiceProduction);
    }
}