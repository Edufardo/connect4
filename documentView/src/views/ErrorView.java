package views;

import types.Error;
import utils.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "Column is full",
            "Wrong column",
            "Wrong coordinate"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}