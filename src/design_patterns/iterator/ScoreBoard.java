package design_patterns.iterator;

import java.util.Iterator;

public class ScoreBoard implements Iterable<Integer> {

    private ScoreCounter scoreCounter;

    @Override
    public Iterator<Integer> iterator() {
        return scoreCounter;
    }

    public void setScoreCounter(ScoreCounter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    public void setScoreCounter(ScoreCounter scoreCounter, int[] scoreArrays) {
        this.scoreCounter = scoreCounter;
        this.scoreCounter.setScoreArrays(scoreArrays);
    }

}
