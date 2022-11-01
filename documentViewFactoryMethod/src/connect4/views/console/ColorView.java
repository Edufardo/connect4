package connect4.views.console;

import connect4.types.Color;
import utils.Console;

class ColorView{
	
	void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
}