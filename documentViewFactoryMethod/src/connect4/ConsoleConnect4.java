package connect4;

import connect4.models.Game;
import connect4.views.console.ConsoleView;

class ConsoleConnect4 extends Connect4 {

	@Override
	protected ConsoleView createView(Game game) {
		return new ConsoleView(game);
	}
	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}

}