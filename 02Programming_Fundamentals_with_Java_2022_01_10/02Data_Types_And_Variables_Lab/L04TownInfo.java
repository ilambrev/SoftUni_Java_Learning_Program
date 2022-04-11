package L02DataTypesAndVariables;

import java.util.Scanner;

public class L04TownInfo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int areaInSQRkm = Integer.parseInt(scanner.nextLine());


        System.out.printf("Town %s has population of %d and area %d square km.", townName, population, areaInSQRkm);
    }
}