package E02MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int degree = rotationDegree(scanner);

        List<String> words = new ArrayList<>();

        char[][] matrix = createMatrix(scanner, words);

        fillMatrix(matrix, words);

        int rotationDegree = degree % 360;

        rotateMatrix(matrix, rotationDegree);
    }

    private static int rotationDegree(Scanner scanner) {
        String command = scanner.nextLine();
        int degree = 0;
        Pattern pattern = Pattern.compile("(?<degree>\\d+)");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            degree = Integer.parseInt(matcher.group("degree"));
        }
        return degree;
    }

    private static char[][] createMatrix(Scanner scanner, List<String> words) {
        String word = scanner.nextLine();

        while (!word.equals("END")) {
            words.add(word);
            word = scanner.nextLine();
        }

        int wordMaxLength = 0;

        for (String string : words) {
            if (string.length() > wordMaxLength) {
                wordMaxLength = string.length();
            }
        }

        int rows = words.size();
        int cols = wordMaxLength;

        return new char[rows][cols];
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (char[] chars : matrix) {
            Arrays.fill(chars, ' ');
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                matrix[i][j] = words.get(i).charAt(j);
            }
        }
    }

    private static void rotateMatrix(char[][] matrix, int rotationDegree) {
        switch (rotationDegree) {
            case 0:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int i = 0; i < matrix[0].length; i++) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        System.out.print(matrix[j][i]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = matrix.length - 1; i >= 0; i--) {
                    for (int j = matrix[i].length - 1; j >= 0; j--) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int i = matrix[0].length - 1; i >= 0; i--) {
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[j][i]);
                    }
                    System.out.println();
                }
                break;
        }
    }

}