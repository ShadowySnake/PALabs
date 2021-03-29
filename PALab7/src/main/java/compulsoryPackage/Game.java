package compulsoryPackage;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> playersList = new ArrayList<>();
    private Board gameBoard;

    public void addPlayer(Player player) {
        this.playersList.add(player);
        player.setCurrentGame(this);
    }

    public Board getGameBoard() {
        return this.gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void printPlayersList() {
        System.out.print("The players in game will be: ");
        playersList.forEach(x -> System.out.print(x.getPlayerName() + " "));
        System.out.print("\n");
    }

    public void startGame() {
        // WORK IN PROGRESS
        // Must make an algorithm that decides the end of the game/ winner
    }
}
