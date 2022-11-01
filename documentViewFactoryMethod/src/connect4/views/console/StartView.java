package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }

}