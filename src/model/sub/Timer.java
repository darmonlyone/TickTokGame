package model.sub;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Timer {

    private int timeLeft;
    private int startTime;
    private Timeline timeline;

    public Timer(int startTime){
        this.startTime = startTime;
    }
    public void startTimer(EventHandler<ActionEvent> eventHandler) {
        timeLeft = startTime;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),event -> countDown()),
                new KeyFrame(Duration.seconds(1),eventHandler));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public int countDown(){
        if (timeLeft == 0)
            stopTimer();
        return timeLeft--;
    }
    public void stopTimer(){
        timeline.stop();
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}