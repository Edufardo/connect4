package models;

import main.utils.Observed;

public class Connect4 extends Observed {

    private Game game;

    private Registry registry;

    public Connect4(Game game) {
            this.game = game;
            this.registry = new Registry(this.game);
        }

    public void createPlayers(int numberOfPlayers) {
        this.game.createPlayers(numberOfPlayers);
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public boolean isConnect4() {
        return this.game.isConnect4();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public void registry() {
        this.registry.registry();
    }

    public void newGame() {
        this.game.newGame();
        this.registry.reset();
    }
}
