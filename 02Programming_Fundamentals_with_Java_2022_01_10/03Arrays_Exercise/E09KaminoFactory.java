package E03Arrays;

import java.util.Scanner;

public class E09KaminoFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());
        String sequence = scanner.nextLine();

        int[] sequenceArr = new int[sequenceLength];
        int[] bestSequenceArr = new int[sequenceLength];

        int bestDNA = 1;
        int bestSum = 0;
        int bestDNAStartIndex = 0;
        int bestDNAEndIndex = 0;
        int counter = 0;

        while (!sequence.equals("Clone them!")) {
            counter++;
            boolean isBestDNA = false;
            String[] inputArr = sequence.split("!+");
            for (int i = 0; i < sequenceArr.length; i++) {
                sequenceArr[i] = Integer.parseInt(inputArr[i]);
            }
            int currentDNASum = 0;
            for (int k : sequenceArr) {
                currentDNASum += k;
            }
            int currentStartIndex;
            int currentEndIndex;
            for (int i = 0; i < sequenceArr.length; i++) {
                if (sequenceArr[i] == 1) {
                    currentStartIndex = i;
                    currentEndIndex = i;
                    for (int j = i + 1; j < sequenceArr.length; j++) {
                        if (sequenceArr[j] == 1) {
                            currentEndIndex = j;
                        } else {
                            i = j;
                            break;
                        }
                    }
                } else {
                    continue;
                }
                if ((currentEndIndex - currentStartIndex) > (bestDNAEndIndex - bestDNAStartIndex)) {
                    isBestDNA = true;
                } else if (((currentEndIndex - currentStartIndex) == (bestDNAEndIndex - bestDNAStartIndex)) && (currentStartIndex < bestDNAStartIndex)) {
                    isBestDNA = true;
                } else if (((currentEndIndex - currentStartIndex) == (bestDNAEndIndex - bestDNAStartIndex)) && (currentStartIndex == bestDNAStartIndex) && (currentDNASum > bestSum)) {
                    isBestDNA = true;
                }
                if (isBestDNA) {
                    bestDNAStartIndex = currentStartIndex;
                    bestDNAEndIndex = currentEndIndex;
                    bestSum = currentDNASum;
                    bestDNA = counter;
                    System.arraycopy(sequenceArr, 0, bestSequenceArr, 0, sequenceArr.length);
                    isBestDNA = false;
                }
            }
            sequence = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNA, bestSum);
        for (int j : bestSequenceArr) {
            System.out.print(j + " ");
        }
    }
}