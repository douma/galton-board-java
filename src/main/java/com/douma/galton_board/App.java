package com.douma.galton_board;

public class App 
{
    public static void main( String[] args )
    {
        Bullet[] bullets = Bullet.listFromLength(200);
        Tray[] trays = Tray.listFromLength(8);
        DropPolicyInterface dropPolicy = new RandomDropPolicy();
        GaltonBoard galtonBoard = new GaltonBoard(trays, bullets, dropPolicy);

        try
        {
            galtonBoard = galtonBoard.dropBullets();
            Tray[] resultTrays = galtonBoard.getTrays();
            for(Tray tray : resultTrays) {
                System.out.println(String.format("%1$" + tray.getNumberOfBullets() + "s", "").replace(' ', '0'));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
