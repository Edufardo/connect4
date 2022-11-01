package connect4;

import connect4.models.Game;
import connect4.views.console.ConsoleView;

class ConsoleConnect4 {

	private Game game;
	private ConsoleView consoleView;

	ConsoleConnect4() {
			this.game = new Game();
			this.consoleView = new ConsoleView(this.game);
		}

	protected void play() {
		do {
			this.consoleView.start();
			this.consoleView.play();
		} while (this.consoleView.resume());
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}
}