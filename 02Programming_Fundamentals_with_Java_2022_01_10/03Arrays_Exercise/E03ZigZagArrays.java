package E03Arrays;

import java.util.Scanner;

public class E03ZigZagArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrElementsNumber = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String[arrElementsNumber];
        String[] secondArr = new String[arrElementsNumber];

        for (int i = 0; i < arrElementsNumber; i++) {
            String[] bufferArr = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = bufferArr[0];
                secondArr[i] = bufferArr[1];
            } else {
                firstArr[i] = bufferArr[1];
                secondArr[i] = bufferArr[0];
            }
        }
        for(String f : firstArr) {
            System.out.print(f + " ");
        }
        System.out.println();
        for (String s : secondArr) {
            System.out.print(s + " ");
        }
    }
}