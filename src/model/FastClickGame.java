package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.design_patterns.iterator.TimeBoard;
import model.design_patterns.iterator.TimeCounter;
import model.design_patterns.singleton.StopWatch;
import model.design_patterns.state.GameState;
import model.design_patterns.state.TickTokGameState;
import model.sub.Timer;

import java.util.ArrayList;
import java.util.Random;

public class FastClickGame {

    private TickTokGameState tickTokGameState;
    private TimeCounter timeCounter;
    private boolean lightOn;
    private ArrayList<Double> playTimes;
    private double playTime;
    private Random random = new Random();
    private boolean isClickAble;
    private int countDown;
    private StopWatch stopWatch;

    public FastClickGame(){
        playTimes = new ArrayList<>();
        isClickAble = false;
        stopWatch = StopWatch.getInstance();
        tickTokGameState = new GameState();
    }

    public void setTickTokGameState(TickTokGameState tickTokGameState) {
        this.tickTokGameState = tickTokGameState;
    }

    public void run(EventHandler<ActionEvent> eventEventHandler) {
        tickTokGameState.start();
        int toClickTimes = random.nextInt(20);
        Timer timer = new Timer(toClickTimes);
        timer.startTimer(event -> {
            countDown = timer.getTimeLeft();
            if (countDown == 0){
                tickTokGameState.play();
                eventEventHandler.notify();
            }
        });
    }

    public void click(EventHandler<ActionEvent> eventEventHandler) {
        if (isClickAble) {
            tickTokGameState.finish();
            eventEventHandler.notify();
        }
    }

    public void addPlayTime(){
        playTime = stopWatch.getUsedTime();
        playTimes.add(playTime);
    }

    public void startTiming(){
        stopWatch.startTiming();
    }

    public void stopTiming(){
        stopWatch.stopTiming();
    }

    public void clickAble(boolean bool){
        this.isClickAble = bool;
    }
    public void ready(){
        tickTokGameState.ready();
    }

    public void toMain(){
        tickTokGameState.main();
    }

    public void tryagain(){
        tickTokGameState.play();
    }

    public void setTimeCounter(TimeCounter timeCounter) {
        this.timeCounter = timeCounter;
    }

    public TimeCounter getTimeCounter() {
        timeCounter.setScoreArrays((Double[]) playTimes.toArray());
        return timeCounter;
    }


    public void lightOut() {
        lightOn = false;
    }

    public void lightIn(){
        lightOn = true;
    }
}
