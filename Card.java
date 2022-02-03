/**
 * @author Matthew Perry
 * Description: Card class represents a standard playing card.
 */
public class Card {

    private String cardName;
    private String suit;
    private int value;

    /**
     * Description: Constructs a card.
     * Pre-Condition: A card name, suit, and value must be assigned in the parameters.
     * Post-Condition: A card with the given characteristics is created.
     */
    public Card(String cN, String s, int v) {
        this.cardName = cN;
        this.suit = s;
        this.value = v;
    }

    /**
     * Description: The card name and suit is returned.
     * Pre-Condition: None.
     * Post-Condition: A String is returned.
     */
    public String toString() {
        return this.cardName + " of " + this.suit;
    }

    /**
     * Description: The card's value is returned.
     * Pre-Condition: None.
     * Post-Condition: An int is returned.
     */
    public int getValue() {
        return this.value;
    }

}