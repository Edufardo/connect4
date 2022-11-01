package connect4.views.graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

import connect4.models.Game;
import connect4.types.Coordinate;
import connect4.views.Message;
import connect4.types.Error;
import connect4.views.ErrorView;

class PlayView extends JFrame {

    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";
    private CoordinatePutView coordinatePutView;
    private Game game;
    private GameView gameView;

    PlayView(Game game) {
        super(Message.TITLE.toString());
        assert game != null;

        this.game = game;
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameView = new GameView(game);
        this.getContentPane().add(this.gameView);
        this.gameView.write();
        this.setVisible(true);
        this.coordinatePutView = new CoordinatePutView();
        this.getContentPane().add(this.coordinatePutView, new Constraints(0, 1, 3, 1));
        this.gameView.removeAll();
        this.setVisible(true);
    }

    void interact() {
        this.gameView.removeAll();
        this.gameView.write();
        this.setVisible(true);
        do {
            if (!this.game.areAllTokensOnBoard()) {
                this.put();
            } 
            this.game.next();
            this.gameView.write();
            this.setVisible(true);
        } while (!this.game.isConnect4() || !this.game.isTie());
        this.getContentPane().add(new JLabel(this.game.getActiveColor().toString() + Message.PLAYER_WIN.toString()),
                new Constraints(0, 1, 4, 1));
        this.setVisible(true);
    }

    private void put() {
        Coordinate coordinate;
        Error error;
        do {
            this.setVisible(true);
            do {
                coordinate = this.coordinatePutView.getCoordinate();
                System.out.println("");
            } while (coordinate.isNull());
            error = this.game.getPutTokenError(coordinate);
            if (!error.isNull()) {
                JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal()], "ERROR",
                        JOptionPane.WARNING_MESSAGE);
                this.coordinatePutView.resetCoordinate();
            }
        } while (!error.isNull());
        this.game.putToken(coordinate);
        this.coordinatePutView.resetCoordinate();
    }

}