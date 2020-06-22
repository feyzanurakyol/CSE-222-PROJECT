package com.Group1;

import java.util.ArrayList;

public class Block {
    protected String blockName;
    protected ArrayList<String> wards;//koğuşlar
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

    public Block (String blockName, ArrayList<String> wards, ArrayList<String> otherRooms) {
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

    public ArrayList<String> getWards () {
        return wards;
    }

    public void setWards (ArrayList<String> wards) {
        this.wards = wards;
    }

    public ArrayList<String> getOtherRooms () {
        return otherRooms;
    }

    public void setOtherRooms (ArrayList<String> otherRooms) {
        this.otherRooms = otherRooms;
    }


}
