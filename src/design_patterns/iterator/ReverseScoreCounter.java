package design_patterns.iterator;

public class ReverseScoreCounter extends ScoreCounter{

    private  int index;

    @Override
    public boolean hasNext() {
        return index < scoreArrays.length;
    }

    @Override
    public Integer next() {
        return scoreArrays[scoreArrays.length - (index++) - 1];
    }

}
