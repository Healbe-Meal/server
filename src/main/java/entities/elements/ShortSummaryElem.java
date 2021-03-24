package entities.elements;

public class ShortSummaryElem {
    Double energy_in;
    Double energy_out;
    Integer heart_rate;
    String add_date;
    Integer steps;

    public Double getEnergy_in() {
        return energy_in;
    }

    public void setEnergy_in(Double energy_in) {
        this.energy_in = energy_in;
    }

    public Double getEnergy_out() {
        return energy_out;
    }

    public void setEnergy_out(Double energy_out) {
        this.energy_out = energy_out;
    }

    public Integer getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(Integer heart_rate) {
        this.heart_rate = heart_rate;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}
