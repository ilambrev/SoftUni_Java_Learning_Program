package EX06FinalExamRetake2019PartI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02SantasGifts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        String[] houseNumbersAsStrings = scanner.nextLine().split(" ");
        List<Integer> houseNumbers = new ArrayList<>();
        for (int i = 0; i < houseNumbersAsStrings.length; i++) {
            houseNumbers.add(Integer.parseInt(houseNumbersAsStrings[i]));
        }

        int currentPosition = 0;

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] commandFields = scanner.nextLine().split(" ");
            String commandName = commandFields[0];

            switch (commandName) {
                case "Forward":
                    int stepsForward = Integer.parseInt(commandFields[1]);
                    int stepForwardIndex = currentPosition + stepsForward;
                    if (stepForwardIndex < houseNumbers.size() && stepForwardIndex >= 0) {
                        if (currentPosition < houseNumbers.size() - 1) {
                            currentPosition += stepsForward;
                        }
                        houseNumbers.remove(stepForwardIndex);
                    }
                    break;
                case "Back":
                    int stepsBackward = Integer.parseInt(commandFields[1]);
                    int stepBackwardIndex = currentPosition - stepsBackward;
                    if (stepBackwardIndex < houseNumbers.size() && stepBackwardIndex >= 0) {
                        if (currentPosition > 0) {
                            currentPosition -= stepsBackward;
                        }
                        houseNumbers.remove(stepBackwardIndex);
                    }
                    break;
                case "Gift":
                    int giftIndex = Integer.parseInt(commandFields[1]);
                    int houseNumber = Integer.parseInt(commandFields[2]);
                    if (giftIndex >= 0 && giftIndex <= houseNumbers.size() - 1) {
                        houseNumbers.add(giftIndex, houseNumber);
                        currentPosition = giftIndex;
                    }
                    break;
                case "Swap":
                    int firstHouseNumber = Integer.parseInt(commandFields[1]);
                    int secondHouseNumber = Integer.parseInt(commandFields[2]);
                    if (houseNumbers.contains(firstHouseNumber) && houseNumbers.contains(secondHouseNumber)) {
                        int firstIndex = houseNumbers.indexOf(firstHouseNumber);
                        int secondIndex = houseNumbers.indexOf(secondHouseNumber);
                        int firstIndexValue = houseNumbers.get(firstIndex);
                        houseNumbers.set(firstIndex, houseNumbers.get(secondIndex));
                        houseNumbers.set(secondIndex, firstIndexValue);
                    }
                    break;
            }
        }
        System.out.println("Position: " + currentPosition);
        for (int j = 0; j < houseNumbers.size(); j++) {
            System.out.print(houseNumbers.get(j));
            if (j < houseNumbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}