package connect4.models;

import connect4.types.Color;
import connect4.types.Coordinate;
import connect4.types.Error;

public class Player {
	
	private Color color;
	private Board board;
	private int putTokens;
	
	Player(Color color, Board board) {
		assert !color.isNull();
		assert board != null;
		
        this.color = color;
        this.board = board;
        this.putTokens = 0;
	}
	
	Color getColor() {
		return this.color;
	}
    
    public void putToken(Coordinate coordinate) {
        assert this.putTokens < Coordinate.DIMENSION;
        
        this.board.putToken(coordinate, this.color);
        this.putTokens++;
    }
    
    public Error getPutTokenError(Coordinate coordinate) {
    	if (!this.board.isEmpty(coordinate)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    boolean areAllTokensOnBoard(){
        return this.putTokens == Coordinate.DIMENSION;
    }
    
    // TODO: Errors when put on full line...
}