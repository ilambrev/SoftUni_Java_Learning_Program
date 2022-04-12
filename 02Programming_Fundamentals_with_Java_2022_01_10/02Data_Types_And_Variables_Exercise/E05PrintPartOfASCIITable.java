package E02DataTypesAndVariables;

import java.util.Scanner;

public class E05PrintPartOfASCIITable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startIndex = Integer.parseInt(scanner.nextLine());
        int endIndex = Integer.parseInt(scanner.nextLine());

        for (int i = startIndex; i <= endIndex; i++) {
            char symbol = (char) i;
            System.out.printf("%c ", symbol);
        }
    }
}