package connect4;

import connect4.models.Game;
import connect4.views.graphics.GraphicsView;

public class GraphicsConnect4{
	
    private Game game;
    private GraphicsView graphicsView;

    GraphicsConnect4() {
        this.game = new Game();
        this.graphicsView = new GraphicsView(this.game);
    }

    protected void play() {
        do {
            this.graphicsView.start();
            this.graphicsView.play();
        } while (this.graphicsView.resume());
    }

	public static void main(String[] args) {
		new GraphicsConnect4().play();
	}
}