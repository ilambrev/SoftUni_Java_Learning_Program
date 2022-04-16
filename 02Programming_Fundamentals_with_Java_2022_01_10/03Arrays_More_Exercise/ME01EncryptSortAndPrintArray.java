package ME03Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ME01EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stringsNumber = Integer.parseInt(scanner.nextLine());

        int[] codesArr = new int[stringsNumber];

        String vowels = "A E I O U";

        String[] vowelArr = vowels.split(" ");

        for (int i = 0; i < stringsNumber; i++) {
            String currentInput = scanner.nextLine();
            int stringSize = currentInput.length();
            int encryptedString = 0;

            for (int j = 0; j <= stringSize - 1; j++) {
                char currentLetter = currentInput.charAt(j);
                int letterValue = (int) currentLetter;
                boolean isVowel = false;

                for (int k = 0; k < vowelArr.length; k++) {
                    if (Character.toUpperCase(currentLetter) == vowelArr[k].charAt(0)) {
                        encryptedString += letterValue * stringSize;
                        isVowel = true;
                        break;
                    }
                }
                if (!isVowel) {
                    encryptedString += letterValue / stringSize;
                }
            }
            codesArr[i] = encryptedString;
        }
        Arrays.sort(codesArr);
        for (int j : codesArr) {
            System.out.println(j);
        }
    }
}