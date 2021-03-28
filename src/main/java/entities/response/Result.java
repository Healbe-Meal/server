package entities.response;

import java.util.*;

public class Result {
    ForMonth energyIn;
    ForMonth energyOut;
    ForMonth heartRate;
    ForMonth steps ;
    ForMonth weight;
    UserInfo user;
    StandartResult standartResult;
    ForMonth pfcInfo;

    public ForMonth getEnergyIn() {
        return energyIn;
    }

    public void setEnergyIn(ForMonth energyIn) {
        this.energyIn = energyIn;
    }

    public ForMonth getEnergyOut() {
        return energyOut;
    }

    public void setEnergyOut(ForMonth energyOut) {
        this.energyOut = energyOut;
    }

    public ForMonth getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(ForMonth heartRate) {
        this.heartRate = heartRate;
    }

    public ForMonth getSteps() {
        return steps;
    }

    public void setSteps(ForMonth steps) {
        this.steps = steps;
    }

    public ForMonth getWeight() {
        return weight;
    }

    public void setWeight(ForMonth weight) {
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

    public ForMonth getPfcInfo() {
        return pfcInfo;
    }

    public void setPfcInfo(ForMonth pfcInfo) {
        this.pfcInfo = pfcInfo;
    }
}
