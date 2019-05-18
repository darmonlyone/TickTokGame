package model.design_patterns.state;


public interface TickTokGameState {

    void ready();
    void giveup();
    void tryagain();
    void start();
    void meinmenu();
}
