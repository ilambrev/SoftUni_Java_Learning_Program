package EX20220403FinalExam;

import java.util.Scanner;

public class EX01DecryptingCommands {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            String[] commandParts = command.split("\\s+");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Replace":
                    replaceLetters(string, commandParts[1], commandParts[2]);
                    break;
                case "Cut":
                    cutSubstring(string, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    break;
                case "Make":
                    replaceUpperLowerLetters(string, commandParts[1]);
                    break;
                case "Check":
                    checkForSubstring(string, commandParts[1]);
                    break;
                case "Sum":
                    calculateSymbolsCodesSum(string, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static void replaceLetters(StringBuilder string, String currentString, String newString) {
        String transitString = string.toString();
        string.setLength(0);
        string.append(transitString.replace(currentString, newString));
        System.out.println(string);
    }

    private static void cutSubstring(StringBuilder string, int startIndex, int endIndex) {
        if ((startIndex >= 0 && startIndex < string.length()) && (endIndex < string.length() && endIndex >= 0)) {
            string.delete(startIndex, endIndex + 1);
            System.out.println(string);
        } else {
            System.out.println("Invalid indices!");
        }
    }

    private static void replaceUpperLowerLetters(StringBuilder string, String letterCase) {
        String newString = "";
        if (letterCase.equals("Upper")) {
            newString = string.toString().toUpperCase();
        } else if (letterCase.equals("Lower")) {
            newString = string.toString().toLowerCase();
        }
        string.setLength(0);
        string.append(newString);
        System.out.println(string);
    }

    private static void checkForSubstring(StringBuilder string, String substring) {
        if (string.indexOf(substring) != -1) {
            System.out.println("Message contains " + substring);
        } else {
            System.out.println("Message doesn't contain " + substring);
        }
    }

    private static void calculateSymbolsCodesSum(StringBuilder string, int startIndex, int endIndex) {
        int sumOfSymbolsCodes = 0;
        if ((startIndex >= 0 && startIndex < string.length()) && (endIndex < string.length() && endIndex >= 0)) {
            for (int i = startIndex; i <= endIndex; i++) {
                int symbolCode = string.charAt(i);
                sumOfSymbolsCodes += symbolCode;
            }
            System.out.println(sumOfSymbolsCodes);
        } else {
            System.out.println("Invalid indices!");
        }
    }

}