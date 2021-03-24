package entities.descriptions;

import entities.Description;

public class StepsDescription  extends Description {
    Integer steps;

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public StepsDescription(String time, Integer steps) {
        super(time);
        this.steps = steps;
    }
}
