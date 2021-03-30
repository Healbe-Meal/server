package entities.response;

import java.util.*;

public class Result {
    ArrayList<Element> energyIn;
    ArrayList<Element> energyOut;
    ArrayList<Element> heartRate;
    ArrayList<Element> steps ;
    ArrayList<Element> weight;
    UserInfo user;
    StandartResult standartResult;
    ArrayList<Element> pfcInfo;

    public ArrayList<Element> getEnergyIn() {
        return energyIn;
    }

    public void setEnergyIn(ArrayList<Element> energyIn) {
        this.energyIn = energyIn;
    }

    public ArrayList<Element> getEnergyOut() {
        return energyOut;
    }

    public void setEnergyOut(ArrayList<Element> energyOut) {
        this.energyOut = energyOut;
    }

    public ArrayList<Element> getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(ArrayList<Element> heartRate) {
        this.heartRate = heartRate;
    }

    public ArrayList<Element> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Element> steps) {
        this.steps = steps;
    }

    public ArrayList<Element> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<Element> weight) {
        this.weight = weight;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public StandartResult getStandartResult() {
        return standartResult;
    }

    public void setStandartResult(StandartResult standartResult) {
        this.standartResult = standartResult;
    }

    public ArrayList<Element> getPfcInfo() {
        return pfcInfo;
    }

    public void setPfcInfo(ArrayList<Element> pfcInfo) {
        this.pfcInfo = pfcInfo;
    }
}
