package model.design_patterns.iterator;

import java.util.Iterator;

abstract class ScoreCounter implements  Iterator<Integer>{

    int[] scoreArrays;

    public void setScoreArrays(int[] scoreArrays) {
        this.scoreArrays = scoreArrays;
    }
}
