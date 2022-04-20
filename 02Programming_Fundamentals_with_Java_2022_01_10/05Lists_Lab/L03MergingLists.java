package L05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L03MergingLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstListInput = scanner.nextLine().split(" ");
        String[] secondListInput = scanner.nextLine().split(" ");

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        readListFromConsole(firstList, firstListInput);
        readListFromConsole(secondList, secondListInput);


        int firstListIndex = 0;
        int secondListIndex = 0;

        while (firstListIndex < firstList.size() || secondListIndex < secondList.size()) {
            if (firstListIndex < firstList.size()) {
                resultList.add(firstList.get(firstListIndex));
                firstListIndex++;
            }
            if (secondListIndex < secondList.size()) {
                resultList.add(secondList.get(secondListIndex));
                secondListIndex++;
            }
        }

        printList(resultList);
    }

    private static void readListFromConsole(List<Integer> listOfNumbers, String[] input) {
        for (String number : input) {
            listOfNumbers.add(Integer.parseInt(number));
        }
    }

    private static void printList(List<Integer> numberList) {
        for (int number : numberList) {
            System.out.print(number + " ");
        }
    }

}