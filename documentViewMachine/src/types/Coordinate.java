package types;

import java.util.Random;


public class Coordinate {
	
	public static final int HORIZONTAL_DIMENSION = 7;
	public static final int VERTICAL_DIMENSION = 6;
	private int row;
	private int column;
	
	public Coordinate(){
		
	}
	
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
	
    public Coordinate random() {
        Random random = new Random(System.currentTimeMillis());
        return new Coordinate(random.nextInt(this.getRow()), random.nextInt(this.getColumn()));
    }
}