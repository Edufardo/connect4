package views;

import models.Game;
import models.Turn;
import utils.views.BoundedIntDialog;

class StartView extends WithGameView {

    StartView(Game game) {
		super(game);
	}

    void interact() {
		Message.TITLE.writeln();
		BoundedIntDialog dialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
		this.game.setUsers(dialog.read(Message.NUMBER_PLAYERS.toString()));
		new BoardView().write(this.game);
	}

}