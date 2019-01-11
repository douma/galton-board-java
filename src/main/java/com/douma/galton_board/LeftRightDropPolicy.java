package com.douma.galton_board;

class LeftRightDropPolicy implements DropPolicyInterface
{
    private String last = LEFT;

    public String direction() {
        last = (last.equals(LEFT)) ? RIGHT : LEFT;
        return last;
    }
}
