package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E07SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        Deque<String> commandsToUndo = new ArrayDeque<>();

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfOperations; i++) {
            String[] operationData = scanner.nextLine().split("\\s+");
            String command = operationData[0];

            switch (command) {
                case "1":
                    String textToAdd = operationData[1];
                    String undoCommandAdd = "2 " + textToAdd.length();
                    addText(text, textToAdd);
                    commandsToUndo.push(undoCommandAdd);
                    break;
                case "2":
                    int numberOfElements = Integer.parseInt(operationData[1]);
                    String undoCommandDelete = "1 " + text.substring(text.length() - numberOfElements);
                    deleteText(text, numberOfElements);
                    commandsToUndo.push(undoCommandDelete);
                    break;
                case "3":
                    int elementToPrint = Integer.parseInt(operationData[1]) - 1;
                    System.out.println(text.charAt(elementToPrint));
                    break;
                case "4":
                    if (!commandsToUndo.isEmpty()) {
                        String[] undoOperationData = commandsToUndo.pop().split("\\s+");
                        String undoOperation = undoOperationData[0];
                        if (undoOperation.equals("1")) {
                            String undoDeletedText = undoOperationData[1];
                            addText(text, undoDeletedText);
                        } else {
                            int undoAddedElements = Integer.parseInt(undoOperationData[1]);
                            deleteText(text, undoAddedElements);
                        }
                    }
                    break;
            }

        }

    }

    private static void addText(StringBuilder text, String textToAdd) {
        text.append(textToAdd);
    }

    private static void deleteText(StringBuilder text, int numberOfElements) {
        text.delete(text.length() - numberOfElements, text.length());
    }

}