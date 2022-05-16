package EX03FinalExamRetake;

import java.util.Scanner;

public class EX01SecretChat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Reveal")) {
            String[] commandParams = inputCommand.split(":\\|:");
            String commandName = commandParams[0];
            switch (commandName) {
                case "InsertSpace":
                    insertSpace(message, Integer.parseInt(commandParams[1]));
                    break;
                case "Reverse":
                    reverseSubstring(message, commandParams[1]);
                    break;
                case "ChangeAll":
                    changeSubstring(message, commandParams[1], commandParams[2]);
                    break;
            }

            inputCommand = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + message);
    }

    private static void insertSpace(StringBuilder message, int index) {
        message.insert(index, " ");
        System.out.println(message);
    }

    private static void reverseSubstring(StringBuilder message, String substring) {
        if (message.indexOf(substring) != -1) {
            int startIndex = message.indexOf(substring);
            message.delete(startIndex, startIndex + substring.length());
            StringBuilder substringToReverse = new StringBuilder(substring);
            String reverseString = substringToReverse.reverse().toString();
            message.append(reverseString);
            System.out.println(message);
        } else {
            System.out.println("error");
        }
    }

    private static void changeSubstring(StringBuilder message, String substring, String replacementString) {
        if (message.indexOf(substring) != -1) {
            String changeMessage = message.toString();
            message.replace(0, message.length(), changeMessage.replace(substring, replacementString));
            System.out.println(message);
        }
    }

}