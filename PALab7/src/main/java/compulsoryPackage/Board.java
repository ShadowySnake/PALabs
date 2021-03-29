package compulsoryPackage;

public class Board {
    public ClosedSequence sequenceStarter;
    int tokens;

    public Board(int tokensNumber) {
        this.tokens = tokensNumber;
        sequenceStarter = new ClosedSequence(tokensNumber);
    }

    public synchronized Pair extract() {
        return sequenceStarter.pullFirst();
    }

    public boolean emptySequence() {
        return sequenceStarter.isEmptySequence();
    }

}
