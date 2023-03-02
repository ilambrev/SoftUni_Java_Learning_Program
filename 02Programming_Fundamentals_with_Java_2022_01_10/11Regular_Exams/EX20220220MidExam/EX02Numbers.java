package EX20220220MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX02Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSequence = stringSequenceToNumbersList(scanner);
        String listElementsOperations = scanner.nextLine();

        while (!listElementsOperations.equals("Finish")) {
            String[] operations = listElementsOperations.split("\\s+");
            String command = operations[0];
            int elementValue = Integer.parseInt(operations[1]);
            switch (command) {
                case "Add":
                    numbersSequence.add(elementValue);
                    break;
                case "Remove":
                    if (checkIfElementIsInList(numbersSequence, elementValue)) {
                        Integer elementToRemove = elementValue;
                        numbersSequence.remove(elementToRemove);
                    }
                    break;
                case "Replace":
                    int replacementValue = Integer.parseInt(operations[2]);
                    if (checkIfElementIsInList(numbersSequence, elementValue)) {
                        replaceElementFromList(numbersSequence, elementValue, replacementValue);
                    }
                    break;
                case "Collapse":
                    removeElementsFromList(numbersSequence, elementValue);
                    break;
            }

            listElementsOperations = scanner.nextLine();
        }

        printElementsOfNumbersList(numbersSequence);
    }

    private static List<Integer> stringSequenceToNumbersList(Scanner scanner) {
        String[] inputStringSequence = scanner.nextLine().split("\\s+");
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < inputStringSequence.length; i++) {
            numbersList.add(Integer.parseInt(inputStringSequence[i]));
        }
        return numbersList;
    }

    private static boolean checkIfElementIsInList(List<Integer> numbersList, int element) {
        boolean elementExists = false;
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == element) {
                elementExists = true;
                break;
            }
        }
        return elementExists;
    }

    private static void replaceElementFromList(List<Integer> numbersList, int elementValue, int replacementValue) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == elementValue) {
                numbersList.set(i, replacementValue);
                break;
            }
        }
    }

    private static void removeElementsFromList(List<Integer> numbersList, int value) {
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) < value) {
                numbersList.remove(i);
            }
        }
    }

    private static void printElementsOfNumbersList(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(numbersList.get(i));
            if (i < numbersList.size() - 1) {
                System.out.print(" ");
            }
        }
    }

}