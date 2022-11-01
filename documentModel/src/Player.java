import utils.BoundedIntDialog;

class Player {
    
    private Board board;
    private Color color;
    private int putTokens;

    Player(Color color, Board board){
        assert color.isNull();
        assert board != null;

        this.board = board;
        this.color = color;
        this.putTokens = 0;
    }

    void play(){
        if(!this.board.isBoardFull()){
            this.putToken();
        }
    }

    Color getColor(){
        return this.color;
    }

    void putToken(){
        int column;
        Error error;
        do {
            column = this.getColumn(Message.COLUMN_TO_PUT);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
        this.putTokens++;
    }

    int getColumn(Message message){
    	assert message != null;
    	
    	BoundedIntDialog boundedIntDialog = new BoundedIntDialog(0, Coordinate.HORIZONTAL_DIMENSION - 1);		 
		return boundedIntDialog.read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    Error getPutTokenError(int column){ 
        Error error = Error.NULL;
        if(!this.board.isFullColumn(column)){
            error = Error.COLUMN_FULL;
        }
        error.writeln();
        return error;
    }
    
}
