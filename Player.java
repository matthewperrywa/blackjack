import java.util.ArrayList;

/**
 * @author Matthew Perry
 * Description: Player class represents a player in a card game.
 */
public class Player {

    private String playerName;
    private double playerWins;
    private ArrayList<Card> playerCards;
    private int playerPoints;

    /**
     * Description: Constructs a player with 0 wins, 0 points, and an empty hand of cards.
     * Pre-Condition: The parameter must be a String for the player's name.
     * Post-Condition: A player with the desired name is created.
     */
    public Player(String pN) {
        this.playerName = pN;
        this.playerWins = 0;
        this.playerCards = new ArrayList<Card>();
        this.playerPoints = 0;
    }

    /**
     * Description: Returns the player's name as a String.
     * Pre-Condition: None.
     * Post-Condition: None.
     */
    public String getPlayersName() {
        return this.playerName;
    }

    /**
     * Description: Returns the cards in the player's hand.
     * Pre-Condition: None.
     * Post-Condition: None.
     */
    public ArrayList<Card> getPlayersCards() {
        return this.playerCards;
    }

    /**
     * Description: Adds a card to the player's hand and adds the points associated with that card to the player's points.
     * Pre-Condition: The game deck must have at least one card in it.
     * Post-Condition: The player's cards and points are changed. The game deck is also altered, as a card is removed from it.
     */
    public void addPlayerCard(Deck gameDeck) {
        this.playerCards.add(0, gameDeck.drawCard());
        this.playerPoints += this.playerCards.get(0).getValue();
    }

    /**
     * Description: Adds a card to the player's hand and adds the points associated with that card to the player's points.
     *              The card that is drawn is returned in the form "You drew [card name]".
     * Pre-Condition: The game deck must have at least one card in it.
     * Post-Condition: The player's cards and points are changed. The game deck is also altered, as a card is removed from it.
     */
    public String drawPlayerCard(Deck gameDeck) {
        this.playerCards.add(0, gameDeck.drawCard());
        this.playerPoints += this.playerCards.get(0).getValue();
        return "You drew " + this.playerCards.get(0).toString();
    }

    /**
     * Description: Returns the player's points.
     * Pre-Condition: None.
     * Post-Condition: None.
     */
    public int getPlayerPoints() {
        return this.playerPoints;
    }

    /**
     * Description: Resets the player's points to 0.
     * Pre-Condition: None.
     * Post-Condition: The player points are set to 0.
     */
    public void resetPlayerPoints() {
        this.playerPoints = 0;
    }

    /**
     * Description: Removes all cards from the player's hand.
     * Pre-Condition: None.
     * Post-Condition: The player's hand is now empty.
     */
    public void resetPlayerHand() {
        int playerCardsSize = this.playerCards.size();
        for (int k = 0; k < playerCardsSize; k ++) {
            this.playerCards.remove(0);
        }
    }

    /**
     * Description: Returns the player's wins.
     * Pre-Condition: None.
     * Post-Condition: None.
     */
    public double getWins() {
        return this.playerWins;
    }

    /**
     * Description: Adds a win to the player.
     * Pre-Condition: None.
     * Post-Condition: The player's wins are increased by 1.
     */
    public void addWins() {
        this.playerWins++;
    }

    /**
     * Description: Adds a tie to the player.
     * Pre-Condition: None.
     * Post-Condition: The player's wins are increased by 0.5.
     */
    public void addTie() {
        this.playerWins += 0.5;
    }

}