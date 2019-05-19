package model.design_patterns.state;

public class ReadyState extends TickTokGameState {

    @Override
    public void start() {
        fastClickGame.clickAble(false);
        fastClickGame.lightOut();
        fastClickGame.setTickTokGameState(new PlayState());
    }
}
