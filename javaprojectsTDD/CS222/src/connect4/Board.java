package connect4;
/*
Name:Model part of the Connect-4 Game

Author: İbrahim Enes ALAN

Date:06.04.2018

 */

import java.util.ArrayList;
import java.util.List;

enum Chip {
    NONE, RED, YELLOW
}

public class Board {
    public static final int NUM_COLUMNS = 7;
    public static final int NUM_ROWS = 6;
    Chip[][] multi = new Chip[NUM_ROWS][NUM_COLUMNS];
    public Chip currentChipPlayer = Chip.RED;

    /**
     * Creates an empty Connect4 board.
     * The first player to play will be the RED one.
     */
    public Board() {
        int x;
        for (x = 0; x < NUM_ROWS; x++) {
            for (int y = 0; y < NUM_COLUMNS; y++) {
                multi[x][y] = Chip.NONE;
            }
        }
        currentChipPlayer = Chip.RED;


    }


    public Board(String configuration) {

        int x;
        for (x = 0; x < NUM_ROWS; x++) {
            for (int y = 0; y < NUM_COLUMNS; y++) {
                multi[x][y] = Chip.NONE;
            }
        }

        char[] digitsConfig = configuration.toCharArray();




        for (int t = 0; t < digitsConfig.length; t++) {
            int ro = 0;

            int val = digitsConfig[t] - 48;
            if (val > NUM_COLUMNS || getWinner() != Chip.NONE) {
                throw new IllegalArgumentException();
            } else {
                insertChipAt(val);
            }

        }


    }


    /**
     * Inserts a chip for the current player at the specified <code>column</code>
     * (indexing starts at 1). After the chip is inserted, it wil be the other player's turn.
     *
     * @param column The index of the column into which to put a chip.
     * @throws IllegalArgumentException if no column at the specified index exists.
     * @throws RuntimeException         if inserting a chip at the specified column is not possible (e.g. when the column is full)
     */
    public void insertChipAt(int column) {
        if (column <= NUM_COLUMNS) {
            column = column - 1;
            if (columnSituationTesting(column) && currentChipPlayer == Chip.RED) {
                multi[rowSituationTesting(column)][column] = Chip.RED;
                currentChipPlayer = Chip.YELLOW;
            } else if (columnSituationTesting(column) && currentChipPlayer == Chip.YELLOW) {
                multi[rowSituationTesting(column)][column] = Chip.YELLOW;
                currentChipPlayer = Chip.RED;
            }else if(columnSituationTesting(column)==false){
                throw new RuntimeException();
            }

        } else
            throw new IllegalArgumentException();
    }

    public boolean columnSituationTesting(int column) {
        for (int i = 0; i < NUM_ROWS; i++) {
            if (multi[i][column] == Chip.NONE) {

                return true;
            }
        }
        return false;
    }

    public int rowSituationTesting(int column) {
        for (int i = 0; i < NUM_ROWS; i++) {
            if (multi[i][column] == Chip.NONE) {
                return i;
            }
        }
        throw new RuntimeException();
    }


    /**
     * @return the winner Chip (RED or YELLOW) if there exists a 4-connection;
     * NONE, otherwise.
     */
    public Chip getWinner() {

        if (rightDiagonalWinner() == Chip.RED) {
            return Chip.RED;
        } else if (rightDiagonalWinner() == Chip.YELLOW) {
            return Chip.YELLOW;
        }

        if (leftDiagonalWinner() == Chip.RED) {
            return Chip.RED;
        } else if (leftDiagonalWinner() == Chip.YELLOW) {
            return Chip.YELLOW;
        }
        for (int i = 0; i < 7; i++) {
            if (columnWinner(i) == Chip.RED) {
                return Chip.RED;
            } else if (columnWinner(i) == Chip.YELLOW) {
                return Chip.YELLOW;
            }
        }
        for (int t = 0; t < 6; t++) {
            if (rowWinner(t) == Chip.RED) {
                return Chip.RED;
            } else if (rowWinner(t) == Chip.YELLOW) {
                return Chip.YELLOW;
            }
        }


        return Chip.NONE;
    }


