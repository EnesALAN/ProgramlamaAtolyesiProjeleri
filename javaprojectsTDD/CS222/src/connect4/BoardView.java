package connect4;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
Name:View part of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */
public abstract class BoardView extends JFrame {
    protected JComponent[][] components = new JComponent[6][7];

    public BoardView(final BoardController controller) {
        setLayout(new GridLayout(6, 7));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                components[i][j] = getNewCell();
                add(components[i][j]);
                final int row = i;
                final int col = j;
                components[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent arg0) {
                        // Delegate to the controller
                        // the task of handling the user action
                        controller.cellClicked(row, col);
                    }
                });
            }
        }
    }

    public abstract void updateCell(int i, int j, int playerID);

    protected abstract JComponent getNewCell();

    public void updateTitle(int player) {

        setTitle("Player " + player + "'s turn.");
    }

}
