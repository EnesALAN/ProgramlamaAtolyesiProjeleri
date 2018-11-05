package connect4;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.*;

/*
Name:View part of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */
public class BoardButtonView extends BoardView {
    public BoardButtonView(final BoardController controller) {
        super(controller);
    }

    protected JComponent getNewCell() {
        JButton button = new JButton();
        return button;
    }

    public void updateCell(int i, int j, int playerID) {
        JButton button = (JButton) components[i][j];
        button.setText(playerID == 1 ? "R" : "Y");
        if (playerID == 1) {
            button.setBackground(Color.red);
        } else {
            button.setBackground(Color.orange);
        }
        button.setEnabled(false);
    }
}