    public Chip columnWinner(int column) {
        int winningConditionForRed = 0;
        int winningConditionForYellow = 0;
        if (winningConditionForRed < 4) {
            for (int i = 0; i < NUM_ROWS; i++) {
                if (multi[i][column] == Chip.RED && winningConditionForRed < 4) {
                    winningConditionForRed++;
                } else if (winningConditionForRed != 4) {
                    winningConditionForRed = 0;
                }
            }
        }

        if (winningConditionForYellow < 4) {
            for (int i = 0; i < NUM_ROWS; i++) {
                if (multi[i][column] == Chip.YELLOW && winningConditionForYellow < 4) {
                    winningConditionForYellow++;
                } else if (winningConditionForYellow != 4) {
                    winningConditionForYellow = 0;
                }
            }
        }


        if (winningConditionForRed == 4) {
            return Chip.RED;
        } else if (winningConditionForYellow == 4) {
            return Chip.YELLOW;
        }

        return Chip.NONE;
    }


    public Chip rowWinner(int row) {
        int winningConditionForRed = 0;
        int winningConditionForYellow = 0;
        if (winningConditionForRed < 4) {
            for (int i = 0; i < NUM_COLUMNS; i++) {
                if (multi[row][i] == Chip.RED && winningConditionForRed < 4) {
                    winningConditionForRed++;
                } else if (winningConditionForRed != 4) {
                    winningConditionForRed = 0;
                }
            }
        }

        if (winningConditionForYellow < 4) {
            for (int i = 0; i < NUM_COLUMNS; i++) {
                if (multi[row][i] == Chip.YELLOW && winningConditionForYellow < 4) {
                    winningConditionForYellow++;
                } else if (winningConditionForYellow != 4) {
                    winningConditionForYellow = 0;
                }
            }
        }


        if (winningConditionForRed == 4) {
            return Chip.RED;
        } else if (winningConditionForYellow == 4) {
            return Chip.YELLOW;
        }

        return Chip.NONE;
    }

    public Chip rightDiagonalWinner() {
        int winningConditionForRed = 0;
        int winningConditionForYellow = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (multi[x][y] == Chip.RED) {
                    if (multi[x + 1][y + 1] == Chip.RED) {
                        if (multi[x + 2][y + 2] == Chip.RED) {
                            if (multi[x + 3][y + 3] == Chip.RED) {
                                winningConditionForRed = 4;
                                y = 5;
                                x = 5;
                            }
                        }
                    }
                }
            }
        }


        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (multi[x][y] == Chip.YELLOW) {
                    if (multi[x + 1][y + 1] == Chip.YELLOW) {
                        if (multi[x + 2][y + 2] == Chip.YELLOW) {
                            if (multi[x + 3][y + 3] == Chip.YELLOW) {
                                winningConditionForYellow = 4;
                                y = 5;
                                x = 5;
                            }
                        }
                    }
                }
            }
        }


        if (winningConditionForRed == 4) {
            return Chip.RED;
        } else if (winningConditionForYellow == 4) {
            return Chip.YELLOW;
        }

        return Chip.NONE;
    }

    public Chip leftDiagonalWinner() {
        int winningConditionForRed = 0;
        int winningConditionForYellow = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 3; y < 7 && y > 2; y++) {
                if (multi[x][y] == Chip.RED) {
                    if (multi[x + 1][y - 1] == Chip.RED) {
                        if (multi[x + 2][y - 2] == Chip.RED) {
                            if (multi[x + 3][y - 3] == Chip.RED) {
                                winningConditionForRed = 4;
                                y = 1;
                                x = 5;
                            }
                        }
                    }
                }
            }
        }


        for (int x = 0; x < 3; x++) {
            for (int y = 3; y < 7 && y > 2; y++) {
                if (multi[x][y] == Chip.YELLOW) {
                    if (multi[x + 1][y - 1] == Chip.YELLOW) {
                        if (multi[x + 2][y - 2] == Chip.YELLOW) {
                            if (multi[x + 3][y - 3] == Chip.YELLOW) {
                                winningConditionForYellow = 4;
                                y = 1;
                                x = 5;
                            }
                        }
                    }
                }
            }
        }


        if (winningConditionForRed == 4) {
            return Chip.RED;
        } else if (winningConditionForYellow == 4) {
            return Chip.YELLOW;
        }

        return Chip.NONE;
    }

    // Returns the chip at the given location.
