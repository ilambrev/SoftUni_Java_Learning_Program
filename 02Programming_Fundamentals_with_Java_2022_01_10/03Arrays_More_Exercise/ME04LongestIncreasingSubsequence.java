package ME03Arrays;

import java.util.Scanner;

public class ME04LongestIncreasingSubsequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputSequence = scanner.nextLine().split(" +");
        int[] numbers = new int[inputSequence.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputSequence[i]);
        }

        int[] lisLengths = new int[numbers.length];
        int[] lisPrev = new int[numbers.length];

        for (int i = 0; i < lisLengths.length; i++) {
            lisLengths[i] = 1;
            lisPrev[i] = -1;
        }

        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if (numbers[prevIndex] < numbers[currentIndex]) {
                    int candidateLength = lisLengths[prevIndex] + 1;
                    if (candidateLength > lisLengths[currentIndex]) {
                        lisLengths[currentIndex] = candidateLength;
                        lisPrev[currentIndex] = prevIndex;
                    }
                }
            }
        }

        int maxLength = 0;
        int maxLengthIndex = -1;
        for (int i = 0; i < lisLengths.length; i++) {
            if (lisLengths[i] > maxLength) {
                maxLength = lisLengths[i];
                maxLengthIndex = i;
            }
        }

        int[] lis = new int[lisLengths[maxLengthIndex]];
        int lisIndex = lis.length - 1;
        int index = maxLengthIndex;
        while (index != -1) {
            lis[lisIndex] = numbers[index];
            lisIndex--;
            index = lisPrev[index];
        }

        for (int i = 0; i < lis.length; i++) {
            System.out.print(lis[i]);
            if (i < lis.length - 1) {
                System.out.print(" ");
            }
        }
    }
}