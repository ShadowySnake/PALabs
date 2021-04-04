package compulsoryPackage;

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

    public synchronized Pair extract()
    {
        return closedSequence.pullFirst();
    }

    public boolean emptySequence()
    {
        return closedSequence.isEmptySequence();
    }
}
