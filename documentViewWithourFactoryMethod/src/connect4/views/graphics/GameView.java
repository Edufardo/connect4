package connect4.views.graphics;

import javax.swing.*;
import java.awt.*;

import connect4.models.Game;
import connect4.types.Color;
import connect4.types.Coordinate;
import connect4.views.Message;

public class GameView extends JPanel {
    
    private Game game;

    GameView(Game game){
        this.game = game;
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.HORIZONTAL_LINE.toString()), new Constraints(0, 0, 1, 1));
    }

    void write(){
        this.removeAll();
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.HORIZONTAL_LINE.toString()), new Constraints(0, 0, 1, 1));
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            this.printRowBoard(i);
        }
        this.add(new JLabel(Message.HORIZONTAL_LINE.toString()), new Constraints(0, 7, 1, 1));
    }

    private void printRowBoard(int row) {
        String boardRowToPresent = "";
        boardRowToPresent += Message.VERTICAL_LINE.toString();
        for (int j = 0; j < Coordinate.DIMENSION; j++) {
            boardRowToPresent += this.getSquareBoardText(row, j);
        }
        JLabel label = new JLabel(boardRowToPresent);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, new Constraints(0, row + 1, 10, 1));
    }

    private String getSquareBoardText(int row, int column) {
        String squareBoardToPresent = "";
        Color color = this.game.getColor(new Coordinate(row, column));
        if (color.isNull()) {
            squareBoardToPresent += "-";
        } else {
            squareBoardToPresent += color.toString();
        }
        squareBoardToPresent += Message.VERTICAL_LINE.toString();
        return squareBoardToPresent;
    }
}
