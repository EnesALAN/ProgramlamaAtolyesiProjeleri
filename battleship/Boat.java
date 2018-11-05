package battleship;

/*
Name:Battlefield Game Boat Object

Author: İbrahim Enes ALAN

Date:22.05.2018

 */
public class Boat extends Ship {

    BattleField f = new BattleField();

    String[][] fieldArray = new String[f.width][f.height];
    @Override
    public void setLocation(int x, int y) {
        fieldArray=f.getField();
        if(x+1<f.width) {
            fieldArray[x][y] = "B";
            fieldArray[x + 1][y] = "B";
        }else{
            throw new IllegalArgumentException();
        }
        f.setField(fieldArray);
    }
}
