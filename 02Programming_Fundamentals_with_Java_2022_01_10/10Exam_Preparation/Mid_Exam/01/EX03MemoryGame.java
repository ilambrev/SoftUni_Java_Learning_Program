package EX01MidExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX03MemoryGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputSequence = scanner.nextLine().split(" +");
        String inputCommand = scanner.nextLine();

        List<String> sequenceList = new ArrayList<>();
        inputStringToList(sequenceList, inputSequence);

        int moves = 0;

        while (!inputCommand.equals("end")) {
            moves++;
            String[] command = inputCommand.split(" +");
            int index1 = Integer.parseInt(command[0]);
            int index2 = Integer.parseInt(command[1]);
            if (index1 == index2 || (index1 < 0 || index1 > (sequenceList.size() - 1)) || (index2 < 0 || index2 > (sequenceList.size() - 1))) {
                String penalElement = "-" + moves + "a";
                sequenceList.add(sequenceList.size() / 2, penalElement);
                sequenceList.add((sequenceList.size() / 2) + 1, penalElement);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (sequenceList.get(index1).equals(sequenceList.get(index2))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequenceList.get(index1));
                    if (index1 < index2) {
                        sequenceList.remove(index2);
                        sequenceList.remove(index1);
                    } else {
                        sequenceList.remove(index1);
                        sequenceList.remove(index2);
                    }

                } else {
                    System.out.println("Try again!");
                }
            }
            if (sequenceList.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", moves);
                break;
            }
            inputCommand = scanner.nextLine();
        }
        if (!sequenceList.isEmpty()) {
            System.out.println("Sorry you lose :(");
            printList(sequenceList);
        }
    }

    private static void inputStringToList(List<String> sequenceList, String[] inputSequence) {
        for (int i = 0; i < inputSequence.length; i++) {
            sequenceList.add(inputSequence[i]);
        }
    }

    private static void printList(List<String> sequenceList) {
        for (String element : sequenceList) {
            System.out.print(element + " ");
        }
    }

}