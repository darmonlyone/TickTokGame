package model.design_patterns.iterator;

import java.util.Iterator;

public abstract class TimeCounter implements  Iterator<Double>{

    Double[] scoreArrays;

    public void setScoreArrays(Double[] scoreArrays) {
        this.scoreArrays = scoreArrays;
    }
}
