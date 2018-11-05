package battleship;

/*
Name:Battlefield Game Destroyer Object

Author: İbrahim Enes ALAN

Date:22.05.2018

 */
public class Destroyer extends Ship {

    BattleField f = new BattleField();

    String[][] fieldArray = new String[f.width][f.height];

    @Override
    public void setLocation(int x, int y) {
        fieldArray = f.getField();
        if (x + 3 < f.width && y + 1 < f.height) {
            fieldArray[x][y + 1] = "D";
            fieldArray[x + 1][y] = "D";
            fieldArray[x + 1][y + 1] = "D";
            fieldArray[x + 2][y] = "D";
            fieldArray[x + 2][y + 1] = "D";
            fieldArray[x + 3][y + 1] = "D";
        } else {
            throw new IllegalArgumentException();
        }
        f.setField(fieldArray);
    }
}
