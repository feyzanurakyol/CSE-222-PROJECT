package com.Group1;
public class Inmate implements Comparable<Inmate> {

    private int id;
    private String fullName;
    private CrimeType crimeType;
    private int remainingDay;
    private int wardNo;
    private HealthStatus healthStatus;

    public Inmate (int id,String name, CrimeType crimeType, int remainingDay, int wardNo, HealthStatus healthStatus) {
        //give id programmatically here.
        this.fullName = name;
        this.crimeType = crimeType;
        this.remainingDay = remainingDay;
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
        this.id = id;

    }
    //this constructor is used to search an Inmate.
    public Inmate(int id){
        this(id,"No info",CrimeType.INFRACTION,  0,0,new HealthStatus ());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
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
                ", name='" + fullName + '\'' +
                ", crimeType='" + crimeType + '\'' +
                ", remainingDay=" + remainingDay +
                ", wardNo=" + wardNo +
                '}';
    }
    @Override
    public int compareTo (Inmate o) {
        if (this.id == o.id )
            return 0;
        else if (this.id < o.id)
            return -1;
        else
            return 1;
    }
}
