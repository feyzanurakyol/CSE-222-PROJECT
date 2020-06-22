package com.Group1;

public class WorkPlace {
    protected Block block;
    protected int floor;
    public WorkPlace () {
        block = new Block ();
        floor = 0;
    }
    public WorkPlace (Block block, int floor) {
        this.block = block;
        this.floor = floor;
    }
    public Block getBlock () {
        return block;
    }

    public void setBlock (Block block) {
        this.block = block;
    }

    public int getFloor () {
        return floor;
    }

    public void setFloor (int floor) {
        this.floor = floor;
    }


    @Override
    public String toString () {
        return "WorkPlace{" +
                "block=" + block +
                ", floor=" + floor +
                '}';
    }
}
