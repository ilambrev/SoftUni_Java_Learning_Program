package E03Arrays;

import java.util.Scanner;

public class E07MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        int[] numberArr = new int[inputArr.length];

        int starSequencePoint = 0;
        int endSequencePoint = 0;

        for (int i = 0; i < inputArr.length; i++) {
            numberArr[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < numberArr.length - 1; i++) {
            int startIndex = 0;
            int endIndex = 0;
            if (numberArr[i] == numberArr[i + 1]) {
                startIndex = i;
                for (int j = i; j < inputArr.length; j++) {
                    if (numberArr[i] == numberArr[j]) {
                        endIndex = j;
                    } else {
                        break;
                    }
                }
                if ((endIndex - startIndex) > (endSequencePoint - starSequencePoint)) {
                    starSequencePoint = startIndex;
                    endSequencePoint = endIndex;
                }
            }
        }
            for (int i = starSequencePoint; i <= endSequencePoint; i++) {
                System.out.print(numberArr[i] + " ");
        }
    }
}