package survivor;

import org.junit.Test;

import static org.junit.Assert.*;


/*
Title:Survivor Project Test Class

Author:Ibrahim Enes ALAN

Date:27/03/2018

*/

public class SurvivorTest {

    // Checking each cell is initially dead
    @Test
    public void testInitialCellCondition() {
        Survivor dummy = new Survivor(5, 5);
        assertFalse(dummy.isLive(3, 4));

    }

    // Checking each cell is initially dead
    @Test
    public void testInitialCellCondition2() {
        Survivor dummy = new Survivor(1, 1);
        assertFalse(dummy.isLive(1, 1));

    }

    //Checks Negative Row Situation
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorNegativeRow() {
        Survivor dummy = new Survivor(-5, 3);

    }

    //Checks Negative Column Situation
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorNegativeColumn() {
        Survivor dummy = new Survivor(5, -3);

    }

    //Checks Negative Dimension Situation
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorBothNegative() {
        Survivor dummy = new Survivor(-7, -8);

    }

    @Test
    public void testSetLiveFunction() {
        Survivor dummy = new Survivor(8, 8);
        dummy.setLive(3, 4);
        assertTrue(dummy.isLive(3, 4));

    }

    // Does nothing if the specified coordinate is out of bounds
    @Test
    public void testSetLiveFunctionOutOfBounds() {
        Survivor dummy = new Survivor(8, 8);
        Survivor dummyclone = new Survivor(8, 8);
        dummy.setLive(9, 16);

        assertEquals(dummy.toString(), dummyclone.toString());
    }

    @Test
    public void testSetDeadFunction() {
        Survivor dummy = new Survivor(5, 5);
        dummy.setDead(2, 2);
        assertFalse(dummy.isLive(2, 2));

    }

    @Test
    public void testSetDeadFunctionOutOfBounds() {
        Survivor dummy = new Survivor(5, 5);
        Survivor dummyclone = new Survivor(5, 5);
        dummy.setDead(22, 56);

        assertEquals(dummy.toString(), dummyclone.toString());
    }

    @Test
    public void testIsLiveFunctionOutOfBoundsForRow() {
        Survivor dummy = new Survivor(7, 5);

        assertEquals(dummy.isLive(12, 2), dummy.isLive(12, 2));

    }

    @Test
    public void testIsLiveFunctionOutOfBoundsForColumn() {
        Survivor dummy = new Survivor(7, 5);
        Survivor dummyclone = new Survivor(7, 5);
        dummy.isLive(4, 35);
        assertEquals(dummy.toString(), dummyclone.toString());

    }

    @Test
    public void testIsLiveFunctionOutOfBoundsForBothColumnRow() {
        Survivor dummy = new Survivor(7, 5);
        Survivor dummyclone = new Survivor(7, 5);
        dummy.isLive(42, 37);

        assertEquals(dummy.toString(), dummyclone.toString());
    }

    // * Checking situation : A live cell with one or no live neighbors dies.
    @Test
    public void testPassADayCellHasNoLiveNeighbors() {
        Survivor dummy = new Survivor(5, 5);
        dummy.setLive(1, 2);
        dummy.passADay();
        assertFalse(dummy.isLive(1, 2));


    }

    // * Checking situation : A live cell with one or no live neighbors dies.
    @Test
    public void testPassADayCellHasOneLiveNeighbors() {
        boolean twoDead;
        Survivor dummy = new Survivor(5, 5);
        dummy.setLive(1, 2);
        dummy.setLive(2, 2);
        dummy.passADay();
        twoDead = dummy.isLive(1, 2) || dummy.isLive(2, 2);
        assertFalse(twoDead);

    }


    // * Checking situation : A live cell with four or more neighbors dies.
    @Test
    public void testPassADayCellHasFourLiveNeighbors() {
        Survivor dummy = new Survivor(5, 5);
        //setting 4 neighbors situation to Live.
        dummy.setLive(3, 2);
        dummy.setLive(2, 2);
        dummy.setLive(4, 2);
        dummy.setLive(2, 3);
        dummy.setLive(3, 3);
        dummy.passADay();
        //checking Cell situation which located in (3,2).This cell has 4 Live Neighbors.
        assertFalse(dummy.isLive(3, 2));


    }

    //* Checking situation : A dead cell with three live neighbors becomes live.
    @Test
    public void testPassADayDeadCellHasThreeLiveNeighbors() {
        boolean cellSituation;
        Survivor dummy = new Survivor(5, 5);
        //setting 3 neighbors situation to Live.
        dummy.setLive(3, 2);
        dummy.setLive(2, 3);
        dummy.setLive(4, 3);
        dummy.passADay();
        //(3,3) was dead in the beginning but after the first day it becomes Live because it has 3 Live neighbors.
        cellSituation = dummy.isLive(3, 3);
        assertTrue(cellSituation);


    }

    //* A live cell with two or three *live* neighbors survives.
    @Test
    public void testPassADayLiveCellHasTwoLiveNeighbors() {
        Survivor dummy = new Survivor(4, 4);

        //setting 3 cell situation to Live.
        dummy.setLive(2, 3);
        dummy.setLive(1, 3);
        dummy.setLive(3, 3);

        dummy.passADay();

        //Checks our cell can survive the day.
        assertTrue(dummy.isLive(2, 3));


    }

    //* A live cell with two or three *live* neighbors survives.
    @Test
    public void testPassADayLiveCellHasThreeLiveNeighbors() {
        Survivor dummy = new Survivor(4, 5);

        //setting 4 cell situation to Live.
        dummy.setLive(2, 3);
        dummy.setLive(1, 3);
        dummy.setLive(3, 3);
        dummy.setLive(2, 4);

        dummy.passADay();

        //Checks our cell can survive the day.
        assertTrue(dummy.isLive(2, 3));


    }

    //* A live cell with two or three *live* neighbors survives.
    @Test
    public void testPassTwoDayAndCheckCellSituation() {
        boolean cellSituation;
        Survivor dummy = new Survivor(5, 5);

        //setting 4 cell situation to Live.
        dummy.setLive(1, 1);
        dummy.setLive(1, 3);
        dummy.setLive(2, 1);
        dummy.setLive(3, 1);
        dummy.setLive(3, 3);
        dummy.setLive(2, 2);

        dummy.passADay();
        //Now (2,2) is dead.
        cellSituation = dummy.isLive(2, 2);
        dummy.passADay();
        //This cell 5 Live neighbors after passing a day.Unlucky cell still be dead.
        cellSituation = cellSituation || dummy.isLive(2, 2);
        assertFalse(cellSituation);

    }

}

