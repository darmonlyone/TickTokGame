package model.design_patterns.strategy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ColorClickStrategy implements TickTokGameStrategy {


    @Override
    public Double[] getTime() {
        return new Double[0];
    }

    @Override
    public void upScore() {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void run(EventHandler<ActionEvent> eventEventHandler) {

    }

    @Override
    public void click(EventHandler<ActionEvent> eventEventHandler) {

    }

    @Override
    public void reset() {

    }

}
