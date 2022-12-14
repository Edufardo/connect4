package connect4.views.graphics;

import java.awt.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public abstract class CoordinateView extends JPanel implements AncestorListener, KeyListener {

	protected static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	protected static final String ACCEPT = "Ok";
	protected final JLabel labelRow;
	protected final JLabel labelColumn;
	protected JLabel titleLabel;
	protected final JTextField textFieldRow;
	protected final JTextField textFieldColumn;
	protected JButton button;

	CoordinateView() {
		this.setLayout(new GridBagLayout());
		this.labelRow = new JLabel("Row: ");
		this.labelColumn = new JLabel("Column: ");
		this.textFieldRow = new JTextField(1);
		this.textFieldColumn = new JTextField(1);
		this.add(labelRow, new Constraints(0, 1, 1, 1));
		this.add(textFieldRow, new Constraints(0, 2, 1, 1));
		this.add(labelColumn, new Constraints(0, 3, 1, 1));
		this.add(textFieldColumn, new Constraints(0, 4, 1, 1));
	}

	public abstract void actionPerformed(final Action event);

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}