package CardsWithPower;

public class Card {
    private Rank cardRank;
    private Suit cardSuite;
    private int cardPower;

    public Card(Rank cardRank, Suit cardSuite) {
        this.cardRank = cardRank;
        this.cardSuite = cardSuite;
        this.cardPower = this.cardRank.getRankPower() + this.cardSuite.getSuitPower();
    }

    public Rank getCardRank() {
        return this.cardRank;
    }

    public Suit getCardSuite() {
        return this.cardSuite;
    }

    public int getCardPower() {
        return this.cardPower;
    }

}