package battleship;

/*
Name:Battlefield Game Submarine Object

Author: İbrahim Enes ALAN

Date:22.05.2018

 */
public class Submarine extends Ship {

    BattleField f = new BattleField();

    String[][] fieldArray = new String[f.width][f.height];

    @Override
    public void setLocation(int x, int y) {
        fieldArray = f.getField();
        if (x + 2 < f.width && y + 1 < f.height) {
            fieldArray[x][y + 1] = "SM";
            fieldArray[x + 1][y] = "SM";
            fieldArray[x + 1][y + 1] = "SM";
            fieldArray[x + 2][y + 1] = "SM";
        } else {
            throw new IllegalArgumentException();
        }
        f.setField(fieldArray);

    }

}
