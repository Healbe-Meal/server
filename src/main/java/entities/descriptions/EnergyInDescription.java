package entities.descriptions;

import entities.Description;

public class EnergyInDescription extends Description {
    private Double energyIn;
    private Integer pulse;

    public EnergyInDescription(String time, Double energyIn, Integer pulse) {
        super(time);
        this.energyIn = energyIn;
        this.pulse = pulse;
    }

    public Double getEnergyIn() {
        return energyIn;
    }

    public void setEnergyIn(Double energyIn) {
        this.energyIn = energyIn;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }
}
