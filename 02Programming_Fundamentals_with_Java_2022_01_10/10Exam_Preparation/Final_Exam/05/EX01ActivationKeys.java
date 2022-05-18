package EX05FinalExam;

import java.util.Scanner;

public class EX01ActivationKeys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rawKey = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder();
        activationKey.append(rawKey);

        String instructionString = scanner.nextLine();

        while (!instructionString.equals("Generate")) {
            String[] instructionParts = instructionString.split(">>>");
            String instructionName = instructionParts[0];
            switch (instructionName) {
                case "Contains":
                    checkForSubstring(activationKey, instructionParts[1]);
                    break;
                case "Flip":
                    flipSubstring(activationKey, instructionParts[1], Integer.parseInt(instructionParts[2]), Integer.parseInt(instructionParts[3]));
                    break;
                case "Slice":
                    sliceSubstring(activationKey, Integer.parseInt(instructionParts[1]), Integer.parseInt(instructionParts[2]));
                    break;
            }
            instructionString = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", activationKey);
    }

    private static void checkForSubstring(StringBuilder activationKey, String subString) {
        if (activationKey.indexOf(subString) != -1) {
            System.out.printf("%s contains %s%n", activationKey, subString);
        } else {
            System.out.println("Substring not found!");
        }
    }

    private static void flipSubstring(StringBuilder activationKey, String direction, int startIndex, int endIndex) {
        if (direction.equals("Upper")) {
            activationKey.replace(startIndex, endIndex, activationKey.substring(startIndex, endIndex).toUpperCase());
        } else if (direction.equals("Lower")) {
            activationKey.replace(startIndex, endIndex, activationKey.substring(startIndex, endIndex).toLowerCase());
        }
        System.out.println(activationKey);
    }

    private static void sliceSubstring(StringBuilder activationKey, int startIndex, int endIndex) {
        activationKey.delete(startIndex, endIndex);
        System.out.println(activationKey);
    }

}