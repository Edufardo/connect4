package connect4.types;

public class Coordinate {
	
	public static final int HORIZONTAL_DIMENSION = 7;
	public static final int VERTICAL_DIMENSION = 6;
	public static final int DIMENSION = HORIZONTAL_DIMENSION * VERTICAL_DIMENSION;
	private int row;
	private int column;
	public static final String ROW = "Row: ";
	public static final String COLUMN = "Column: ";

	
	public Coordinate(int row, int column){
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

	public boolean isValid(Coordinate coordinate) {
		if (coordinate.row <= Coordinate.VERTICAL_DIMENSION && coordinate.column <= Coordinate.HORIZONTAL_DIMENSION) {
			return true;
		}
		return false;
	}
}