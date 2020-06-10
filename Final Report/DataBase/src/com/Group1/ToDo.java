package com.Group1;

import java.util.Date;

// Job can be add or remove Inmate, according to the feedback of the governor to the secretary.
public class ToDo {
    private String job;
    private boolean isDone;
    private Personnel personnelGroup;

    public ToDo (String job, int ownerID,DataBase dataBase) {
        this.job = job;
        this.isDone = false;
        dataBase.addToDoToTheTop (this);
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


    @Override
    public String toString () {
        return "ToDo{" +
                "job='" + job + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
