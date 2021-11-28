// models a card game player

import java.util.ArrayList;

public class Player {

    private String playerName;
    private double playerWins;
    private ArrayList<Card> playerCards;
    private int playerPoints;

    // constructs a player with 0 wins, 0 points, and an empty hand of cards
    public Player(String pN) {
        this.playerName = pN;
        this.playerWins = 0;
        this.playerCards = new ArrayList<Card>();
        this.playerPoints = 0;
    }

    // returns the player's name as a string
    public String getPlayersName() {
        return this.playerName;
    }

    // returns the cards in the player's hand
    public ArrayList<Card> getPlayersCards() {
        return this.playerCards;
    }

    // adds a card to the player's hand and adds the points associated with that card to the player's points
    public void addPlayerCard(Deck gameDeck) {
        this.playerCards.add(0, gameDeck.drawCard());
        this.playerPoints += playerCards.get(0).getValue();
    }

    // adds a card to the player's hand and adds the points associated with that card to the player's points. returns a string declaring the card just drawn
    public String drawPlayerCard(Deck gameDeck) {
        this.playerCards.add(0, gameDeck.drawCard());
        this.playerPoints += playerCards.get(0).getValue();
        return "You drew " + playerCards.get(0).toString();
    }

    // returns the player's points
    public int getPlayerPoints() {
        return this.playerPoints;
    }

    // resets the player's points to 0
    public void resetPlayerPoints() {
        this.playerPoints = 0;
    }

    // removes all cards from the player's hand
    public void resetPlayerHand() {
        int playerCardsSize = playerCards.size();
        for (int k = 0; k < playerCardsSize; k ++) {
            this.playerCards.remove(0);
        }
    }

    // returns the player's wins
    public double getWins() {
        return this.playerWins;
    }

    // adds a win to the player
    public void addWins() {
        this.playerWins++;
    }

    // adds a tie to the player
    public void addTie() {
        this.playerWins += 0.5;
    }
}