package model.design_patterns.iterator;

public class ReverseTimeCounter extends TimeCounter {

    private  int index;

    @Override
    public boolean hasNext() {
        return index < scoreArrays.length;
    }

    @Override
    public Double next() {
        return scoreArrays[scoreArrays.length - (index++) - 1];
    }

}
