package L03Arrays;

import java.util.Scanner;

public class L04ReverseArrayOfStringsV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArray.length / 2; i++) {
            String currentChar = inputArray[i];
            inputArray[i] = inputArray[inputArray.length -1 - i];
            inputArray[inputArray.length - 1 -i] = currentChar;
        }
        System.out.println(String.join(" ", inputArray));
    }
}