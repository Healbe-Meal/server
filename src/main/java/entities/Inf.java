package entities;

import entities.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Inf {
    private ArrayList<ShortSummaryElem> short_summary;
    private ArrayList<WeightElem> weight;
    private ArrayList<FullSummaryElem> full_summary;
    private ArrayList<SleepDataElem> sleep_data;
    private ArrayList<UserElement> user;

    public ArrayList<ShortSummaryElem> getShort_summary() {
        return short_summary;
    }

    public void setShort_summary(ArrayList<ShortSummaryElem> short_summary) {
        this.short_summary = short_summary;
    }

    public ArrayList<WeightElem> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<WeightElem> weight) {
        this.weight = weight;
    }

    public ArrayList<FullSummaryElem> getFull_summary() {
        return full_summary;
    }

    public void setFull_summary(ArrayList<FullSummaryElem> full_summary) {
        this.full_summary = full_summary;
    }

    public ArrayList<SleepDataElem> getSleep_data() {
        return sleep_data;
    }

    public void setSleep_data(ArrayList<SleepDataElem> sleep_data) {
        this.sleep_data = sleep_data;
    }

    public ArrayList<UserElement> getUser() {
        return user;
    }

    public void setUser(ArrayList<UserElement> user) {
        this.user = user;
    }
}
