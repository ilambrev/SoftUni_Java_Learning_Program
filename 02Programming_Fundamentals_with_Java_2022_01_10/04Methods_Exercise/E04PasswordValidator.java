package E04Methods;

import java.util.Scanner;

public class E04PasswordValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValidPassword = true;

        if (numberOfCharactersCheck(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            isValidPassword = false;
        }
        if (lettersAndNumbersCheck(password)) {
            System.out.println("Password must consist only of letters and digits");
            isValidPassword = false;
        }
        if (numberOfDigitsCheck(password)) {
            System.out.println("Password must have at least 2 digits");
            isValidPassword = false;
        }
        if (isValidPassword) {
            System.out.println("Password is valid");
        }

    }

    public static boolean numberOfCharactersCheck(String password) {
        if (password.length() < 6 || password.length() > 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean lettersAndNumbersCheck(String password) {
        int specialSymbolsCounter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar < 48 || (currentChar > 57 && currentChar < 65) || (currentChar > 90 && currentChar < 97) || currentChar > 122) {
                specialSymbolsCounter++;
                break;
            }
        }
        if (specialSymbolsCounter > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOfDigitsCheck(String password) {
        int digitsCounter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) {
                digitsCounter++;
            }
        }
        if (digitsCounter < 2) {
            return true;
        } else {
            return false;
        }
    }

}