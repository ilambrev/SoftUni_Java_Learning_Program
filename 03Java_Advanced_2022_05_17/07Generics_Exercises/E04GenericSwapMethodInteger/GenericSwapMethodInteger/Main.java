package GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<Integer> inputData = new Box<>();

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfInputs; i++) {
            Integer data = Integer.parseInt(scanner.nextLine());
            inputData.add(data);
        }

        int[] indices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index1 = indices[0];
        int index2 = indices[1];

        inputData.swap(index1, index2);

        System.out.println(inputData);

    }
}