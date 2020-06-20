package com.Group1;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cleaner,
    Cook,
    Undefined
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
    private PersonnelShift shift;

     public Personnel(int id){
        this(id, "NoInfo", "NoInfo", "", JobType.Undefined, new HealthStatus(), new PersonnelShift());
    }

    public Personnel(int id , String password){
        this(id, "Noinfo", "Noinfo", password, JobType.Undefined, new HealthStatus (), new PersonnelShift());
    }

    public Personnel(int id,String name, String surname, String password, JobType job){
        this(id, name, surname, password, job, new HealthStatus(), new PersonnelShift());
    }

    public Personnel(int id, String name, String surname, String password, JobType job, HealthStatus health, PersonnelShift shift) {
         this.name = name;
         this.surname = surname;
         this.id = id;
         this.job = job;
         healthStatus = health;
         this.password = Encryption.encryptPassword(password);
         this.shift = shift;
    }

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
