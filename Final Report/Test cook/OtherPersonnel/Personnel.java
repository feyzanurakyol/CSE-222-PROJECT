package OtherPersonnel;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cleaner,
    Cook
}
public abstract class Personnel implements Comparable<Personnel> {
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
    private String password = "admin";

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
    protected Personnel(String name, String surname,JobType job){
        this.name = name;
        this.surname = surname;
        //give id programmatically here and check whether unique or not.
        // assign password random
        this.job=job;
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

    /**
     * for use every class show interface
     */
    public abstract void Interface();

    /**
     * In class asking to user his/her password and
     * control in system and return.
     * @param password user password
     * @return true if its matched
     */
    protected boolean checkPassword(String password){
            return this.password.equals(password);
    }
}
