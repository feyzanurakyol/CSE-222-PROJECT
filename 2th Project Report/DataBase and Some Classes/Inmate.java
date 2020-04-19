package com.Akif;
public class Inmate implements Comparable<Inmate> {
    private int id;
    private String name;
    private String crimeType;
    private int remainingDay;
    private int wardNo;
    private HealthStatus healthStatus;
    public Inmate (int id, String name, String crimeType, int remainingDay, int wardNo, HealthStatus healthStatus) {
        this.id = id;
        this.name = name;
        this.crimeType = crimeType;
        this.remainingDay = remainingDay;
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
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

    @Override
    public int compareTo (Inmate o) {
        //compare to ID
        return 0;
    }
}
