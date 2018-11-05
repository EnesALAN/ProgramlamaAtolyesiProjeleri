package battleship;
/*
Name:Model part of the Battlefield Game

Author: İbrahim Enes ALAN

Date:22.05.2018

 */

import java.util.HashSet;
import java.util.Set;

public class BattleField {
    public int width;
    public int height;

    HashSet<Ship> shipSet = new HashSet<>();
    public static final Ship Boat = new Boat();
    public static final Ship Submarine = new Submarine();
    public static final Ship Destroyer = new Destroyer();
    public String[][] field;

    public BattleField() {

    }

    public BattleField(int width, int height) {
        if (width > 0 && height > 0) {
            field = new String[width][height];
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }


    }

    public void put(int x, int y, Ship ship) {
        if (x < width && y < height) {
            if (ship == Boat) {
                Boat.setLocation(x, y);
            } else if (ship == Submarine) {
                Submarine.setLocation(x, y);
            } else if (ship == Destroyer) {
                Destroyer.setLocation(x, y);
            }

        } else {
            throw new IllegalArgumentException();
        }


    }

    public void shoot(int x, int y) {
        if (field[x][y] == "B") {
            shipSet.add(Boat);
            field[x][y] = " ";
        } else if (field[x][y] == "SM") {
            shipSet.add(Submarine);
            field[x][y] = " ";
        } else if (field[x][y] == "D") {
            shipSet.add(Destroyer);
            field[x][y] = " ";
        }

    }

    public Set<Ship> getReport() {
        if (shipSet.size() == 3) {
            return shipSet;
        } else {
            shipSet.clear();
        }
        return shipSet;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getField() {
        return field;
    }

    public void setField(String[][] field) {
        this.field = field;
    }

    @Override
    public String toString() {
        String battleVersion = "";
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (field[x][y] == null) {
                    battleVersion += "| |";
                } else if (field[x][y] == "B") {
                    battleVersion += "|B|";
                } else if (field[x][y] == "SM") {
                    battleVersion += "|SM|";
                } else if (field[x][y] == "D") {
                    battleVersion += "|D|";
                }
            }
            battleVersion = battleVersion + "|\n";
        }

        return battleVersion;
    }
}
