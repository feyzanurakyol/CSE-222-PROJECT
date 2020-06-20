public class Inmate implements Comparable<Inmate> {
    //ids are unique so give id automatically while inmate creating
    //customer can give information other than id.
    //give id programmatically and check whether unique or not.
    private String id;
    private String name;
    private CrimeType crimeType;
    private int remainingDay;
    private int wardNo;
    private HealthStatus healthStatus;

    public Inmate (String name, CrimeType crimeType, String id, int remainingDay, int wardNo, HealthStatus healthStatus) {
        //give id programmatically here.
        this.name = name;
        this.crimeType = crimeType;
        this.remainingDay = remainingDay;
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
        this.id = id;

    }
    //this constructor is used to search an Inmate.
    public Inmate(String id){
        this("No info",CrimeType.INFRACTION, id, 0,0,new HealthStatus ());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
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
        return id.compareTo(o.id);
    }
}
