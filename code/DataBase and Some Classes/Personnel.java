package com.Akif;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cleaner
}
public abstract class Personnel implements Comparable<Personnel> {
    protected String name;
    protected String surname;
    protected int id;
    protected JobType job;
    protected HealthStatus healthStatus;
    //mesai saati
    private shiftLinkedList shift;

    private static class shiftLinkedList{
        protected String day;
        protected String checkIn;
        protected String checkOut;
    }

    protected Personnel(String name, String surname, int id,JobType job,HealthStatus healthStatus){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.job=job;
        this.healthStatus =healthStatus;
    }

    // işe giriş yaptığında kayıt et
    protected void checkInTime(){    }

    // işten çıkış saati
    protected void checkOutTime(){    }

    public abstract void personnelInterface();

    @Override
    public int compareTo (Personnel o) {
        //compare according to ID
        return 0;
    }
}
