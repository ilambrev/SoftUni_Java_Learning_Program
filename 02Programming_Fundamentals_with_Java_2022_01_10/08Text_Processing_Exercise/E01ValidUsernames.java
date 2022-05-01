package E08TextProcessing;

import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] userNames = scanner.nextLine().split(", ");

        for (String userName : userNames) {
            boolean isNameValid = true;
            if (userName.length() >= 3 && userName.length() <= 16) {
                for (int j = 0; j < userName.length(); j++) {
                    if (!(userName.charAt(j) == '-' || userName.charAt(j) == '_' ||
                            (userName.charAt(j) >= 'A' && userName.charAt(j) <= 'Z') ||
                            (userName.charAt(j) >= 'a' && userName.charAt(j) <= 'z') ||
                            (userName.charAt(j) >= '0' && userName.charAt(j) <= '9'))) {
                        isNameValid = false;
                        break;
                    }
                }
            } else {
                isNameValid = false;
            }
            if (isNameValid) {
                System.out.println(userName);
            }
        }
    }
}