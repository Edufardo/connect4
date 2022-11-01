package models;

import types.Color;
import types.Coordinate;
import types.Error;
import types.PlayerType;

public class Turn {
	
    private Board board;
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;


    public Turn(Board board){
        assert board != null;
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
    }
    
    void reset() {
        this.activePlayer = 0;
    }
    
    void setUsers(int numberUsers) {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            if (i < numberUsers) {
                this.players[i] = new UserPlayer(Color.get(i), this.board);
            } else {
                this.players[i] = new MachinePlayer(Color.get(i), this.board);
            }
        }
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
    
    public PlayerType getType() {
    	return this.getActivePlayer().getType();
    }
    
    public Coordinate getRandomCoordinate() {
        return ((MachinePlayer) this.getActivePlayer()).getRandomCoordinate();
    }
}