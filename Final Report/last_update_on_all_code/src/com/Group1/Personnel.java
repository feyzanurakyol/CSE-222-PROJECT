package com.Group1;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cleaner,
    Cook
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
    protected String password;
    //mesai saati
    private shiftLinkedList shift;

    private static class shiftLinkedList{
        protected String day;
        protected String checkIn;
        protected String checkOut;
    }
    public Personnel(){

    }
    protected Personnel(int id,String name, String surname,JobType job,HealthStatus healthStatus){
        this.name = name;
        this.surname = surname;
        //give id programmatically here and check whether unique or not.
        this.job=job;
        this.healthStatus =healthStatus;
        this.id = id;
    }
    protected Personnel(int id , String password){
        this(-1,"Noinfo","Noinfo",JobType.Jailer,new HealthStatus ());
        this.id=id;
        this.password = password;
    }
    // işe giriş yaptığında kayıt et
    protected void checkInTime(){    }

    // işten çıkış saati
    protected void checkOutTime(){    }

    @Override
    public int compareTo (Personnel o) {
        if (this.id == o.id )
            return 0;
        else if (this.id < o.id)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString () {
        return "Personnel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", job=" + job +
                ", " + healthStatus +
                ", password='" + password + '\'' +
                '}';
    }
}
