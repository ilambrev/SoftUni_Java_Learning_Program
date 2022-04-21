package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E08AnonymousThreat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(" +");
        String inputCommand = scanner.nextLine();

        List<String> dataList = new ArrayList<>();

        readDataListFromConsole(dataList, inputData);

        while (!inputCommand.equals("3:1")) {
            String[] command = inputCommand.split(" +");
            String action = command[0];
            if (action.equals("merge")) {
                mergeListElement(dataList, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            } else if (action.equals("divide")) {
                divideListElement(dataList, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            }

            inputCommand = scanner.nextLine();
        }

        printList(dataList);
    }

    private static void readDataListFromConsole(List<String> stringsList, String[] inputData) {
        for (String element : inputData) {
            stringsList.add(element);
        }
    }

    private static void mergeListElement(List<String> stringsList, int startIndex, int endIndex) {
        if ((startIndex <= stringsList.size() - 1) && (endIndex >= 0) && (startIndex <= endIndex) && stringsList.size() > 1) {
            int listSize = stringsList.size();
            if (startIndex >= 0 && endIndex < listSize) {
                for (int i = startIndex; i < endIndex; i++) {
                    stringsList.set(startIndex, stringsList.get(startIndex) + stringsList.get(startIndex + 1));
                    stringsList.remove(startIndex + 1);
                }
            } else if (startIndex < 0 && endIndex < listSize) {
                for (int i = 0; i < endIndex; i++) {
                    stringsList.set(0, stringsList.get(0) + stringsList.get(1));
                    stringsList.remove(1);
                }
            } else if (startIndex >= 0) {
                for (int i = startIndex; i < listSize - 1; i++) {
                    stringsList.set(startIndex, stringsList.get(startIndex) + stringsList.get(startIndex + 1));
                    stringsList.remove(startIndex + 1);
                }
            } else {
                for (int i = 0; i < listSize - 1; i++) {
                    stringsList.set(0, stringsList.get(0) + stringsList.get(1));
                    stringsList.remove(1);
                }
            }
        }
    }


    private static void divideListElement(List<String> stringsList, int index, int partitions) {
        if (index >= 0 && index <= stringsList.size() && partitions > 0) {
            String currentElement = stringsList.get(index);
            int position = 0;
            if (currentElement.length() % partitions == 0) {
                for (int i = 1; i <= partitions; i++) {
                    String newElement = "";
                    for (int j = 0; j < currentElement.length() / partitions; j++) {
                        newElement += currentElement.charAt(position + j);
                    }
                    position += currentElement.length() / partitions;
                    stringsList.add(index + i, newElement);
                }
                stringsList.remove(index);
            } else {
                for (int i = 1; i < partitions; i++) {
                    String newElement = "";
                    for (int j = 0; j < currentElement.length() / partitions; j++) {
                        newElement += currentElement.charAt(position + j);
                    }
                    position += currentElement.length() / partitions;
                    stringsList.add(index + i, newElement);
                }
                String newElement = "";
                for (int i = position; i < currentElement.length(); i++) {
                    newElement += currentElement.charAt(i);
                }
                stringsList.add(index + partitions, newElement);
                stringsList.remove(index);
            }
        }
    }

    private static void printList(List<String> stringsList) {
        for (String element : stringsList) {
            System.out.print(element + " ");
        }
    }

}