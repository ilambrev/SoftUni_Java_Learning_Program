package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L02PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == numberToFind) {
                    result.append(i).append(" ").append(j).append(System.lineSeparator());
                }
            }
        }

        if (result.toString().equals("")) {
            System.out.println("not found");
        } else {
            System.out.print(result);
        }
    }
}