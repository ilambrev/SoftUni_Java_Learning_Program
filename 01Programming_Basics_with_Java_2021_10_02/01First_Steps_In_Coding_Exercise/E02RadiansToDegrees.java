package e01FirstSteps;

import java.util.Scanner;

public class E02RadiansToDegrees {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double angleRad = Double.parseDouble(scanner.nextLine());
        double angleDeg = angleRad* 180 / Math.PI;

        System.out.println(angleDeg);
    }
}