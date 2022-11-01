package connect4.views;

import connect4.models.Game;

public abstract class WithGameView {

    protected Game game;

    protected WithGameView(Game game) {
        this.game = game;
    }
    
}