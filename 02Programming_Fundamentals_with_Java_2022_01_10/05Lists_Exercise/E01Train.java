package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputOfWagons = scanner.nextLine().split(" ");
        int wagonMaxCapacity = Integer.parseInt(scanner.nextLine());
        String inputCommands = scanner.nextLine();

        List<Integer> wagonsList = new ArrayList<>();

        readListFromConsole(wagonsList, inputOfWagons);

        while (!inputCommands.equals("end")) {
            String[] currentCommand = inputCommands.split(" ");
            if (currentCommand[0].equals("Add")) {
                int wagon = Integer.parseInt(currentCommand[1]);
                addWagonWithPassengers(wagonsList, wagon);
            } else {
                int passengers = Integer.parseInt(currentCommand[0]);
                addPassengersToWagon(wagonsList, wagonMaxCapacity, passengers);
            }

            inputCommands = scanner.nextLine();
        }

        printList(wagonsList);
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static void addWagonWithPassengers(List<Integer> numbersList, int wagon) {
        numbersList.add(wagon);
    }

    private static void addPassengersToWagon(List<Integer> numbersList, int wagonMaxCapacity, int passengers) {
        for (int i = 0; i < numbersList.size(); i++) {
            if ((numbersList.get(i) + passengers) <= wagonMaxCapacity) {
                numbersList.set(i, numbersList.get(i) + passengers);
                break;
            }
        }
    }

    private static void printList(List<Integer> numbersList) {
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}