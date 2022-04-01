package whileLoop;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String initialPassword = scanner.nextLine();
        String password = scanner.nextLine();

        while (!initialPassword.equals(password)) {
                password = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", username);
    }
}