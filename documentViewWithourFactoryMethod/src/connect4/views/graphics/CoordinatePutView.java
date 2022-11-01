package connect4.views.graphics;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;

import java.awt.event.KeyEvent;

import connect4.views.ErrorView;
import connect4.types.Error;
import connect4.types.Coordinate;

public class CoordinatePutView extends CoordinateView {

    private Coordinate coordinate;

    CoordinatePutView() {
        super();
        this.resetCoordinate();
        this.titleLabel = new JLabel(ENTER_COORDINATE_TO_PUT);
        this.add(titleLabel, new Constraints(0, 0, 1, 1));
        this.button = new JButton(CoordinateView.ACCEPT);
        this.add(button, new Constraints(0, 5, 1, 1));
        this.button.addActionListener(null);
        this.button.addKeyListener(this);

    }

    void resetCoordinate() {
        this.coordinate = new Coordinate(0, 0);
    }

    Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void actionPerformed(final Action event) {
        Coordinate coordinateInserted = new Coordinate(Integer.parseInt(this.textFieldRow.getText()) - 1,
                Integer.parseInt(this.textFieldColumn.getText()) - 1);
        Error error;
        if ( Coordinate.VERTICAL_DIMENSION < coordinateInserted.getRow() || Coordinate.HORIZONTAL_DIMENSION < coordinateInserted.getColumn()) {
            error = Error.WRONG_COORDINATES;
        } else {
            error = Error.NULL;
        }
        if (error.isNull()) {
            this.coordinate = new Coordinate(coordinateInserted.getRow(), coordinateInserted.getColumn());
        } else {
            JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal()], "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        this.textFieldRow.setText("");
        this.textFieldColumn.setText("");
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }

}