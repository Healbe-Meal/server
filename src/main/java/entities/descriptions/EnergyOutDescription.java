package entities.descriptions;

import entities.Description;

public class EnergyOutDescription extends Description {
    private Double energyOut;
    private Integer pulse;

    public EnergyOutDescription(String time, Double energyOut, Integer pulse) {
        super(time);
        this.energyOut = energyOut;
        this.pulse = pulse;
    }

    public Double getEnergyOut() {
        return energyOut;
    }

    public void setEnergyOut(Double energyOut) {
        this.energyOut = energyOut;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }
}
