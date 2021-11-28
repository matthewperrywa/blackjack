// models a card game

public class Game {

    // if currentPlayer is true, it is player one's turn. if currentPlayer is false, it is player two's turn

    private boolean currentPlayer;
    private int turn;

    // constructs a game starting at turn 0 and starting with player one
    public Game() {
        this.currentPlayer = true;
        this.turn = 0;
    }

    // switches the current player
    public void switchPlayer() {
        if (currentPlayer == true) {
            currentPlayer = false ;
        }
        else if (currentPlayer == false) {
            currentPlayer = true ;
        }
    }

    // returns the current player
    public Player showCurrentPlayer(Player playerOne, Player playerTwo) {
        if (currentPlayer == true) {
            return playerOne;
        }
        else {
            return playerTwo;
        }
    }

    // increases the turn by 1
    public void addTurn() {
        this.turn++;
    }

    // resets the turn to 0
    public void resetTurn() {
        this.turn = 0;
    }

    // returns a string of both players showing a card or the current player's hand based on the turn
    public String showCards(Player currentPlayer, Player playerOne, Player playerTwo) {

        if (turn == 0) {
            return (playerOne.getPlayersName() + " shows: " + playerOne.getPlayersCards() + "\n" + playerTwo.getPlayersName() + " shows: " + playerTwo.getPlayersCards() );
        }
        else {
            return (currentPlayer.getPlayersName() + ", you have " + currentPlayer.getPlayersCards() + " (" + currentPlayer.getPlayerPoints() + ")");
        }
    }

}