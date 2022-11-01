
enum Error {

	COLUMN_FULL("The column is full"), 
	WRONG_COORDINATES("The coordinates are wrong"), 
	NULL;

	private String message;

	Error() {

	}

	Error(String message) {
		this.message = message;
	}

	boolean isNull() {
		return this == Error.NULL;
	}

	String writeln() {
		return this.message;
	}
}
