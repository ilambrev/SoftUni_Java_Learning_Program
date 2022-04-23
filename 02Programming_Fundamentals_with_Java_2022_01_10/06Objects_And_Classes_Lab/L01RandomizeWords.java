package L06ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class L01RandomizeWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] listOfWord = scanner.nextLine().split("\\s+");
        Random rdm = new Random();

        for (int i = 0; i < listOfWord.length; i++) {
            int index = rdm.nextInt(listOfWord.length);
            String currentElement = listOfWord[i];
            listOfWord[i] = listOfWord[index];
            listOfWord[index] = currentElement;
        }

        for (int i = 0; i < listOfWord.length; i++) {
            System.out.println(listOfWord[i]);
        }
    }
}