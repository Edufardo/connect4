package views;

import models.Game;
import types.Coordinate;
import types.Error;

class PlayerView {

    protected Game game;

    PlayerView() {
    }

    void interact(Game game) {
    	this.game = game;
        if (!this.game.areAllTokensOnBoard()) {
            this.putToken();
        } 
    }

    private void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.game.putToken(coordinate);
    }

    Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    protected Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = this.game.getPutTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
    }
    

}