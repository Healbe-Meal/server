package Parse;

public class ShortSummaryElem {
    private Long steps;
    private String add_date;
    private Double energy_in;
    private Double energy_out;
    private Integer heart_rate;

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

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

    public Long getSteps() {
        return steps;
    }

    public void setSteps(Long steps) {
        this.steps = steps;
    }
}
