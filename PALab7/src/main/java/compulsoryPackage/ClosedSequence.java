package compulsoryPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosedSequence {
    private final List<Pair> tokenPairs = new ArrayList<>();
    int totalTokens;

    public ClosedSequence(int givenTokens) {
        this.totalTokens = givenTokens;
        this.createSequence();
    }

    public void createSequence() {
        for (int tokenNum = 1; tokenNum < totalTokens; ++tokenNum) {
            for (int valueNum = tokenNum + 1; valueNum < totalTokens; ++valueNum) {
                tokenPairs.add(new Pair(tokenNum, valueNum));
            }
        }
        Collections.shuffle(tokenPairs);
    }

    public Pair pullFirst() {
        Pair firstInSequence = tokenPairs.get(0);
        tokenPairs.remove(firstInSequence);
        return firstInSequence;
    }

    public boolean isEmptySequence() {
        return tokenPairs.isEmpty();
    }
}
