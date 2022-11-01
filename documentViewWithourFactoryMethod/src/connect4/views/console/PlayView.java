package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isConnect4() || !this.game.isTie());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }

}