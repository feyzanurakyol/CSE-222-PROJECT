
public class Inmate implements Comparable<Inmate> {
    /**
     *Inmate's unique id number
     */
    private int id;
    /**
     *Inmate's name
     */
    private String name;
    /**
     *Inmate's crime type
     */
    private CrimeType crimeType;
    /**
     *Number of days left in prison
     */
    private int remainingDay;
    /**
     *Ward in which inmate is placed
     */
    private int wardNo;
    /**
     *Health information on the inmate
     */
    private HealthStatus healthStatus;

    public Inmate (int id, String name, CrimeType crimeType, int remainingDay, int wardNo, HealthStatus healthStatus) {
        this.id = id;
        this.name = name;
        this.crimeType = crimeType;
        this.remainingDay = remainingDay;
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
    }
    /**
     *Id getter
     */
    public int getId() {
        return id;
    }
    /**
     *Id setter
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *Name getter
     */
    public String getName() {
        return name;
    }
    /**
     *Name setter
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *Crime type getter
     */
    public CrimeType getCrimeType() {
        return crimeType;
    }
    /**
     *Crime type setter
     */
    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }
    /**
     *Days left getter
     */
    public int getRemainingDay() {
        return remainingDay;
    }
    /**
     *Days left setter
     */
    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }
    /**
     *Ward Number getter
     */
    public int getWardNo() {
        return wardNo;
    }
    /**
     *Ward number setter
     */
    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }
    /**
     *Health status getter
     */
    public HealthStatus getHealthStatus () {
        return healthStatus;
    }
    /**
     *Health status setter
     */
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

    /**
     *Compares two inmates with respect to their id
     */
    @Override
    public int compareTo (Inmate o) {
        //compare to ID
        return ((Integer)id).compareTo(o.id);
    }
}

