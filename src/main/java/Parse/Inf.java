package Parse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inf {
    private List<ShortSummaryElem> short_summary = new ArrayList<>();
    private List<WeightElem> weight = new ArrayList<>();
    private List<FullSummaryElem> full_summary = new ArrayList<>();

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
