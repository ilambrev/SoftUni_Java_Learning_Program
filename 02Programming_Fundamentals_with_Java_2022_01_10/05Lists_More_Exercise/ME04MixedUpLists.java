package ME05Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ME04MixedUpLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputList1 = scanner.nextLine().split(" +");
        String[] inputList2 = scanner.nextLine().split(" +");

        List<Integer> numbersList1 = new ArrayList<>();
        List<Integer> numbersList2 = new ArrayList<>();

        inputToNumbersList(numbersList1, inputList1);
        inputToNumbersList(numbersList2, inputList2);

        int lengthList1 = numbersList1.size();
        int lengthList2 = numbersList2.size();
        List<Integer> mergedList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int startNumber = 0;
        int endNumber = 0;

        if (lengthList1 > lengthList2) {
            for (int i = 0; i < lengthList2; i++) {
                mergedList.add(numbersList1.get(i));
                mergedList.add(numbersList2.get(lengthList2 - 1 - i));
            }
            if (numbersList1.get(numbersList1.size() - 2) > numbersList1.get(numbersList1.size() - 1)) {
                startNumber = numbersList1.get(numbersList1.size() - 1);
                endNumber = numbersList1.get(numbersList1.size() - 2);
            } else if (numbersList1.get(numbersList1.size() - 2) < numbersList1.get(numbersList1.size() - 1)) {
                startNumber = numbersList1.get(numbersList1.size() - 2);
                endNumber = numbersList1.get(numbersList1.size() - 1);
            }
        } else if (lengthList1 < lengthList2) {
            for (int i = 0; i < lengthList1; i++) {
                mergedList.add(numbersList1.get(i));
                mergedList.add(numbersList2.get(lengthList1 + 1 - i));
            }
            if (numbersList2.get(0) > numbersList2.get(1)) {
                startNumber = numbersList2.get(1);
                endNumber = numbersList2.get(0);
            } else if (numbersList2.get(0) < numbersList2.get(1)) {
                startNumber = numbersList2.get(0);
                endNumber = numbersList2.get(1);
            }
        }

        findNumbers(resultList, mergedList, startNumber, endNumber);
        Collections.sort(resultList);

        printList(resultList);
    }

    private static void inputToNumbersList(List<Integer> numbersList, String[] inputList) {
        for (int i = 0; i < inputList.length; i++) {
            numbersList.add(Integer.parseInt(inputList[i]));
        }
    }

    private static void findNumbers(List<Integer> numbersList, List<Integer> mergedList, int startNumber, int endNumber) {
        for (int i = 0; i < mergedList.size(); i++) {
            if (mergedList.get(i) > startNumber && mergedList.get(i) < endNumber) {
                numbersList.add(mergedList.get(i));
            }
        }
    }

    private static void printList(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(numbersList.get(i) + " ");
        }
        System.out.println();
    }

}