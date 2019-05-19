package model.design_patterns.state;

import model.FastClickGame;

public class ReadyState extends TickTokGameState {

    ReadyState(FastClickGame fastClickGame) {
        super(fastClickGame);
    }

    @Override
    public void start() {
        fastClickGame.clickAble(false);
        fastClickGame.lightOut();
        fastClickGame.setTickTokGameState(new PlayState(fastClickGame));
    }
}
