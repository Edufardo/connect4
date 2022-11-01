package connect4.views;

import connect4.types.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
        "Column is full",
        "Wrong column",
        "Wrong coordinate"
    };

    public abstract void writeln(Error error);

}