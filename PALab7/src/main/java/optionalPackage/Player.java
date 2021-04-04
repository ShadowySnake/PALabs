package optionalPackage;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable
{
    private final String playerName;
    private final String playerType;
    private Game currentGame;
    private ClosedSequence closedSequence;
    private int playerScore;

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

    public String getPlayerType() {
        return playerType;
    }

    private boolean play() throws InterruptedException
    {
        Board board = currentGame.getGameBoard();
        if (closedSequence == null) closedSequence = new ClosedSequence(board.closedSequence.totalTokens);
        if (board.emptySequence() || currentGame.isEnded()) {
            return false;
        }

        int THINKING_TIME;
        if (currentGame.aHumanPlays) THINKING_TIME = 10000;
        else THINKING_TIME = 500;

        Pair chosenPair;

        if( this.playerType.equals("Auto") ) {
            chosenPair = board.extractFirst();
            closedSequence.add(chosenPair);
            this.playerScore = playerScore + chosenPair.strictlyPositiveNum;
        }
        else {
            List<Pair> boardSequence = board.getClosedSequence().getTokenPairsList();
            boardSequence.forEach(x -> System.out.println("Available pairs: " + x.randomTokenNum + "," + x.strictlyPositiveNum + "\n"));
            System.out.println("Type a number from 0 to the number of displayed (pairs-1)");
            Scanner myObj = new Scanner(System.in);
            int inputInt = myObj.nextInt();

            chosenPair = board.extractGiven(inputInt);
            closedSequence.add(chosenPair);
            if (currentGame.aBotPlays) THINKING_TIME = 5000;
            // this is used in case a human plays against a bot in order to give the human enough time to react, instead of wasting a turn
        }

        this.playerScore = playerScore + chosenPair.strictlyPositiveNum;

        Thread.sleep(THINKING_TIME);
        if (closedSequence.isEmptySequence()) {
            currentGame.setEnd();
        }

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
        currentGame = game;
    }

    public String toString()
    {
        return this.playerName;
    }
}
