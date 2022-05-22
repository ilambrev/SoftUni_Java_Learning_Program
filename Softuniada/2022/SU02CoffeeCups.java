package Softuniada2022;

import java.util.Scanner;

public class SU02CoffeeCups {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String cupText = scanner.nextLine();

        int width = 3 * n + 6;

        printSteam(n);
        printCupBorder(width, "=");
        printCupUpperPart(n, width, cupText);
        printCupBorder(width, "=");
        printCupLowerPart(n, width);
        printCupBorder(width, "-");


    }

    private static void printSteam(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(" ");
            }
            System.out.println("~ ~ ~");
        }
    }

    private static void printCupBorder(int width, String sign) {
        for (int i = 1; i <= width - 1; i++) {
            System.out.print(sign);
        }
        System.out.println();
    }

    private static void printCupLowerPart(int n, int width) {
        for (int i = 1; i <= n; i++) {
            if (i > 0) {
                for (int k = 1; k < i; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("\\");
            for (int j = 1; j <= width - n - 2 * i; j++) {
                System.out.print("@");
            }
            System.out.println("/");
        }
    }

    private static void printCupUpperPart(int n, int width, String cupText) {
        for (int i = 1; i <= n - 2; i++) {
            System.out.print("|");
            int textPosition = (width - n - 2 - cupText.length()) / 2 + 1;
            if (i == (n - 2) / 2 + 1) {
                for (int j = 1; j <= width - n - 2 - cupText.length(); j++) {
                    if (j == textPosition) {
                        System.out.print(cupText.toUpperCase());
                    }
                    System.out.print("~");
                }
                System.out.print("|");
            } else {
                for (int j = 1; j <= width - n - 2; j++) {
                    System.out.print("~");
                }
                System.out.print("|");
            }
            for (int k = 1; k < n; k++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

}