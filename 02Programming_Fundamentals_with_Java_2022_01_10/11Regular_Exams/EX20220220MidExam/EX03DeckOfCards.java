package EX20220220MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX03DeckOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> cardsList = inputStringToList(scanner);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commands = scanner.nextLine().split(", ");
            int index = 0;
            String cardName = "";

            switch (commands[0]) {
                case "Add":
                    cardName = commands[1];
                    if (checkIfCardIsInDeck(cardsList, cardName)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        cardsList.add(cardName);
                        System.out.println("Card successfully added");
                    }
                    break;
                case "Remove":
                    cardName = commands[1];
                    if (checkIfCardIsInDeck(cardsList, cardName)) {
                        cardsList.remove(cardName);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < cardsList.size()) {
                        cardsList.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(commands[1]);
                    cardName = commands[2];
                    if (index >= 0 && index < cardsList.size()) {
                        if (checkIfCardIsInDeck(cardsList, cardName)) {
                            System.out.println("Card is already added");
                        } else {
                            cardsList.add(index, cardName);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }

        printList(cardsList);
    }

    private static List<String> inputStringToList(Scanner scanner) {
        String[] inputString = scanner.nextLine().split(", ");
        List<String> stringsList = new ArrayList<>();
        for (int i = 0; i < inputString.length; i++) {
            stringsList.add(inputString[i]);
        }
        return stringsList;
    }

    private static boolean checkIfCardIsInDeck(List<String> stringsList, String card) {
        boolean isCardInDeck = false;
        for (int i = 0; i < stringsList.size(); i++) {
            if (stringsList.get(i).equals(card)) {
                isCardInDeck = true;
                break;
            }
        }
        return isCardInDeck;
    }

    private static void printList(List<String> stringsList) {
        for (int i = 0; i < stringsList.size(); i++) {
            System.out.print(stringsList.get(i));
            if (i < stringsList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}