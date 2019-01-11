package com.douma.galton_board;

import junit.framework.TestCase;

public class GaltonBoardTest extends TestCase
{
    public void test_should_construct() throws Exception {
        Bullet[] bullets = Bullet.listFromLength(10);
        Tray[] trays = Tray.listFromLength(10);
        DropPolicyInterface dropPolicy = new RandomDropPolicy();

        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, dropPolicy);
        assert(galtonBoard instanceof GaltonBoard);
    }

    public void test_should_drop_bullets_and_be_in_left_most_tray() {
        Bullet[] bullets = Bullet.listFromLength(10);
        Tray[] trays = Tray.listFromLength(10);
        DropPolicyInterface dropPolicy = new LeftOrientedDropPolicy();

        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, dropPolicy);

        try
        {
            galtonBoard.dropBullets();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            assert(false);
        }

        Tray[] resultTrays = galtonBoard.getTrays();
        assertEquals(0, resultTrays[0].getNumber());
        assertEquals(10, resultTrays[0].getNumberOfBullets());
    }

    public void test_should_drop_bullets_and_be_in_right_most_tray() {
        Bullet[] bullets = Bullet.listFromLength(10);
        Tray[] trays = Tray.listFromLength(10);
        DropPolicyInterface dropPolicy = new RightOrientedDropPolicy();

        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, dropPolicy);

        try
        {
            galtonBoard.dropBullets();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            assert(false);
        }

        Tray[] resultTrays = galtonBoard.getTrays();
        assertEquals(9, resultTrays[9].getNumber());
        assertEquals(10, resultTrays[9].getNumberOfBullets());
    }

    public void test_should_drop_bullets_and_be_in_middle_tray() {
        Bullet[] bullets = Bullet.listFromLength(10);
        Tray[] trays = Tray.listFromLength(9);
        DropPolicyInterface dropPolicy = new LeftRightDropPolicy();

        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, dropPolicy);

        try
        {
            galtonBoard.dropBullets();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            assert(false);
        }

        Tray[] resultTrays = galtonBoard.getTrays();
        assertEquals(4, resultTrays[4].getNumber());
        assertEquals(10, resultTrays[4].getNumberOfBullets());
    }
}
