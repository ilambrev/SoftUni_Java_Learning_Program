package E05Lists;

import java.util.*;

public class E07AppendArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\|");

        List<Integer> resultList = new ArrayList<>();

        for (int i = inputArr.length - 1; i >= 0; i--) {
            String[] list = inputArr[i].split(" +");
            List<Integer> bufferList = new ArrayList<>();
            for (String element : list) {
                if (element.equals(" ") || element.equals("")) {
                    continue;
                }
                bufferList.add(Integer.parseInt(element));
            }
//            Collections.sort(bufferList);
            for (int number : bufferList) {
                resultList.add(number);
            }
        }

        printList(resultList);
    }

    private static void printList(List<Integer> numbersList) {
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}