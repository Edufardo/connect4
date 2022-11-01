package models;

import java.util.HashMap;
import java.util.Map;

import types.Color;
import types.Coordinate;
import types.Direction;

public class Board {
    
	private Map<Coordinate, Color> boardCoordinates;
	private Coordinate lastToken;
	
	Board(){
		this.reset();
	}
	
	void reset() {
		this.boardCoordinates = new HashMap<Coordinate, Color>();
		this.lastToken = null;
	}
	
	public boolean isConnect4(Color color) {
		for (Direction direction : Direction.values()) {
			for (int displacement = -3; displacement <= 0; displacement++) {
				if (isFourConnected(color, direction, displacement)) {
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

	public boolean isTie(Color color) {
		if (!this.isConnect4(color) && this.isBoardFull()) {
			return true;
		}
		return false;
	}
	
	public Color getColor(Coordinate coordinate) {
		assert !coordinate.isNull();
		
		return this.boardCoordinates.get(coordinate);
	}
	
    void putToken(Coordinate coordinate, Color color) {
		assert !color.isNull();
		int row = 0;
		while (row < Coordinate.VERTICAL_DIMENSION && this.boardCoordinates.containsKey(coordinate)) {
			coordinate.moveCoordinate(Direction.VERTICAL_UP, 1);
			row++;
		}

		if (!this.boardCoordinates.containsKey(coordinate)) {
			this.lastToken = coordinate;
			this.boardCoordinates.put(this.lastToken, color);
		}
    }
    
    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
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
    
}
