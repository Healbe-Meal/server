package entities.response;

import java.util.*;

public class Result {
    Map<String, ArrayList<Element>> energyIn;
    Map<String, ArrayList<Element>>  energyOut;
    Map<String, ArrayList<Element>>  heartRate;
    Map<String, ArrayList<Element>>  steps ;
    Map<String, ArrayList<Element>>  weight;
    UserInfo user;
    StandartResult standartResult;
    Map<String, ArrayList<Element>>  pfcInfo;

    public Map<String, ArrayList<Element>> getPfcInfo() {
        return pfcInfo;
    }

    public void setPfcInfo(Map<String, ArrayList<Element>> pfcInfo) {
        this.pfcInfo = pfcInfo;
    }

    public StandartResult getStandartResult() {
        return standartResult;
    }

    public void setStandartResult(StandartResult standartResult) {
        this.standartResult = standartResult;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Map<String, ArrayList<Element>> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, ArrayList<Element>> weight) {
        this.weight = weight;
    }

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
