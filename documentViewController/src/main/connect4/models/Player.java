package models;

import types.Color;
import types.Coordinate;
import types.Error;
import types.PlayerType;

public class Player {

	private Color color;

	private Board board;

	private PlayerType type;

	public Player(Color color, Board board, PlayerType type) {
		this.color = color;
		this.board = board;
		this.type = type;
	}

	public PlayerType getType() {
		return this.type;
	}

	void put(Coordinate coordinate) {
		this.board.putToken(0, color);(coordinate, this.color);
	};

	Color getColor() {
		return this.color;
	}

	public Error getPutCoordinateError(int column) {
		if (!this.board.isColumnFull(column)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		if (!this.board.isOccupied(originCoordinate, this.color)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!this.board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

}