package model.design_patterns.state;

public class GameState extends TickTokGameState {

    @Override
    public void ready() {
        fastClickGame.setTickTokGameState(new ReadyState());
    }
}
