package models;

import types.Color;
import types.PlayerType;

class UserPlayer extends Player {
	
	PlayerType type;

    UserPlayer(Color color, Board board) {
        super(color, board);
        this.type = PlayerType.USER;
    }

}