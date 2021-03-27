package entities.descriptions;

public class EnergyOutDescription extends Description {
    private Double y;
    private Integer pulse;

    public EnergyOutDescription(String x, Double y, Integer pulse) {
        super(x);
        this.y = y;
        this.pulse = pulse;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }
}
