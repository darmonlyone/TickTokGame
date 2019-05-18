package model.design_patterns.strategy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.sub.StopWatch;
import model.sub.Timer;

import java.util.ArrayList;
import java.util.Random;

public class FastClickStrategy implements TickTokGameStrategy {

    private int score;
    private ArrayList<Double> playTimes;
    private double playTime;
    private Random random = new Random();
    private boolean isClickAble;
    private int countDown;
    private StopWatch stopWatch;


    public FastClickStrategy(int score){
        this.score = score;
        playTimes = new ArrayList<>();
        isClickAble = false;
        stopWatch = new StopWatch();
    }

    @Override
    public void run(EventHandler<ActionEvent> eventEventHandler) {
        int toClickTimes = random.nextInt(20)+5;
        Timer timer = new Timer(toClickTimes);
        timer.startTimer(event -> {
            countDown = timer.getTimeLeft();
            if (countDown == 0){
                isClickAble = true;
                stopWatch.startTiming();
                eventEventHandler.notify();
            }
        });
    }

    @Override
    public void click(EventHandler<ActionEvent> eventEventHandler) {
        if (isClickAble) {
            stopWatch.stopTiming();
            playTime = stopWatch.getUsedTime();
            playTimes.add(playTime);
            isClickAble = false;
            eventEventHandler.notify();
        }
    }

    @Override
    public Double[] getTime() {
        return (Double[]) playTimes.toArray();
    }

    @Override
    public void upScore() {
        score++;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset() {
        isClickAble = false;
    }
}
