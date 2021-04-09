package optionalPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosedSequence
{
    int totalTokens;
    private final List<Pair> tokenPairsList = new ArrayList<>();

    public ClosedSequence(int givenTokens)
    {
        this.totalTokens = givenTokens;
    }

    public void createSequence()
    {
        for(int i = 1; i < totalTokens ; ++i) {
            for (int j = i + 1; j <= totalTokens; ++j) {
                tokenPairsList.add(new Pair(i, j));
            }
        }
        Collections.shuffle(tokenPairsList);
    }

    public Pair pullFirst()
    {
        Pair tokenPair = tokenPairsList.get(0);
        tokenPairsList.remove(tokenPair);
        return tokenPair;
    }

    public Pair pullGiven(int givenPosition){
        Pair tokenPair = tokenPairsList.get(givenPosition);
        tokenPairsList.remove(tokenPair);
        return  tokenPair;
    }

    public boolean isEmptySequence()
    {
        return tokenPairsList.isEmpty();
    }

    public void add(Pair tokenPair)
    {
        tokenPairsList.add(tokenPair);
    }

    public List<Pair> getTokenPairsList() {
        return tokenPairsList;
    }
}
