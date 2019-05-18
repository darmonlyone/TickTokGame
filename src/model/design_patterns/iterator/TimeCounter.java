package model.design_patterns.iterator;

import java.util.Iterator;

abstract class TimeCounter implements  Iterator<Double>{

    double[] scoreArrays;

    public void setScoreArrays(double[] scoreArrays) {
        this.scoreArrays = scoreArrays;
    }
}
