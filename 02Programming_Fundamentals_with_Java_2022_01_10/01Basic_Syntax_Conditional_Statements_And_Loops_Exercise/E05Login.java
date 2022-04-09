package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E05Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        int loginAttempts = 0;
        String userNameReversed = "";

        for (int i = userName.length(); i >= 1; i--) {
            userNameReversed += userName.charAt(i - 1);
        }

        while (!password.equals(userNameReversed) && loginAttempts < 3) {
            loginAttempts++;
            System.out.println("Incorrect password. Try again.");
            password = scanner.nextLine();
        }
        if (password.equals(userNameReversed)) {
            System.out.printf("User %s logged in.", userName);
        } else {
            System.out.printf("User %s blocked!", userName);
        }
    }
}