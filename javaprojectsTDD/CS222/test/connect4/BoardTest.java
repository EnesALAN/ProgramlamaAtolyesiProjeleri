package connect4;

import org.junit.Test;

import static org.junit.Assert.*;
/*
Name: Connect-4 Game Model Tester

Author: İbrahim Enes ALAN

Date:06.04.2018

 */

public class BoardTest {

    @Test
    public void testInitialCondition() {
        Board dummy = new Board();
        //assertTrue(dummy.getConfiguration() == "");
        assertEquals(dummy.getConfiguration(), "[]");
    }

    @Test
    public void testFirstPlayer() {
        Board dummy = new Board("");
        assertEquals(Chip.RED, dummy.getCurrentPlayer());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorConfig() {
        Board dummy = new Board("8");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentAfterFourConnection() {
        Board dummy = new Board("12121212");

    }



    @Test(expected = RuntimeException.class)
    public void testInsertChipIllegalArgumentFullColumn() {
        Board dummy = new Board("1111112");
        dummy.insertChipAt(1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertChipNoColumn() {
        Board dummy = new Board("");
        dummy.insertChipAt(9);

    }

    @Test
    public void testGetCurrentPlayer() {
        Board dummy = new Board("1");
        assertEquals(Chip.YELLOW, dummy.getCurrentPlayer());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentAfterWinner() {
        Board dummy = new Board("12121212");

    }

    @Test
    public void testInsertChipFunctionUsingCurrent() {
        Board dummy = new Board("");
        dummy.insertChipAt(2);
        assertEquals(Chip.YELLOW, dummy.getCurrentPlayer());

    }

    @Test
    public void testInsertChipFunction() {
        Board dummy = new Board("2");
        dummy.insertChipAt(2);
        //assertTrue("22" == dummy.getConfiguration());
        assertEquals("[2, 2]", dummy.getConfiguration());
    }

    @Test
    public void testInsertTwoChipFunction() {
        Board dummy = new Board("");
        dummy.insertChipAt(1);
        dummy.insertChipAt(5);
        assertEquals("[1, 5]", dummy.getConfiguration());

    }

    @Test
    public void testVerticalWinner() {
        Board dummy = new Board("1212121");
        assertEquals(Chip.RED, dummy.getWinner());

    }

    @Test
    public void testHorizontalWinner() {
        Board dummy = new Board("1727374");
        assertEquals(Chip.RED, dummy.getWinner());

    }

    @Test
    public void testRightDiagonalWinner() {
        Board dummy = new Board("12234334544");
        assertEquals(Chip.RED, dummy.getWinner());

    }

    @Test
    public void testRightDiagonalWinnerHigherPosition() {
        Board dummy = new Board("111222233313344441424");
        assertEquals(Chip.RED, dummy.getWinner());

    }

    @Test
    public void testRightDiagonalWinnerUltimatePosition() {
        Board dummy = new Board("4344555566661617777717");
        assertEquals(Chip.YELLOW, dummy.getWinner());

    }

    @Test
    public void testLeftDiagonalWinnerRed() {
        Board dummy = new Board("76654554144");
        assertEquals(Chip.RED, dummy.getWinner());

    }

    @Test
    public void testLeftDiagonalWinnerYellow() {
        Board dummy = new Board("443413331112112222");
        assertEquals(Chip.YELLOW, dummy.getWinner());

    }

    @Test
    public void testYellowWinner() {
        Board dummy = new Board("12121232");
        assertEquals(Chip.YELLOW, dummy.getWinner());

    }

    @Test
    public void testYellowWinner2() {
        Board dummy = new Board("71726364");
        assertEquals(Chip.YELLOW, dummy.getWinner());

    }

    @Test
    public void testToStringMethodUsedBoard() {
        Board dummy = new Board("4455");
        String expected = "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ Y Y _ _ |\n"
                + "_ _ _ R R _ _ |";
        assertEquals(expected, dummy.toString());

    }

    @Test
    public void testToStringMethodEmptyBoard() {
        Board dummy = new Board("");
        String expected = "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |";
        assertEquals(expected, dummy.toString());


    }

    @Test
    public void testToStringMethodEmptyBoard2() {
        Board dummy = new Board("");
        String expected = "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |\n"
                + "_ _ _ _ _ _ _ |";
        assertEquals(expected, dummy.toString());


    }

}
