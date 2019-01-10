package com.douma.galton_board;

import junit.framework.TestCase;

public class BulletTest extends TestCase
{
    public void test_should_construct_a_list_of_bullets() throws Exception {
        Bullet[] list = Bullet.listFromLength(2);

        assert(list[0] instanceof Bullet);
        assert(list[1] instanceof Bullet);
    }

    public void test_should_return_new_instance_on_position_change_drop_right()
    {
        Bullet[] list = Bullet.listFromLength(1);
        Bullet bullet = list[0];

        Bullet newBullet = bullet.dropRight();

        assertNotSame(newBullet, bullet);
        assert(0.5 == newBullet.getPosition());
    }

    public void test_should_return_new_instance_on_position_change_drop_left()
    {
        Bullet[] list = Bullet.listFromLength(1);
        Bullet bullet = list[0];

        Bullet newBullet = bullet.dropLeft();

        assertNotSame(newBullet, bullet);
        assert(-0.5 == newBullet.getPosition());
    }
}
