package model.design_patterns.iterator;

public class NormalTimeCounter extends TimeCounter {

    int index;

    @Override
    public boolean hasNext() {
        return index < scoreArrays.length;
    }

    @Override
    public Double next() {
        return scoreArrays[index++];
    }
}
