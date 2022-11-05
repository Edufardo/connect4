package models;

import types.Direction;

public class Coordinate {

	public static final int HORIZONTAL_DIMENSION = 7;
	public static final int VERTICAL_DIMENSION = 6;
	public static final int DIMENSION = HORIZONTAL_DIMENSION * VERTICAL_DIMENSION;
	protected int row;
	protected int column;
	public static final String ROW = "Row: ";
	public static final String COLUMN = "Column: ";

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean isNull() {
		return true;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void moveCoordinate(Direction direction, int displacement) {
		this.row += direction.x * displacement;
		this.column += direction.y * displacement;
	}

	public Coordinate referenceCoordinate(Direction direction, int displacement) {
		int referenceRow = this.row + direction.y * displacement;
		int referenceColumn = this.column + direction.x * displacement;

		return new Coordinate(referenceRow, referenceColumn);
	}

	public boolean isValid(Coordinate coordinate) {
		if (coordinate.row <= Coordinate.VERTICAL_DIMENSION && coordinate.column <= Coordinate.HORIZONTAL_DIMENSION) {
			return true;
		}
		return false;
	}

	public Coordinate cloneCoordinate(){
		return new Coordinate(this.row, this.column);
	}
}