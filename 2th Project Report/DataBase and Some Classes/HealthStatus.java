package com.Akif;

import java.util.ArrayList;

public class HealthStatus {
    private ArrayList<HealthAppointment> healthAppointments;
    private String bloodGroup;
    private String lastControlResult;
    private double length;
    private double weight;
    private double pulse;//nabız

    public HealthStatus (String bloodGroup, String lastControlResult, double length, double weight, double pulse) {
        this.bloodGroup = bloodGroup;
        this.lastControlResult = lastControlResult;
        this.length = length;
        this.weight = weight;
        this.pulse = pulse;
        healthAppointments = new ArrayList<> ();
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

    public double getLength () {
        return length;
    }

    public void setLength (double length) {
        this.length = length;
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

}
