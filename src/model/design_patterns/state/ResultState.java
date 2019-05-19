package model.design_patterns.state;

public class ResultState extends TickTokGameState {
    @Override
    public void main() {
        fastClickGame.setTickTokGameState(new GameState());
    }

    @Override
    public void play() {
        fastClickGame.setTickTokGameState(new ReadyState());
    }
}
