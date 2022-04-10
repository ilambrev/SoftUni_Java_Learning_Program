package ME01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 1; i <= 3; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i == 1) {
                first = num;
            } else if (i == 2) {
                if (num > first) {
                    second = first;
                    first = num;
                } else {
                    second = num;
                }
            } else {
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } else if (num > second) {
                    third = second;
                    second = num;
                } else {
                    third = num;
                }
            }
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}