package model.design_patterns.iterator;

public class ReverseTimeCounter extends TimeCounter {

    private  int index;

    @Override
    public boolean hasNext() {
        return index < timeArrays.length;
    }

    @Override
    public Double next() {
        return timeArrays[timeArrays.length - (index++) - 1];
    }

}
