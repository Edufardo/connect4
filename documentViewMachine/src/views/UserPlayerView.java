package views;

import types.Coordinate;
import types.Error;

class UserPlayerView extends PlayerView {

    @Override
    protected Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    @Override
    protected Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = super.getPutTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
    }
}