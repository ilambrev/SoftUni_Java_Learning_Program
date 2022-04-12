package E02DataTypesAndVariables;

import java.util.Scanner;

public class E06TriplesOfLatinLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nLetters = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < 97 + nLetters; i++) {
            for (int j = 97; j < 97 + nLetters; j++) {
                for (int k = 97; k < 97 + nLetters; k++) {
                    System.out.println((char) i + "" + (char) j + "" + (char) k);
                }
            }
        }
    }
}