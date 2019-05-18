package model.design_patterns.state;


interface GameState {

    void ready();
    void giveup();
    void tryagain();
    void start();
    void meinmenu();
}
