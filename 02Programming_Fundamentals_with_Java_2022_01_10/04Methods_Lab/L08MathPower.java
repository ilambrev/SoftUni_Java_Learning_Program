package L04Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L08MathPower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));
    }

    public static double mathPower(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }

}