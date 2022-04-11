package L02DataTypesAndVariables;

import java.util.Scanner;

public class L07ReversedChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String initialOrder = "";
        String reverseOrder = "";

        for (int i = 1; i <= 3; i++) {
            char letter = scanner.nextLine().charAt(0);
            initialOrder += letter;
        }
        for (int i = 2; i >= 0; i--) {
            reverseOrder += initialOrder.charAt(i) + " ";
        }
        System.out.println(reverseOrder);
    }
}