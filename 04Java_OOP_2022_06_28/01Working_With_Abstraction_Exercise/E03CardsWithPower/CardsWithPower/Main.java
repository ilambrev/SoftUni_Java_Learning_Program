package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Rank cardRank = Rank.valueOf(scanner.nextLine());
        Suit cardSuit = Suit.valueOf(scanner.nextLine());

        Card card = new Card(cardRank, cardSuit);

        System.out.printf("Card name: %s of %s; Card power: %d",
                card.getCardRank(), card.getCardSuite(), card.getCardPower());

    }
}