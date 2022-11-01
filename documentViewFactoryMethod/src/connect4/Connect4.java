package connect4;

import connect4.models.Game;
import connect4.views.View;

public abstract class Connect4 {    

    private Game game;
    private View view;

    Connect4() {
        this.game = new Game();
        this.view = this.createView(this.game);
    }

    protected abstract View createView(Game game);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

}