package com.douma.galton_board;

public class DescriptiveDropPolicy implements DropPolicyInterface
{
    private String[] words;
    private int index = -1;

    public DescriptiveDropPolicy(String text) {
        this.words = text.split(",");
    }

    public String direction() {
        this.index++;
        String result = (this.words[this.index].equals(LEFT)) ? LEFT : RIGHT;
        System.out.println("Result = " + result);
        return result;
    }
}
