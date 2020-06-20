package com.Group1;

import java.util.Date;

public class HealthAppointment implements Comparable<HealthAppointment> {
    private int apID;
    private Date date;
    private String ownerID;
    private String explanation;
    private HealthStatus healthStatus;


    public HealthAppointment (Date date, String ownerID, String explanation, int apID, HealthStatus healthStatus) {
        this.date = date;
        this.ownerID = ownerID;
        this.explanation = explanation;
        this.apID = apID;
        this.healthStatus = healthStatus;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }
    public int getApID () {
        return apID;
    }

    public void setApID (int apID) {
        this.apID = apID;
    }

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public String getOwnerID () {
        return ownerID;
    }

    public void setOwnerID (String ownerID) {
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
