/**
 * @author Matthew Perry
 * Description: Game class represents a turn based card game.
 */
public class Game {

    // if currentPlayer is true, it is player one's turn. if currentPlayer is false, it is player two's turn
    private boolean currentPlayer;
    private int turn;

    /**
     * Description: Constructs a game.
     * Pre-Condition: None.
     * Post-Condition: A game starting at turn 0 and starting with player one is created.
     */
    public Game() {
        this.currentPlayer = true;
        this.turn = 0;
    }

    /**
     * Description: Switches the current player.
     * Pre-Condition: None.
     * Post-Condition: The currentPlayer boolean is changed to the opposite of what it currently is.
     */
    public void switchPlayer() {
        if (this.currentPlayer == true) {
            this.currentPlayer = false ;
        }
        else if (this.currentPlayer == false) {
            this.currentPlayer = true ;
        }
    }

    /**
     * Description: Returns the current player.
     * Pre-Condition: Two players must be the parameters.
     * Post-Condition: From the two players given as parameters, the current one is returned.
     */
    public Player showCurrentPlayer(Player playerOne, Player playerTwo) {
        if (this.currentPlayer == true) {
            return playerOne;
        }
        else {
            return playerTwo;
        }
    }

    /**
     * Description: Increases the turn by 1.
     * Pre-Condition: None.
     * Post-Condition: Turn is increased by 1.
     */
    public void addTurn() {
        this.turn++;
    }

    /**
     * Description: Resets the turn to 0.
     * Pre-Condition: None.
     * Post-Condition: Turn is set to 0.
     */
    public void resetTurn() {
        this.turn = 0;
    }

    /**
     * Description: Returns a string of both players showing a card or the current player's hand based on the turn.
     * Pre-Condition: Parameters must all be players.
     * Post-Condition: A String is returned.
     */
    public String showCards(Player currentPlayer, Player playerOne, Player playerTwo) {
        // players show cards
        if (this.turn == 0) {
            return (playerOne.getPlayersName() + " shows: " + playerOne.getPlayersCards() + "\n" + playerTwo.getPlayersName() + " shows: " + playerTwo.getPlayersCards() );
        }
        // current player's hand is seen
        else {
            return (currentPlayer.getPlayersName() + ", you have " + currentPlayer.getPlayersCards() + " (" + currentPlayer.getPlayerPoints() + ")");
        }
    }

}