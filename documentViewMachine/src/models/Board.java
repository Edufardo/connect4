package models;

import types.Color;
import types.Coordinate;

public class Board {
    
	private Color[][] colors;
	
	Board(){
		this.reset();
	}
	
	void reset() {
		for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
			for (int j = 0; j < Coordinate.VERTICAL_DIMENSION; j++) {
                this.colors[i][j] = Color.NULL;
            }
		}
	}
    
	public boolean isConnect4(Color color) {
		// TODO: Do isConnect4
		return false;
	}
	
	public boolean isTie(Color color) {
		//TODO: Do tie
		return false;
	}
	
	public Color getColor(Coordinate coordinate) {
		assert !coordinate.isNull();
		
		Color color = this.colors[coordinate.getRow()][coordinate.getColumn()];
		return color;
	}
	
    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }
    
    public boolean areAllTokensOnBoard() {
		for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
			for (int j = 0; j < Coordinate.VERTICAL_DIMENSION; j++) {
                if(this.colors[i][j] == Color.NULL) {
                	return false;
                }
            }
		}
		return true;
    }
    
    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }
    
}
