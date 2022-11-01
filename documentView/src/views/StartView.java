package views;

import models.Game;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }

}