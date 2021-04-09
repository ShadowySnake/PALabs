package optionalPackage;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Board gameBoard;
    private final List<Player> playersList = new ArrayList<>();
    private final List<Thread> playerThreads = new ArrayList<>();
    private boolean hasEnded = false;
    public int playerNumbers;

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

    public synchronized void start() throws InterruptedException  {
        int currentIndex = 0;
        Thread timekeeper = new TimeKeeper(50,this.gameBoard);
        timekeeper.setDaemon(true);

        this.playerNumbers = playersList.size();
        for(Player p : playersList) {
            p.setPlayerNumber(currentIndex);
            this.playerThreads.add(new Thread(p));
            currentIndex++;
        }

        for (Thread thread : playerThreads){
            thread.start();
        }
        timekeeper.start();

        for (Thread thread : playerThreads){
            try {
                thread.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        timekeeper.join();

        System.out.println("\nThe game has ended!");

        Thread.sleep(1000);
        this.declareWinner();
    }

    public void declareWinner(){
        int bestScore = -1;
        String winnerPlayer = null;
        StringBuilder winnerDeclarer = new StringBuilder("\nAt the end we have the following scores: \n");

        for (Player player : playersList){
            winnerDeclarer.append(player.toString()).append(" has the score ").append(player.getPlayerScore());

            if (bestScore == -1){
                bestScore = player.getPlayerScore();
                winnerPlayer = player.toString();
            } else if(bestScore < player.getPlayerScore()){
                bestScore = player.getPlayerScore();
                winnerPlayer = player.toString();
            }

            winnerDeclarer.append("\n");
        }

        winnerDeclarer.append("The winner is ").append(winnerPlayer).append(" with the score ").append(bestScore);
        System.out.println(winnerDeclarer);
    }

    public boolean isEnded()
    {
        return this.hasEnded;
    }

}
