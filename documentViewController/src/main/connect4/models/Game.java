package models;

import types.Color;
import types.Error;
import types.PlayerType;



public class Game {
    
    private Board board;

	private Player[] players;

    private Turn turn;
    
    public Game() {
        this.newGame();
    }

    public void createPlayers(int numberOfUsers) {
		for (int i = 0; i < numberOfUsers; i++) {
			this.players[i] = new Player(Color.values()[i], this.board, PlayerType.USER_PLAYER);
		}
		for (int i = numberOfUsers; i < Turn.NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(Color.values()[i], this.board, PlayerType.MACHINE_PLAYER);
		}
    }

    Memento createMemento() {
        Board board = this.board.cloneBoard();
        return new Memento(board, this.createCopyOfPlayers(this.players, board), this.turn);
    }

    void set(Memento memento) {
        this.board = memento.getBoard().cloneBoard();
        this.players = this.createCopyOfPlayers(memento.getPlayers(), this.board);
        this.turn = memento.getTurn().copy(this.players);
    }

    private Player[] createCopyOfPlayers(Player[] players, Board board) {
        Player[] playersCopy = new Player[2];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            playersCopy[i] = new Player(players[i].getColor(), board, players[i].getType());
        }
        return playersCopy;
    }

    public boolean isBoardFull() {
        return this.board.isDraw();
    }

    public Error putTokenPlayerFromTurn(Coordinate coordinate) {
        Error error = this.getPutCoordinateError(coordinate);
        assert error == null;
        if (error != null) {
            return error;
        }
        this.turn.getPlayer().put(coordinate);
        this.changeTurn();
        return null;
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return this.turn.getPlayer().getType();
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        if (!board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void changeTurn() {
        this.turn.change();
    }

    public boolean isConnect4() {
        return this.board.isConnect4(this.turn.getOtherPlayer().getColor());
    }

    public int getValueFromTurn() {
        return this.turn.getValue();
    }

    public int getCoordinateDimension() {
        return Coordinate.DIMENSION;
    }

    public boolean isEmptyToken(Coordinate coordinate) {
        return this.getToken(coordinate) == null;
    }

    public char getTokenChar(Coordinate coordinate) {
        return this.getToken(coordinate).getChar();
    }

    public void newGame() {
		this.board = new Board();
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.turn = new Turn(this.players);
	}
}