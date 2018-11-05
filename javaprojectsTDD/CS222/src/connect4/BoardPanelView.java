package connect4;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/*
Name:View part of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */
public class BoardPanelView extends BoardView {
    public BoardPanelView(final BoardController controller) {
        super(controller);
    }

    protected JComponent getNewCell() {
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder());
        return panel;
    }

    public void updateCell(int i, int j, int playerID) {
        JPanel panel = (JPanel) components[i][j];
        panel.setBackground(playerID == 1 ? Color.RED : Color.BLUE);
        panel.setEnabled(false);
    }


}
