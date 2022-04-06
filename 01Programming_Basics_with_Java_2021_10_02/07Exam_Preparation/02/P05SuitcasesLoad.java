package E2020_03_28And29;

import java.util.Scanner;

public class P05SuitcasesLoad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double luggageRackVolume = Double.parseDouble(scanner.nextLine());
        String suitcaseVolume = scanner.nextLine();

        int suitcasesLoaded = 0;
        int suitcaseCounter = 0;
        boolean isValid = true;

        while (!suitcaseVolume.equals("End")) {
            double currentSuitcase = Double.parseDouble(suitcaseVolume);
            suitcaseCounter++;
            if (suitcaseCounter == 3) {
                currentSuitcase = currentSuitcase + currentSuitcase * 0.1;
                suitcaseCounter = 0;
            }
            if (currentSuitcase > luggageRackVolume) {
                System.out.println("No more space!");
                isValid = false;
                break;
            }
            luggageRackVolume = luggageRackVolume - currentSuitcase;
            suitcasesLoaded++;
            suitcaseVolume = scanner.nextLine();
        }
        if (isValid) {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitcasesLoaded);
    }
}