package OtherPersonnel;
public class Inmate implements Comparable<Inmate> {
    //ids are unique so give id automatically while inmate creating
    //customer can give information other than id.
    //give id programmatically and check whether unique or not.
    private int id;
    private String name;
    private String crimeType;
    private int remainingDay;
    private int wardNo;
    private HealthStatus healthStatus;

    public Inmate (String name, String crimeType, int remainingDay, int wardNo, HealthStatus healthStatus) {
        //give id programmatically here.
        this.name = name;
        this.crimeType = crimeType;
        this.remainingDay = remainingDay;
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
    }
    //this constructor is used to search an Inmate.
    public Inmate(int id){
        this("No info","No info",0,0,new HealthStatus ());
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public int getRemainingDay() {
        return remainingDay;
    }

    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }

    public HealthStatus getHealthStatus () {
        return healthStatus;
    }

    public void setHealthStatus (HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Inmate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crimeType='" + crimeType + '\'' +
                ", remainingDay=" + remainingDay +
                ", wardNo=" + wardNo +
                '}';
    }
    //compare the inmates according to their id
    //ids are unique
    @Override
    public int compareTo (Inmate o) {
        //compare to inmate ID
        return 0;
    }
}
