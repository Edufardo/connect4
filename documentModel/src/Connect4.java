import utils.YesNoDialog;

public class Connect4 {

    private Board board;
    private Turn turn;

    public Connect4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void play() {
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    public void playGame(){
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.board.write();
        } while (this.board.isGameOver(this.turn.getActivePlayer())); 
        this.turn.writeResult();
    }

    private boolean isResumedGame(){
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if(yesNoDialog.isAffirmative()) {
        	return true;        	
        }
        return false;
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
