package com.douma.galton_board;

import java.util.ArrayList;

class Tray
{
    private Tray(int number)
    {
        this.number = number;
        this.bullets = new ArrayList<Bullet>();
    }
    private int number;
    private ArrayList<Bullet> bullets;

    public static Tray[] listFromLength(int length)
    {
        Tray[] list = new Tray[length];
        for(int x= 0; x<length;x++)
        {
            list[x] = new Tray(x);
        }
        return list;
    }

    public Tray withBullet(Bullet bullet)
    {
        Tray newTray = new Tray(this.number);
        newTray.bullets = this.bullets;
        newTray.bullets.add(bullet);
        return newTray;
    }

    public int getNumberOfBullets()
    {
        return this.bullets.size();
    }

    public int getNumber()
    {
        return number;
    }
}
