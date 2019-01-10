package com.douma.galton_board;

import junit.framework.TestCase;

public class TrayTest extends TestCase
{
    public void test_should_construct_a_list_of_trays_with_increasing_number() throws Exception {
        Tray[] list = Tray.listFromLength(2);

        assert(list[0] instanceof Tray);
        assert(list[1] instanceof Tray);
        assert(list[0].getNumber() == 1);
        assert(list[1].getNumber() == 2);
    }

    public void test_tray_should_append_bullet_and_return_new_instance()
    {
        Tray[] list = Tray.listFromLength(1);
        Tray tray = list[0];

        Bullet[] bullets = Bullet.listFromLength(1);
        Bullet bullet = bullets[0];

        Tray newTray = tray.withBullet(bullet);
        assertNotSame(newTray, tray);
        assertSame(tray.getNumber(), newTray.getNumber());
    }
}
