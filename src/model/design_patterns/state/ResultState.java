package model.design_patterns.state;

import model.design_patterns.singleton.FastClickGame;

public class ResultState extends TickTokGameState {
    ResultState(FastClickGame fastClickGame) {
        super(fastClickGame);
    }

    @Override
    public void main() {
        fastClickGame.setTickTokGameState(new GameState(fastClickGame));
    }

    @Override
    public void play() {
        fastClickGame.setTickTokGameState(new ReadyState(fastClickGame));
    }
}
