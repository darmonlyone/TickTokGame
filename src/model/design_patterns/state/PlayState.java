package model.design_patterns.state;

public class PlayState extends TickTokGameState {

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
        fastClickGame.addPlayTime();
        fastClickGame.setTickTokGameState(new ResultState());
    }
}
