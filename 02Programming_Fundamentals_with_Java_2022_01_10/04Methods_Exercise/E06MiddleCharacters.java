package E04Methods;

import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        findMiddleSymbol(inputString);
    }

    public static void findMiddleSymbol(String inputString) {
        String[] stringArr = inputString.split("");
        if (stringArr.length % 2 == 0) {
            System.out.println(stringArr[(stringArr.length / 2) - 1] + stringArr[stringArr.length / 2]);
        } else {
            System.out.println(stringArr[stringArr.length / 2]);
        }
    }

}