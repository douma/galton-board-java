package com.douma.galton_board;

class GaltonBoard
{
    private Tray[] trays;
    private Bullet[] bullets;
    private DropPolicyInterface dropPolicy;

    public GaltonBoard(Tray[] trays, Bullet[] bullets, DropPolicyInterface dropPolicy)
    {
        this.trays = trays;
        this.bullets = bullets;
        this.dropPolicy = dropPolicy;
    }

    private GaltonBoard updateTray(Tray tray, Tray newTray) throws Exception
    {
        int count = 0;
        boolean replaced = false;
        for(Tray trayLoop : trays)
        {
            if(trayLoop == tray)
            {
                replaced = true;
                break;
            }
            count++;
        }

        if(!replaced)
        {
            throw new Exception("Tray is not replaced");
        }

        Tray[] trays = this.trays;
        trays[count] = newTray;
        return new GaltonBoard(trays, bullets, dropPolicy);
    }

    private int middle()
    {
        return trays.length / 2;
    }

    private Tray getResultTray(Bullet bullet) throws Exception
    {
        int middle = this.middle();
        double position = middle + bullet.getPosition();
        int resultTray = (int) Math.floor(position);

        for(Tray tray : trays)
        {
            if(tray.getNumber() == resultTray)
            {
                return tray;
            }
        }

        throw new Exception("Resulting tray not found for number " + resultTray);
    }

    private GaltonBoard dropBullet(Bullet bullet) throws Exception
    {
        for(int x = 0; x<this.numberOfDrops();x++)
        {
           if(dropPolicy.direction() == DropPolicyInterface.LEFT)
           {
               bullet = bullet.dropLeft();
           }
           else
           {
               bullet = bullet.dropRight();
           }
        }

        Tray resultTray = this.getResultTray(bullet);
        return this.updateTray(resultTray, resultTray.withBullet(bullet));
    }

    private int numberOfDrops()
    {
        return this.trays.length - 1;
    }

    public GaltonBoard dropBullets() throws Exception
    {
        GaltonBoard board = this;
        for(Bullet bullet : board.bullets)
        {
            board = dropBullet(bullet);
        }
        return board;
    }

    public Tray[] getTrays()
    {
        return trays;
    }
}
