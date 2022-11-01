import java.util.*;

public class Board {

	private Map<Coordinate, Color> boardCoordinates;
	private Coordinate lastToken;

	public Board() {
		this.boardCoordinates = new HashMap<Coordinate, Color>();
		this.reset();
	}

	void reset() {
		this.boardCoordinates = new HashMap<>();
		this.lastToken = null;
	}

	public void write() {
		for (int i = 0; i < Coordinate.VERTICAL_DIMENSION; i++) {
			Message.VERTICAL_LINE.writeln();
			for (int j = 0; j < Coordinate.HORIZONTAL_DIMENSION; j++) {
				Message.HORIZONTAL_LINE.writeln();
			}
		}
	}

	public boolean isConnect4(Player player) {
		for (Direction direction : Direction.values()) {
			for (int displacement = -3; displacement <= 0; displacement++) {
				if (isFourConnected(player.getColor(), direction, displacement)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isFourConnected(Color color, Direction direction, int displacement) {
		int i = 0;
		while (i < 4 && isCoordinateSameColor(color, direction, displacement + i))
			i++;
		return i == 4;
	}

	public boolean isCoordinateSameColor(Color color, Direction direction, int displacement) {
		Coordinate referenceCoordinate = this.lastToken.referenceCoordinate(direction, displacement);

		return this.boardCoordinates.containsKey(referenceCoordinate)
				&& this.boardCoordinates.get(referenceCoordinate).equals(color);
	}

	public boolean isTie(Player player) {
		if (!this.isConnect4(player) && this.isBoardFull()) {
			return true;
		}
		return false;
	}

	public boolean isGameOver(Player player) {
		if (this.isTie(player) || this.isConnect4(player)) {
			return true;
		}
		return false;
	}

	void putToken(int column, Color color) {
		assert !color.isNull();
		int row = 0;
		Coordinate coordinate = new Coordinate(row, column);
		while (row < Coordinate.VERTICAL_DIMENSION && this.boardCoordinates.containsKey(coordinate)) {
			coordinate.moveCoordinate(Direction.VERTICAL_UP, 1);
			row++;
		}

		if (!this.boardCoordinates.containsKey(coordinate)) {
			this.lastToken = coordinate;
			this.boardCoordinates.put(this.lastToken, color);
		}
	}

	public boolean isFullColumn(int column) {
		return this.boardCoordinates.containsKey(new Coordinate(Coordinate.VERTICAL_DIMENSION, column));
	}

	boolean isBoardFull() {
		for (var coordinate : this.boardCoordinates.entrySet()) {
			if (coordinate.getValue().isNull()) {
				return false;
			}
		}
		return true;
	}

	boolean isOccupied(Color color, Coordinate coordinate) {
		if (!this.boardCoordinates.containsKey(coordinate)) {
			return true;
		}
		return false;
	}

}
