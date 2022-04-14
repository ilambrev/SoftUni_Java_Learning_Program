package L03Arrays;

import java.util.Scanner;

public class L06EqualArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");

        int sumOfElements = 0;
        boolean isIdentical = true;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isIdentical = false;
                break;
            }
        }

        if (isIdentical) {
            for (String s : arr1) {
                int currentElement = Integer.parseInt(s);
                sumOfElements += currentElement;
            }
            System.out.printf("Arrays are identical. Sum: %d", sumOfElements);
        }
    }
}