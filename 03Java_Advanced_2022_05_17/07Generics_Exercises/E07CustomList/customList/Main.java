package customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> elements = new CustomList<>();

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("END")) {
            String[] commandParams = inputCommand.split("\\s+");
            String commandName = commandParams[0];

            switch (commandName) {
                case "Add":
                    String elementToAdd = commandParams[1];
                    elements.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandParams[1]);
                    elements.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToCheck = commandParams[1];
                    System.out.println(elements.contains(elementToCheck));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(commandParams[1]);
                    int index2 = Integer.parseInt(commandParams[2]);
                    elements.swap(index1, index2);
                    break;
                case "Greater":
                    String elementToCompare = commandParams[1];
                    System.out.println(elements.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(elements.getMax());
                    break;
                case "Min":
                    System.out.println(elements.getMin());
                    break;
                case "Print":
                    System.out.println(elements);
                    break;
            }

            inputCommand = scanner.nextLine();
        }

    }
}