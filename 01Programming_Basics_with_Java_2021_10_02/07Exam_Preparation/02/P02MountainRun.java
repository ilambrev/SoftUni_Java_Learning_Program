package E2020_03_28And29;

import java.util.Scanner;

public class P02MountainRun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeForMeter = Double.parseDouble(scanner.nextLine());


        double delay = Math.floor(distance / 50);
        double timeGeorgi = distance * timeForMeter + delay * 30;

        if (timeGeorgi < record) {
            System.out.printf("Yes! The new record is %.2f seconds.", timeGeorgi);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", timeGeorgi - record);
        }
    }
}