import models.Game;
import views.View;

class Connect4 {

    private Game game;
    private View view;

    Connect4() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

}