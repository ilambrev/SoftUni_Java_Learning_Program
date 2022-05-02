package ME08TextProcessing;

import java.util.Scanner;

public class ME02AsciiSumator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] inputSymbols = new char[2];
        inputSymbols[0] = scanner.nextLine().charAt(0);
        inputSymbols[1] = scanner.nextLine().charAt(0);
        String inputText = scanner.nextLine();

        if (inputSymbols[0] > inputSymbols[1]) {
            char changeSymbol = inputSymbols[0];
            inputSymbols[0] = inputSymbols[1];
            inputSymbols[1] = changeSymbol;
        }

        int sumASCIICodes = 0;

        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) > inputSymbols[0] && inputText.charAt(i) < inputSymbols[1]) {
                sumASCIICodes += inputText.charAt(i);
            }
        }

        System.out.println(sumASCIICodes);
    }
}