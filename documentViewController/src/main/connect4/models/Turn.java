package models;

public class Turn {
	
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int value;


    public Turn(Player[] players){
        this.players = players;
        this.value = 0;
    }

    public Turn(Player[] players, int value) {
		this.value = value;
		this.players = players;
	}
    
    void change() {
		this.value = this.getOtherValue();
	}

	Player getPlayer() {
		return this.players[this.value];
	}

	int getValue() {
		return this.value;
	}

	private int getOtherValue() {
		return (this.value + 1) % Turn.NUMBER_PLAYERS;
	}

	Player getOtherPlayer() {
		return this.players[this.getOtherValue()];
	}

	Turn copy(Player[] players) {
		return new Turn(players, this.value);
	}

}