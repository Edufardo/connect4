package connect4.views.console;

import connect4.types.Coordinate;
import connect4.types.Error;
import utils.Console;

public class CoordinateView {

	public Coordinate read(Message message) {
		assert message != null;

		boolean error;
        Coordinate coordinate;
        do {
            coordinate = this.readCoordinate(message);
            error = !coordinate.isValid(coordinate);
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
        return coordinate;
    }

	public Coordinate readCoordinate(Message message) {
        Console console = Console.getInstance();
        int column = console.readInt(Coordinate.COLUMN);
		int row = console.readInt(Coordinate.ROW);
        return new Coordinate(row, column);
    }

    public String getErrorMessage() {
        return ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()];
    }
}