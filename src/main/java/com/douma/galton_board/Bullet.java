package com.douma.galton_board;

class Bullet
{
    private Bullet() {}
    private Bullet(float position)
    {
        this.position = position;
    }
    private float position = 0;

    public static Bullet[] listFromLength(int length)
    {
        Bullet[] list = new Bullet[length];
        for(int x= 0; x<length;x++)
        {
            list[x] = new Bullet();
        }
        return list;
    }

    public Bullet dropRight()
    {
        return new Bullet(this.position += 0.5);
    }

    public Bullet dropLeft()
    {
        return new Bullet(this.position -= 0.5);
    }

    public float getPosition()
    {
        return position;
    }
}
