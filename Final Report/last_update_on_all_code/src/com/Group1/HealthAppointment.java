package com.Group1;

import java.util.Date;

public class HealthAppointment implements Comparable<HealthAppointment> {
    private int apID;
    private String date;
    private int ownerID;
    private String explanation;

    public HealthAppointment (int id,String date, int ownerID, String explanation) {
        this.date = date;
        this.ownerID = ownerID;
        this.explanation = explanation;
        apID = id;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public int getApID () {
        return apID;
    }

    public void setApID (int apID) {
        this.apID = apID;
    }

    public int getOwnerID () {
        return ownerID;
    }

    public void setOwnerID (int ownerID) {
        this.ownerID = ownerID;
    }

    public String getExplanation () {
        return explanation;
    }

    public void setExplanation (String explanation) {
        this.explanation = explanation;
    }
    @Override
    public String toString () {
        return "HealthAppointment{" +
                "date=" + date +
                ", ownerID=" + ownerID +
                ", explanation='" + explanation + '\'' +
                '}';
    }
    //this method will be used in PriorityQueue.
    @Override
    public int compareTo (HealthAppointment o) {
        return 0;
    }
}
