package E02DataTypesAndVariables;

import java.util.Scanner;

public class E08BeerKegs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kegNumber = Integer.parseInt(scanner.nextLine());

        String biggerKeg = "";
        double maxVolume = Double.MIN_VALUE;

        for (int i = 1; i <= kegNumber; i++) {
            String kegType = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());
            double currentVolume = Math.PI * Math.pow(kegRadius, 2.0) * kegHeight;

            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
                biggerKeg = kegType;
            }
        }
        System.out.println(biggerKeg);
    }
}