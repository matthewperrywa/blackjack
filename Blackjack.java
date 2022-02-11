import java.util.Scanner;

/**
 * @author Matthew Perry
 * Description: Main class. Playable 2 player blackjack game.
 */
public class Blackjack {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);

        Game blackjack = new Game();
        Deck gameDeck = new Deck();

        System.out.print("Welcome to Blackjack!\nPlease enter the name of Player 1: ");
        String playerOneName = input.nextLine();

        System.out.print("Please enter the name of Player 2: ");
        String playerTwoName = input.nextLine();

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        String playAgain = "y"; // used to determine when the user wants to play again or quit

        while (playAgain.contains("y") || playAgain.contains("Y")) {
            gameDeck.reshuffle();

            playerOne.addPlayerCard(gameDeck);
            playerTwo.addPlayerCard(gameDeck);

            // showCards is the information that is printed to show one of each player's cards
            String showCards = blackjack.showCards(blackjack.showCurrentPlayer(playerOne, playerTwo), playerOne, playerTwo);

            // this loop runs twice; once for each player. allows current player to continue hitting until they decide to stand or they bust
            for (int k = 0; k < 2; k++) {
                System.out.println("==============");
                System.out.println(showCards);
                System.out.println();
                System.out.println(blackjack.showCurrentPlayer(playerOne, playerTwo).getPlayersName() + ", it is your turn.");
                String hitOrStand = "h";
                blackjack.addTurn();
                blackjack.showCurrentPlayer(playerOne, playerTwo).addPlayerCard(gameDeck);

                while (hitOrStand.contains("h") || hitOrStand.contains("H")) {
                    System.out.println(blackjack.showCards(blackjack.showCurrentPlayer(playerOne, playerTwo), playerOne, playerTwo));
                    System.out.println("Do you want to [h]it or [s]tand?");
                    hitOrStand = input.nextLine();
                    // if the input does not contain "h" or "H", the player will stand
                    if (hitOrStand.contains("h") || hitOrStand.contains("H")) {
                        System.out.println(blackjack.showCurrentPlayer(playerOne, playerTwo).drawPlayerCard(gameDeck) + ".");
                    }
                    else {
                        System.out.println(blackjack.showCurrentPlayer(playerOne, playerTwo).getPlayersName() + " stands.");
                    }
                    if (blackjack.showCurrentPlayer(playerOne, playerTwo).getPlayerPoints() > 21) {
                        System.out.println(blackjack.showCurrentPlayer(playerOne, playerTwo).getPlayersName() + " busts!");
                        hitOrStand = "s";
                    }
                }

                // the current player is switched before the loop runs again
                blackjack.switchPlayer();

            }

            // the current player is switched so if they decide to play again, the order of play is reversed
            blackjack.switchPlayer();

            // the following if loops are used to make the players have 0 points if they bust

            if (playerOne.getPlayerPoints() > 21) {
                playerOne.resetPlayerPoints();
            }
            if (playerTwo.getPlayerPoints() > 21) {
                playerTwo.resetPlayerPoints();
            }

            // the following if loops are used to determine the winner and add to the win counts accordingly

            if (playerOne.getPlayerPoints() > playerTwo.getPlayerPoints()) {
                playerOne.addWins();
                System.out.println(playerOne.getPlayersName() + " wins!");
            }
            else if (playerTwo.getPlayerPoints() > playerOne.getPlayerPoints()) {
                playerTwo.addWins();
                System.out.println(playerTwo.getPlayersName() + " wins!");
            }
            else if (playerTwo.getPlayerPoints() == playerOne.getPlayerPoints() && playerTwo.getPlayerPoints() > 0) {
                playerOne.addTie();
                playerTwo.addTie();
                System.out.println("The game was a tie.");
            }
            else {
                System.out.println("Both players bust.");
            }

            System.out.println();
            System.out.println(playerOne.getPlayersName() + " has " + playerOne.getWins() + " wins.");
            System.out.println(playerTwo.getPlayersName() + " has " + playerTwo.getWins() + " wins.");
            // the user is given the option to play again. if the input does not contain "Y" or "y", the game will end
            System.out.println("Play again (y/n)?");
            playAgain = input.nextLine();

            // the game is reset, allowing for points and cards to not be carried over to the next round

            gameDeck.reshuffle();
            blackjack.resetTurn();
            playerOne.resetPlayerPoints();
            playerOne.resetPlayerHand();
            playerTwo.resetPlayerPoints();
            playerTwo.resetPlayerHand();

        }
        input.close();
    }
}