package model.design_patterns.state;

import model.design_patterns.singleton.FastClickGame;

public class PlayState extends TickTokGameState {

    PlayState(FastClickGame fastClickGame) {
        super(fastClickGame);
    }

    @Override
    public void play() {
        fastClickGame.clickAble(true);
        fastClickGame.lightIn();
        fastClickGame.startTiming();
    }

    @Override
    public void finish() {
        fastClickGame.lightOut();
        fastClickGame.clickAble(false);
        fastClickGame.stopTiming();
        fastClickGame.setPlayTime();
        fastClickGame.setTickTokGameState(new ResultState(fastClickGame));
    }
}
