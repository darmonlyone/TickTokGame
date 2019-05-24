package model.design_patterns.iterator;

import java.util.Iterator;

public class TimeBoard implements Iterable<Double> {

    private TimeCounter timeCounter;

    @Override
    public Iterator<Double> iterator() {
        return timeCounter;
    }

    public void setTimeCounter(TimeCounter timeCounter) {
        this.timeCounter = timeCounter;
    }

}
