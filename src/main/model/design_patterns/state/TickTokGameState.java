package model.design_patterns.state;

import model.design_patterns.singleton.FastClickGame;

public abstract class TickTokGameState {

    protected FastClickGame fastClickGame;

    TickTokGameState(FastClickGame fastClickGame){this.fastClickGame = fastClickGame;}

    public void start(){}

    public void ready(){}

    public void play(){}

    public void finish(){}

    public void main(){}

}
