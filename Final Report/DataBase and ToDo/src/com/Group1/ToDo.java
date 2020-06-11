package com.Group1;

import java.util.Date;

// Job can be add or remove Inmate, according to the feedback of the governor to the secretary.
public class ToDo implements Comparable<ToDo>{
    private String job;
    private int ownerID;
    private int importanceOrder;

    /**
     * Create a ToDo by giving parameters.
     * @param job description of the job to be done.
     * @param ownerID personnel id of job
     * @param toDoSize toDo size from database class.
     */
    public ToDo (String job, int ownerID,int toDoSize) {
        this.job = job;
        this.ownerID = ownerID;
        this.importanceOrder = toDoSize+1;//importance order will be given according to size;
    }
    public String getJob () {
        return job;
    }
    public void setJob (String job) {
        this.job = job;
    }

    public int getOwnerID () {
        return ownerID;
    }

    public void setOwnerID (int ownerID) {
        this.ownerID = ownerID;
    }

    public int getImportanceOrder () {
        return importanceOrder;
    }

    public void setImportanceOrder (int importanceOrder) {
        this.importanceOrder = importanceOrder;
    }

    @Override
    public String toString () {
        return "ToDo{" +
                "job='" + job + '\'' +
                ", ownerID=" + ownerID +
                ", importanceOrder=" + importanceOrder +
                '}';
    }

    //compare according to importance order.
    @Override
    public int compareTo (ToDo o) {
        if (this.importanceOrder > o.importanceOrder)
            return 1;
        else if (this.importanceOrder == o.importanceOrder)
            return 0;
        else
            return -1;
    }
}
