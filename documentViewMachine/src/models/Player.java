package models;

import types.Color;
import types.Coordinate;
import types.Error;
import types.PlayerType;

public class Player {
	
	private Color color;
	private Board board;
	protected PlayerType type;
	private int putTokens;
	
	Player(Color color, Board board) {
		this.color = color;
		this.board = board;
		
        this.color = color;
        this.board = board;
        this.putTokens = 0;
	}
	
	Color getColor() {
		return this.color;
	}
    
    public void putToken(Coordinate coordinate) {
        assert this.putTokens < Coordinate.HORIZONTAL_DIMENSION * Coordinate.VERTICAL_DIMENSION;
        
        this.board.putToken(coordinate, this.color);
        this.putTokens++;
    }
    
    public Error getPutTokenError(Coordinate coordinate) {
    	if (!this.board.isEmpty(coordinate)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }
    
    public PlayerType getType() {
    	return this.type;
    }
    
}