import java.util.ArrayList;

/**
 * @author Matthew Perry
 * Description: Deck class represents a deck of playing cards.
 */
public class Deck {

    private int numberOfCards;
    private ArrayList<Card> cards;

    /**
     * Description: Constructs a deck.
     * Pre-Condition: None.
     * Post-Condition: A deck with 0 cards in it is created.
     */
    public Deck() {
        this.numberOfCards = 0;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Description: Adds a card to the deck.
     * Pre-Condition: The parameter is a card.
     * Post-Condition: A card is added to the back of the deck and the number of cards in the deck is increased by 1.
     */
    public void addCard(Card card) {
        cards.add(card);
        this.numberOfCards += 1;
    }

    /**
     * Description: Adds 52 standard playing cards to the deck.
     * Pre-Condition: None.
     * Post-Condition: 52 cards are added to the deck by creating and adding 52 new playing cards.
     */
    public void addStandard52() {
        String suit = "";
        // the first for loop determines the suit of each new card
        for (int a = 1; a <= 4; a++) {
            if (a == 1) {
                suit = "Spades";
            }
            if (a == 2) {
                suit = "Diamonds";
            }
            if (a == 3) {
                suit = "Clubs";
            }
            if (a == 4) {
                suit = "Hearts";
            }
            // the second for loop determines the name and value of each new card
            for (int b = 1; b <= 13; b++) {
                if (b == 1) {
                    this.addCard(new Card("Ace", suit, b));
                }
                if (1 < b && b <= 10) {
                    this.addCard(new Card("" + b, suit, b));
                }
                if (b == 11) {
                    this.addCard(new Card("Jack", suit, 10));
                }
                if (b == 12) {
                    this.addCard(new Card("Queen", suit, 10));
                }
                if (b == 13) {
                    this.addCard(new Card("King", suit, 10));
                }
            }
        }
    }

    /**
     * Description: Removes a random card from the deck and returns it.
     * Pre-Condition: The deck must have at least one card in it.
     * Post-Condition: The number of cards decreases by one and a random card is removed and returned.
     */
    public Card drawCard() {
        this.numberOfCards -= 1;
        int cardNumber = (int) (Math.random() * this.cards.size());
        Card drawnCard = this.cards.get(cardNumber);
        this.cards.remove(cardNumber);
        return drawnCard;
    }

    /**
     * Description: Removes all the cards in the deck and adds the 52 standard playing cards to the deck.
     * Pre-Condition: None.
     * Post-Condition: The deck is now 52 standard playing cards with no duplicates.
     */
    public void reshuffle() {
        int cardsSize = this.cards.size();
        for (int k = 0; k < cardsSize; k++) {
            this.numberOfCards -= 1;
            this.cards.remove(0);
        }
        this.addStandard52();
    }

}