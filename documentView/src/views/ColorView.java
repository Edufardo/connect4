package views;

import types.Color;
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