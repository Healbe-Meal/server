package entities.descriptions;

import entities.Description;

public class HeartRateDescription extends Description {
    Integer hearRate;

    public HeartRateDescription(String time, Integer hearRate) {
        super(time);
        this.hearRate = hearRate;
    }

    public Integer getHearRate() {
        return hearRate;
    }

    public void setHearRate(Integer hearRate) {
        this.hearRate = hearRate;
    }
}
