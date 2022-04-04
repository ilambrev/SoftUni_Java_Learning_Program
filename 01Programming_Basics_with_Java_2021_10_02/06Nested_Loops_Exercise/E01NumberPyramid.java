package e06NestedLoops;

import java.util.Scanner;

public class E01NumberPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int printed = 1;
        boolean isValid = false;

        for (int rows = 1; rows <= n; rows++) {
            for (int columns = 1; columns <= rows; columns++) {
                if (printed > n) {
                    isValid = true;
                    break;
                }
                System.out.printf("%d ", printed);
                printed++;
            }
            if (isValid) {
                break;
            }
            System.out.println();
        }
    }
}