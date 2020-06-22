package com.Group1;

import java.util.ArrayList;
import java.util.Objects;

public class Block {
    protected String blockName;
    protected ArrayList<Integer> wards;//koğuşlar
    protected ArrayList<String> otherRooms;//dinner room etc.
    public Block () {
        blockName = "A";
        wards = new ArrayList<> ();
        otherRooms = new ArrayList<> ();
    }

    public Block (String blockName) {
        this.blockName = blockName;
        wards=new ArrayList<> ();
        otherRooms = new ArrayList<> ();
    }

    public Block (String blockName, ArrayList<Integer> wards, ArrayList<String> otherRooms) {
        this.blockName = blockName;
        this.wards = wards;
        this.otherRooms = otherRooms;
    }

    public String getBlockName () {
        return blockName;
    }

    public void setBlockName (String blockName) {
        this.blockName = blockName;
    }

    public ArrayList<Integer> getWards () {
        return wards;
    }

    public void setWards (ArrayList<Integer> wards) {
        this.wards = wards;
    }

    public ArrayList<String> getOtherRooms () {
        return otherRooms;
    }

    public void setOtherRooms (ArrayList<String> otherRooms) {
        this.otherRooms = otherRooms;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Block block = (Block) o;
        return blockName.equals (block.blockName) &&
                wards.equals (block.wards) &&
                otherRooms.equals (block.otherRooms);
    }

    @Override
    public String toString () {
        return "Block{" +
                "blockName='" + blockName + '\'' +
                ", wards=" + wards +
                ", otherRooms=" + otherRooms +
                '}';
    }
}
