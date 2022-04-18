package E04Methods;

import java.util.Scanner;

public class E03CharactersInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printChars(firstChar, secondChar);
    }

    public static void printChars(char firstChar, char secondChar) {
        if (firstChar < secondChar) {
            for (int i = firstChar + 1; i < secondChar; i++) {
                char currentChar = (char) i;
                System.out.print(currentChar + " ");
            }
        } else {
            for (int i = secondChar + 1; i < firstChar; i++) {
                char currentChar = (char) i;
                System.out.print(currentChar + " ");
            }
        }
    }

}