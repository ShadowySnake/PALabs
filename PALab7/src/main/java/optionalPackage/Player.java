package optionalPackage;

public class Player implements Runnable
{
    private final String playerName;
    private Game currentGame;
    private ClosedSequence closedSequence;
    private int playerScore;

    public Player(String givenName)
    {
        this.playerScore = 0;
        this.playerName = givenName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private boolean play() throws InterruptedException
    {
        Board board = currentGame.getGameBoard();
        if (closedSequence == null) closedSequence = new ClosedSequence(board.closedSequence.totalTokens);
        if (board.emptySequence() || currentGame.isEnded()) {
            return false;
        }

        Pair chosenPair = board.extract();
        closedSequence.add(chosenPair);
        this.playerScore = playerScore + chosenPair.strictlyPositiveNum;

        int THINKING_TIME = 500;
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
