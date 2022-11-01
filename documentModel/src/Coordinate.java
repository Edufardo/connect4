
import utils.Console;

class Coordinate {
	
	static final String ROW = "Row: ";
	static final String COLUMN = "Column: ";
	protected int row;
	protected int column;
	public static final int HORIZONTAL_DIMENSION = 7;
	public static final int VERTICAL_DIMENSION = 6;
	public static final int VERTICAL_LIMIT = 7;

	protected Coordinate() {
	}

	protected Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	protected void read(String title) {
		Console console = Console.getInstance();
		console.writeln(title);
		this.row = console.readInt(Coordinate.ROW) - 1;
		this.column = console.readInt(Coordinate.COLUMN) - 1;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public boolean isNull() {
		return false;
	}

	public void moveCoordinate(Direction direction, int displacement) {
		this.row += direction.x * displacement;
		this.column += direction.y * displacement;
	}

	public Coordinate referenceCoordinate(Direction direction, int displacement){
        int referenceRow = this.row + direction.y * displacement;
        int referenceColumn = this.column + direction.x * displacement;
		
        return new Coordinate(referenceRow, referenceColumn);
    }
}
