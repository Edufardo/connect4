package views;

import models.Game;

abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }
    
}