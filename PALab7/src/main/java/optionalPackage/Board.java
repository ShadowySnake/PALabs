package optionalPackage;

public class Board
{
    int tokens;
    public ClosedSequence closedSequence;

    public Board(int tokensNumber)
    {
        this.tokens = tokensNumber;
        this.closedSequence = new ClosedSequence(tokensNumber);
        closedSequence.createSequence();
    }

    public synchronized Pair extractFirst()
    {
        return closedSequence.pullFirst();
    }

    public synchronized Pair extractGiven(int givenPosition){
        return closedSequence.pullGiven(givenPosition);
    }

    public ClosedSequence getClosedSequence() {
        return closedSequence;
    }

    public boolean emptySequence()
    {
        return closedSequence.isEmptySequence();
    }
}
