// models a deck of cards

import java.util.ArrayList;

public class Deck {

    private int numberOfCards;
    private ArrayList<Card> cards;

    // constructs a deck that starts with 0 cards
    public Deck() {
        this.numberOfCards = 0;
        this.cards = new ArrayList<Card>();
    }

    // adds a card to the deck
    public void addCard(Card card) {
        cards.add(card);
        this.numberOfCards += 1;
    }

    // adds the 52 standard playing cards to the deck
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

    // removes a random card from the deck
    public Card drawCard() {
        this.numberOfCards -= 1;
        int cardNumber = (int) (Math.random() * cards.size());
        Card drawnCard = cards.get(cardNumber);
        cards.remove(cardNumber);
        return drawnCard;
    }

    // removes all the cards in the deck and adds the 52 standard playing cards to the deck
    public void reshuffle() {
        int cardsSize = cards.size();
        for (int k = 0; k < cardsSize; k++) {
            this.numberOfCards -= 1;
            cards.remove(0);
        }
        this.addStandard52();
    }
}