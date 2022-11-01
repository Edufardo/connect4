package views;

import types.Error;
import utils.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The coordinates are wrong"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}