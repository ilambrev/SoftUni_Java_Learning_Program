package E02DataTypesAndVariables;

import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        int tankFullLevel = 0;

        for (int i = 1; i <= numberOfInputs; i++) {
            int littersToFill = Integer.parseInt(scanner.nextLine());
            if ((255 - tankFullLevel) >= littersToFill) {
                tankFullLevel += littersToFill;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(tankFullLevel);
    }
}