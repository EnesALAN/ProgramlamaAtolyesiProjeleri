package connect4;

import javax.swing.JOptionPane;

/*
Name:Controller part of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */
public class BoardController {
    private Board multi;
    private BoardView view;

    public BoardController(Board multi) {
        this.multi = multi;

        // Randomly pick a view.
        // This is just to show that different visualization methods
        // can work seamlessly.
        // Exercise: Write a view class that uses images.
        if (Math.random() < 0.5) {
            this.view = new BoardPanelView(this);
        } else {
            this.view = new BoardButtonView(this);
        }
    }

    public void startGame() {
        view.setSize(500, 500);
        view.setVisible(true);
    }

    public void cellClicked(int row, int col) {
        int currentPlayer = 0;
        int nextPlayer = 0;
        //buraya sırala modeldeki fonksiyonları
        if (multi.getCurrentPlayer() == Chip.RED) {
            currentPlayer = 1;
        } else if (multi.getCurrentPlayer() == Chip.YELLOW) {
            currentPlayer = 2;
        }

        multi.insertChipAt(col);
        if (multi.getCurrentPlayer() == Chip.RED) {
            nextPlayer = 1;
        } else if (multi.getCurrentPlayer() == Chip.YELLOW) {
            nextPlayer = 2;
        }


        view.updateCell(row, col, currentPlayer);
        view.updateTitle(nextPlayer);

        if (multi.getWinner() != Chip.NONE) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!!!");
            System.exit(0);
        }


    }


}
