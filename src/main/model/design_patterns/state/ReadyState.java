package model.design_patterns.state;

import model.design_patterns.singleton.FastClickGame;

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
