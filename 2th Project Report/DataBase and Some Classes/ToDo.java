package com.Akif;

// Job can be add or remove Inmate, according to the feedback of the governor to the secretary.
public class ToDo {
    private String job;
    private boolean isDone;
    private int ownerID;

    public ToDo (String job, boolean isDone, int ownerID) {
        this.job = job;
        this.isDone = isDone;
        this.ownerID = ownerID;
    }

    public String getJob () {
        return job;
    }

    public void setJob (String job) {
        this.job = job;
    }

    public boolean isDone () {
        return isDone;
    }

    public void setDone (boolean done) {
        isDone = done;
    }

    public int getOwnerID () {
        return ownerID;
    }

    public void setOwnerID (int ownerID) {
        this.ownerID = ownerID;
    }
}
