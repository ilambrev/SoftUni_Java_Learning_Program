package L03Arrays;

import java.util.Scanner;

public class L04ReverseArrayOfStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(" ");
        String[] outputString = new String[inputString.length];

        for (int i = 0; i < inputString.length; i++) {
            outputString[(inputString.length-1) - i] = inputString[i];
        }
        System.out.println(String.join(" ", outputString));
    }
}