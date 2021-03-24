package entities;

import entities.elements.FullSummaryElem;
import entities.elements.ShortSummaryElem;
import entities.elements.SleepDataElem;
import entities.elements.WeightElem;

import java.util.ArrayList;
import java.util.List;

public class Inf {
    private List<ShortSummaryElem> short_summary = new ArrayList<>();
    private List<WeightElem> weight = new ArrayList<>();
    private List<FullSummaryElem> full_summary = new ArrayList<>();
    private List<SleepDataElem> sleep_data = new ArrayList<>();

    public List<SleepDataElem> getSleep_data() {
        return sleep_data;
    }

    public void setSleep_data(List<SleepDataElem> sleep_data) {
        this.sleep_data = sleep_data;
    }

    public List<FullSummaryElem> getFull_summary() {
        return full_summary;
    }

    public void setFull_summary(List<FullSummaryElem> full_summary) {
        this.full_summary = full_summary;
    }

    public List<ShortSummaryElem> getShort_summary() {
        return short_summary;
    }

    public void setShort_summary(List<ShortSummaryElem> short_summary) {
        this.short_summary = short_summary;
    }

    public List<WeightElem> getWeight() {
        return weight;
    }

    public void setWeight(List<WeightElem> weight) {
        this.weight = weight;
    }

}
