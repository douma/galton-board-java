package com.douma.galton_board;

import java.util.Random;

class RandomDropPolicy implements DropPolicyInterface
{
    public String direction() {
        Random random = new Random();
        return random.nextBoolean() ? LEFT : RIGHT;
    }
}
