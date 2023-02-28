package E2021_11_20;

import java.util.Scanner;

public class P03CatLife {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String catRace = scanner.nextLine();
        String catSex = scanner.nextLine();

        int catLifeDuration = 0;
        boolean isValid = true;

        switch (catRace) {
            case "British Shorthair":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (13 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (14 * 12) / 6;
                }
                break;
            case "Siamese":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (15 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (16 * 12) / 6;
                }
                break;
            case "Persian":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (14 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (15 * 12) / 6;
                }
                break;
            case "Ragdoll":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (16 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (17 * 12) / 6;
                }
                break;
            case "American Shorthair":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (12 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (13 * 12) / 6;
                }
                break;
            case "Siberian":
                if (catSex.equals("m")) {
                    catLifeDuration = catLifeDuration + (11 * 12) / 6;
                } else if (catSex.equals("f")) {
                    catLifeDuration = catLifeDuration + (12 * 12) / 6;
                }
                break;
            default:
                System.out.printf("%s is invalid cat!", catRace);
                isValid = false;
        }
        if (isValid) {
            System.out.printf("%d cat months", catLifeDuration);
        }
    }
}