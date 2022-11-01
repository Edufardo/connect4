package models;

import types.Color;
import types.Coordinate;
import types.Error;

public class Turn {
	
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;


    public Turn(Board board){
        assert board != null;
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
        this.reset();
    }
    
    void reset() {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }
    
    void next() {
        if (!this.board.isConnect4(this.getActiveColor()) || this.board.isTie(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }
    
    Player getActivePlayer() {
    	return this.players[this.activePlayer];
    }
    
    Color getActiveColor() {
    	return this.getActivePlayer().getColor();
    }
    
    public void putToken(Coordinate coordinate) {
    	this.getActivePlayer().putToken(coordinate);
    }
    
    public Error getPutTokenError(Coordinate coordinate) {
        return this.getActivePlayer().getPutTokenError(coordinate);
    }
    
}