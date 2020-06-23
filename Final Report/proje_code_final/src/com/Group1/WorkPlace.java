package com.Group1;

public class WorkPlace {
    protected String block;
    protected int floor;
    public WorkPlace () {
        block = "A";
        floor = 0;
    }
    public WorkPlace (String block, int floor) {
        this.block = block;
        this.floor = floor;
    }
    public String getBlock () {
        return block;
    }

    public void setBlock (String block) {
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
