package compulsoryPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game
{
    private Board gameBoard;
    private final List<Player> playersList = new ArrayList<>();
    private boolean hasEnded = false;
    private static final ExecutorService executors = Executors.newFixedThreadPool(8);

    public void addPlayer(Player player)
    {
        playersList.add(player);
        player.setCurrentGame(this);
    }
    public void setGameBoard(Board board)
    {
        gameBoard = board;
    }
    public Board getGameBoard()
    {
        return gameBoard;
    }

    public void printPlayersList(){
        System.out.print("The players in the game will be: ");
        this.playersList.forEach(x -> System.out.print(x.toString() + " "));
        System.out.println("\n");
    }

    public synchronized void setEnd() {
        this.hasEnded = true;
    }

    public void start() throws InterruptedException  {
        for(Player p : playersList) {
            executors.execute(p);
        }
        executors.shutdown();
        while (!executors.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("\nThe game has ended!");
    }

    public boolean isEnded()
    {
        return this.hasEnded;
    }

}
