package connect4;

/*
Name:Main class of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */
public class Main {
    public static void main(String[] args) {
        Board grid = new Board();
        BoardController controller = new BoardController(grid);
        controller.startGame();
    }
}