// row and column parameters are 1-based indices.
    public Chip getChipAt(int row, int column) {
        if (multi[row - 1][column - 1] == Chip.RED) {
            return Chip.RED;
        } else if (multi[row - 1][column - 1] == Chip.YELLOW) {
            return Chip.YELLOW;
        }
        return Chip.NONE;

    }

    /**
     * @return The current state of the board as a "configuration".
     * GET CONFİG DEN CURRENT PLAYERI AL HER AŞAMADA.
     */
    public String getConfiguration() {
        List<Integer> configArray = new ArrayList<>();
        List<Integer> configArrayYellow = new ArrayList<>();
        String config = "";
        int rowf = 0;
        int col;
        boolean exit = false;
        for (col = 0; exit != true; col++) {
            if (multi[rowf][col] == Chip.RED) {
                //config = config + (col + 1);
                configArray.add(col + 1);
                configArray.add(0);
            } else if (col == 6) {
                col = 0;
                if (rowf == 5) {
                    exit = true;
                } else if (rowf < 5) {
                    rowf++;
                }


//array hatası veriyo break incele
            }
        }
        exit = false;
        rowf = 0;
        for (col = 0; exit != true; col++) {
            if (multi[rowf][col] == Chip.YELLOW) {
                //config = config + (col + 1);
                configArrayYellow.add(col + 1);

            } else if (col == 6) {
                col = 0;
                if (rowf == 5) {
                    exit = true;
                } else if (rowf < 5) {
                    rowf++;
                }


//array hatası veriyo break incele
            }
        }
        if (configArrayYellow.isEmpty() == false) {
            boolean yellowExit = false;
            for (int t = 0; yellowExit != true; t++) {
                int at = 0;
                if (configArray.get(t) == 0) {
                    configArray.set(t, configArrayYellow.get(at));
                    configArrayYellow.remove(at);
                    if (configArrayYellow.isEmpty() == true) {
                        yellowExit = true;
                    }

                }
            }
        }


        return String.valueOf(configArray);
    }


    /**
     * @return The Chip of the current player.
     */
    public Chip getCurrentPlayer() {

        return currentChipPlayer;
    }

    /**
     * @return this board's string representation.
     * E.g. here is the output for the configuration 3432554:
     * <p>
     * |_ _ _ _ _ _ _|
     * |_ _ _ _ _ _ _|
     * |_ _ _ _ _ _ _|
     * |_ _ _ _ _ _ _|
     * |_ _ R R Y _ _|
     * |_ Y R Y R _ _|
     */
    public String toString() {
        String boardVersion = "";
        // Hint: You can override the toString() method of an enum.
        for (int i = 5; i != -1; i--) {
            for (int t = 0; t < NUM_COLUMNS; t++) {
                switch (multi[i][t]) {
                    case RED:
                        boardVersion = boardVersion + "R ";
                        break;
                    case YELLOW:
                        boardVersion = boardVersion + "Y ";
                        break;
                    case NONE:
                        boardVersion = boardVersion + "_ ";
                        break;

                }


            }
            if(i>0){
                boardVersion = boardVersion + "|\n";
            }else if(i==0){
                boardVersion=boardVersion+"|";
            }

        }


        return boardVersion;
    }
}
