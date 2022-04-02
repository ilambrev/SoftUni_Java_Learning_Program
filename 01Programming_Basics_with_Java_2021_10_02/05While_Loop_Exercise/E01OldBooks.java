package e05WhileLoop;

import java.util.Scanner;

public class E01OldBooks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String favoriteBook = scanner.nextLine();
        String inputBook = scanner.nextLine();
        int checkedBooks = 0;

        while (!inputBook.equals("No More Books")) {
            if (inputBook.equals(favoriteBook)) {
                System.out.printf("You checked %d books and found it.", checkedBooks);
                break;
            }
            inputBook = scanner.nextLine();
            checkedBooks ++;
        }
        if (!inputBook.equals(favoriteBook)) {
            System.out.printf("The book you search is not here!%n");
            System.out.printf("You checked %d books.", checkedBooks);
        }
    }
}
