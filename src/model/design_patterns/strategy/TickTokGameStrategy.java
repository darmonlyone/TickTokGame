package model.design_patterns.strategy;


import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public interface TickTokGameStrategy{

    Double[] getTime();

    void upScore();

    int getScore();

    void run(EventHandler<ActionEvent> eventEventHandler);

    void click(EventHandler<ActionEvent> eventEventHandler);

    void reset();
}
