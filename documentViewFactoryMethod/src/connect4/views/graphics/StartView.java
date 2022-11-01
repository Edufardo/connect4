package connect4.views.graphics;

import javax.swing.JFrame;
import java.awt.*;

import connect4.models.Game;
import connect4.views.Message;

public class StartView extends JFrame {

    private Game game;

    public StartView(Game game) {
        super(Message.TITLE.toString());
        assert game != null;
        this.game = game;
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void interact() {
        GameView gameView;
        gameView = new GameView(this.game);
        gameView.write();
        this.getContentPane().add(gameView, new Constraints(0, 0, 3, 1));
        this.setVisible(false);
    }

}