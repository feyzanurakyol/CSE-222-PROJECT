package com.Group1;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cleaner
}
public class Personnel implements Comparable<Personnel> {
    protected String name;
    protected String surname;
    //ids are unique so give id automatically while inmate creating
    //customer can give information other than id.
    //give id programmatically and check whether unique or not.
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

    protected Personnel(String name, String surname,JobType job,HealthStatus healthStatus){
        this.name = name;
        this.surname = surname;
        //give id programmatically here and check whether unique or not.
        this.job=job;
        this.healthStatus =healthStatus;
    }
    //this constructor is used to search an Inmate.
    protected Personnel(int id){
        this("No info","No info",JobType.Jailer,new HealthStatus ());
        this.id=id;
    }
    // işe giriş yaptığında kayıt et
    protected void checkInTime(){    }

    // işten çıkış saati
    protected void checkOutTime(){    }

    @Override
    public int compareTo (Personnel o) {
        //compare according to ID
        return 0;
    }
}
