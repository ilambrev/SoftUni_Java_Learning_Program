package e02ConditionalStatements;

import java.util.Scanner;

public class E06WorldSwimmingRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double recordSec = Double.parseDouble(scanner.nextLine());
        double distanceMetres = Double.parseDouble(scanner.nextLine());
        double timeSec = Double.parseDouble(scanner.nextLine());

        double delay = Math.floor(distanceMetres / 15) * 12.5;
        double timeIvan = distanceMetres * timeSec + delay;

        if (timeIvan < recordSec) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeIvan);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeIvan - recordSec);
        }
    }
}