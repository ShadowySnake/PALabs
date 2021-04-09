package optionalPackage;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable
{
    private final String playerName;
    private final String playerType;
    private Game currentGame;
    private ClosedSequence closedSequence;
    private  Board gameBoard;
    private int playerScore;
    private int playerNumber;

    public Player(String givenName,String playerType) throws CustomException
    {
        this.playerScore = 0;
        this.playerName = givenName;
        if (playerType.equals("Auto") || playerType.equals("Manual")) this.playerType = playerType;
        else throw new CustomException("Not a valid Type!");
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerNumber(int givenNumber){
        this.playerNumber = givenNumber;
    }

    private boolean play() throws InterruptedException
    {

        synchronized (gameBoard) {
            if ( (playerNumber != gameBoard.getThreadNumber())) gameBoard.wait();
            else {
                if (closedSequence == null) closedSequence = new ClosedSequence(gameBoard.closedSequence.totalTokens);

                if (gameBoard.emptySequence() || currentGame.isEnded()) {
                    if(playerNumber == (currentGame.playerNumbers - 1) ) gameBoard.setThreadNumber(0);
                    else gameBoard.setThreadNumber(playerNumber + 1);
                    gameBoard.notifyAll();
                    return false;
                }


                Pair chosenPair;

                if (this.playerType.equals("Auto")) {
                    chosenPair = gameBoard.extractFirst();
                    closedSequence.add(chosenPair);
                    this.playerScore = playerScore + chosenPair.strictlyPositiveNum;
                } else {
                    List<Pair> boardSequence = gameBoard.getClosedSequence().getTokenPairsList();
                    boardSequence.forEach(x -> System.out.println("Available pairs: " +
                            x.randomTokenNum + "," + x.strictlyPositiveNum + "\n"));
                    System.out.println("Type a number from 0 to " + boardSequence.size());
                    Scanner myObj = new Scanner(System.in);
                    int inputInt = myObj.nextInt();

                    chosenPair = gameBoard.extractGiven(inputInt);
                    closedSequence.add(chosenPair);
                }

                this.playerScore = playerScore + chosenPair.strictlyPositiveNum;

                if (closedSequence.isEmptySequence()) {
                    currentGame.setEnd();
                }

                if(playerNumber == (currentGame.playerNumbers - 1) ) gameBoard.setThreadNumber(0);
                else gameBoard.setThreadNumber(playerNumber + 1);
                gameBoard.notify();
            }
        }
        Thread.sleep(1000);
        return true;
    }

    public void run()
    {
        try {
            while(this.play())
            {
                System.out.print("The turn of: ");
                System.out.println(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentGame(Game game)
    {
        this.currentGame = game;
        this.gameBoard = currentGame.getGameBoard();
    }

    public String toString()
    {
        return this.playerName;
    }
}
