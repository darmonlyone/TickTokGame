package model.design_patterns.iterator;

import java.util.Iterator;

public abstract class TimeCounter implements  Iterator<Double>{

    Double[] timeArrays;

    public void setTimeArrays(Double[] timeArrays) {
        this.timeArrays = timeArrays;
    }
}
