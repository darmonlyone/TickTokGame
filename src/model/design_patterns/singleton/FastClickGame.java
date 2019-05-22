package model.design_patterns.singleton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private static FastClickGame fastClickGame;

    private FastClickGame(){
        playTimes = new ArrayList<>();
        isClickAble = false;
        stopWatch = StopWatch.getInstance();
        tickTokGameState = new GameState(this);
    }

    public static FastClickGame getInstance(){
        if (fastClickGame == null) {
            fastClickGame = new FastClickGame();
        }
        return fastClickGame;
    }

    public boolean isClickAble() {
        return isClickAble;
    }

    public double getPlayTime() {
        return playTime;
    }

    public void setTickTokGameState(TickTokGameState tickTokGameState) {
        this.tickTokGameState = tickTokGameState;
    }

    public void ready(){
        tickTokGameState.ready();
    }

    public void run(EventHandler<ActionEvent> eventEventHandler) {
        tickTokGameState.start();
        int toClickTimes = random.nextInt(5)+3;
        Timer timer = new Timer(toClickTimes);
        timer.startTimer(event -> {
            countDown = timer.getTimeLeft();

            if (countDown == 0){
                tickTokGameState.play();
                eventEventHandler.handle(new ActionEvent());
            }
        });
    }

    public void click(EventHandler<ActionEvent> eventEventHandler) {
        if (isClickAble) {
            tickTokGameState.finish();
            eventEventHandler.handle(new ActionEvent());
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

    public void setTimeCounter(TimeCounter timeCounter) {
        this.timeCounter = timeCounter;
    }

    public TimeCounter getTimeCounter() {
        Double[] target = new Double[playTimes.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = playTimes.get(i);
        }
        timeCounter.setTimeArrays(target);
        return timeCounter;
    }

    public void main(){
        tickTokGameState.main();
    }

    public void tryAgain(){
        tickTokGameState.play();
    }

    public void lightOut() {
        lightOn = false;
    }

    public void lightIn(){
        lightOn = true;
    }
}
