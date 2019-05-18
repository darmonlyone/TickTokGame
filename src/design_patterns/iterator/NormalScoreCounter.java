package design_patterns.iterator;

public class NormalScoreCounter extends ScoreCounter {

    int index;

    @Override
    public boolean hasNext() {
        return index < scoreArrays.length;
    }

    @Override
    public Integer next() {
        return scoreArrays[index++];
    }
}
