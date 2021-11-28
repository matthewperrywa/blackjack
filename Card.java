// models a card

public class Card {

    private String cardName;
    private String suit;
    private int value;

    public Card(String cN, String s, int v) {
        this.cardName = cN;
        this.suit = s;
        this.value = v;
    }

    // returns the card as a string
    public String toString() {
        return this.cardName + " of " + this.suit;
    }

    // returns the point value associated with the card
    public int getValue() {
        return this.value;
    }
}