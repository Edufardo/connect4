package models;

import types.Color;
import types.Coordinate;
import types.PlayerType;

class MachinePlayer extends Player {

	PlayerType type;
	
	MachinePlayer(Color color, Board board) {
		super(color, board);
		this.type = PlayerType.MACHINE;
	}

	Coordinate getRandomCoordinate(){
		Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
	}
}