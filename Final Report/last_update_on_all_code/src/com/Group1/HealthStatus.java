package com.Group1;

import java.util.ArrayList;

public class HealthStatus {
    private ArrayList<HealthAppointment> healthAppointments;
    private String bloodGroup;
    private String lastControlResult;
    private double height;
    private double weight;
    private double pulse;//nabız
    private boolean hospitalized;
    public HealthStatus(){
        this("none", "none", 0,0,0, false);
    }
    public HealthStatus (String bloodGroup, String lastControlResult, double height, double weight, double pulse, boolean hospitalized) {
        this.bloodGroup = bloodGroup;
        this.lastControlResult = lastControlResult;
        this.height = height;
        this.weight = weight;
        this.pulse = pulse;
        healthAppointments = new ArrayList<> ();
        this.hospitalized = hospitalized;
    }

    public boolean isHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    public String getBloodGroup () {
        return bloodGroup;
    }

    public void setBloodGroup (String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getLastControlResult () {
        return lastControlResult;
    }

    public void setLastControlResult (String lastControlResult) {
        this.lastControlResult = lastControlResult;
    }

    public double getHeight () {
        return height;
    }

    public void setHeight (double length) {
        this.height= length;
    }

    public double getWeight () {
        return weight;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }

    public double getPulse () {
        return pulse;
    }

    public void setPulse (double pulse) {
        this.pulse = pulse;
    }

    public ArrayList<HealthAppointment> getHealthAppointments () {
        return healthAppointments;
    }

    public void setHealthAppointments (ArrayList<HealthAppointment> healthAppointments) {
        this.healthAppointments = healthAppointments;
    }
    @Override
    public String toString() {
        return "Inmate Information\n" +
                "\nLength = " + height + '\'' +
                "\nWeight = " + weight + '\'' +
                "\nBlood Group = " + bloodGroup +
                "\nPulse = " + pulse +
                "\nLast Report : " + lastControlResult;
    }

}

