package models;

import types.Color;
import types.Error;
import types.PlayerType;
import types.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
    	this.board.reset();
    	this.turn.reset();
    }

    public void next() {
    	this.turn.next();
    }
    
    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }
    
    public void setUsers(int numberUsers) {
        this.turn.setUsers(numberUsers);
    }

    public boolean isTicTacToe() {
        return this.board.isConnect4(this.turn.getActiveColor());
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.board.areAllTokensOnBoard();
    }

    public void putToken(Coordinate coordinate) {
        this.turn.putToken(coordinate);
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.turn.getPutTokenError(coordinate);
    }

    public PlayerType getType() {
        return this.turn.getType();
    }

    public Coordinate getRandomCoordinate() {
        return this.turn.getRandomCoordinate();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            if (other.turn != null)
                return false;
        } else if (!turn.equals(other.turn))
            return false;
        return true;
    }

}

