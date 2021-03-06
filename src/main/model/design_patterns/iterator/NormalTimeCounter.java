package model.design_patterns.iterator;

public class NormalTimeCounter extends TimeCounter {

    private int index;

    @Override
    public boolean hasNext() {
        return index < timeArrays.length;
    }

    @Override
    public Double next() {
        return timeArrays[index++];
    }
}
