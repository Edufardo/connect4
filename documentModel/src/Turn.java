public class Turn {
    
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;


    public Turn(Board board){
        assert board != null;
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
        this.resetGame();
    }
    
    void play(){
        this.players[this.activePlayer].play();
        if(!this.board.isConnect4(this.getActivePlayer())){
            this.activePlayer = (this.activePlayer + 1) % NUMBER_PLAYERS;
        } else if(this.board.isTie(this.getActivePlayer())) {
        	this.resetGame();
        }
    }

    Player getActivePlayer(){
        return this.players[this.activePlayer];
    }
    
    void writeResult() {
    	if(this.board.isTie(this.players[this.activePlayer])) {
    		this.writeTie();
    	}
    	this.writeWinner();
    }
    
    String writeWinner(){
    	return Message.PLAYER_WIN.writeln();
    }

    String writeTie(){
    	return Message.IS_TIE.writeln();
    }
    

    void resetGame(){
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }
}
