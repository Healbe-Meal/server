package entities;

import java.util.*;

public class Result {
    Map<String, ArrayList<Element>> energyIn = new HashMap<>();
    Map<String, ArrayList<Element>>  energyOut = new HashMap<>();
    Map<String, ArrayList<Element>>  heartRate = new HashMap<>();
    Map<String, ArrayList<Element>>  steps = new HashMap<>();

    public Map<String, ArrayList<Element>> getEnergyIn() {
        return energyIn;
    }

    public void setEnergyIn(Map<String, ArrayList<Element>> energyIn) {
        this.energyIn = energyIn;
    }

    public Map<String, ArrayList<Element>> getEnergyOut() {
        return energyOut;
    }

    public void setEnergyOut(Map<String, ArrayList<Element>> energyOut) {
        this.energyOut = energyOut;
    }

    public Map<String, ArrayList<Element>> getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Map<String, ArrayList<Element>> heartRate) {
        this.heartRate = heartRate;
    }

    public Map<String, ArrayList<Element>> getSteps() {
        return steps;
    }

    public void setSteps(Map<String, ArrayList<Element>> steps) {
        this.steps = steps;
    }
}
