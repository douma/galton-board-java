package com.douma.galton_board;

import junit.framework.TestCase;

public class DropPolicyTest extends TestCase
{
    public void test_should_randomly_return_left_or_right_test() throws Exception {

        DropPolicyInterface sut = new RandomDropPolicy();
        int count = 0;
        String initialResult = sut.direction();
        String lastResult = sut.direction();

        while(initialResult == lastResult){
            count++;
            lastResult = sut.direction();

            if(count > 100) {
                throw new Exception("No other value occured in 100 iterations");
            }
        }
        assertNotSame(initialResult, lastResult);
    }
}
