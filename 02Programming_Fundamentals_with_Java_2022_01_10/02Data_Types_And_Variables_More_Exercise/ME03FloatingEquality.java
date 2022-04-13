package ME02DataTypesAndVariables;

import java.util.Scanner;

public class ME03FloatingEquality {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final double EPS = 0.000001;

        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());

        if (Math.abs(firstNumber - secondNumber) < EPS) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}