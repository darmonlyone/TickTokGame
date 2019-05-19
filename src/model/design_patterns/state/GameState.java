package model.design_patterns.state;

import model.FastClickGame;

public class GameState extends TickTokGameState {

    public GameState(FastClickGame fastClickGame) {
        super(fastClickGame);
    }

    @Override
    public void ready() {
        fastClickGame.setTickTokGameState(new ReadyState(fastClickGame));
    }
}
