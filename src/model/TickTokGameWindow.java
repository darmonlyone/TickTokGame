package model;

import model.design_patterns.state.TickTokGameState;

public class TickTokGameWindow {

    private int score;
    private TickTokGameState gameState;

    public void setGameState(TickTokGameState gameState) {
        this.gameState = gameState;
    }


}
