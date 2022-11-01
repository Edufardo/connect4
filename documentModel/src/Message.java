
enum Message {
	
	TITLE("---Connect 4---"),
	ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
	COLUMN_TO_PUT("Column to put"),
	PLAYER_WIN("#player win!"),
	IS_TIE("Is a tie"),
	RESUME("Do you want to continue?"),
	HORIZONTAL_LINE("---------------"),
	VERTICAL_LINE("|"), 
	ENTER_COLUMN_TO_PUT("Indicate column to put token");
	
	private String message;
	
	Message(String message) {
		 this.message = message;
	}

	
	String writeln() {
		return this.message;
	}
}