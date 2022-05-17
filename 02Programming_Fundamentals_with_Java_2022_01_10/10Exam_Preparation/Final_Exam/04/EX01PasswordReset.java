package EX04FinalExam;

import java.util.Scanner;

public class EX01PasswordReset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder passwordString = new StringBuilder(scanner.nextLine());
        String commands = scanner.nextLine();

        while (!commands.equals("Done")) {
            String[] commandParams = commands.split(" ");
            String command = commandParams[0];
            switch (command) {
                case "TakeOdd":
                    getSymbolsOnOddPositions(passwordString);
                    break;
                case "Cut":
                    cutString(passwordString, Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
                    break;
                case "Substitute":
                    substituteString(passwordString, commandParams[1], commandParams[2]);
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", passwordString);
    }

    private static void getSymbolsOnOddPositions(StringBuilder passwordString) {
        String newPassword = passwordString.toString();
        passwordString.setLength(0);
        for (int i = 0; i < newPassword.length(); i++) {
            if (i % 2 != 0) {
                passwordString.append(newPassword.charAt(i));
            }
        }
        System.out.println(passwordString);
    }

    private static void cutString(StringBuilder passwordString, int startIndex, int stringLength) {
        passwordString.delete(startIndex, startIndex + stringLength);
        System.out.println(passwordString);
    }

    private static void substituteString(StringBuilder passwordString, String stringToSubstitute, String newString) {
        if (passwordString.indexOf(stringToSubstitute) != -1) {
            String newPassword = passwordString.toString().replace(stringToSubstitute, newString);
            passwordString.setLength(0);
            passwordString.append(newPassword);
            System.out.println(passwordString);
        } else {
            System.out.println("Nothing to replace!");
        }
    }

}