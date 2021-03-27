package entities.response;

public class StandartResult {
    double energyInStandart;
    String imt;
    int pulseStandart;

    public int getPulseStandart() {
        return pulseStandart;
    }

    public void setPulseStandart(int pulseStandart) {
        this.pulseStandart = pulseStandart;
    }

    public StandartResult(double energyInStandart, String imt) {
        this.energyInStandart = energyInStandart;
        this.imt = imt;
    }

    public double getEnergyInStandart() {
        return energyInStandart;
    }

    public void setEnergyInStandart(double energyInStandart) {
        this.energyInStandart = energyInStandart;
    }

    public String getImt() {
        return imt;
    }

    public void setImt(String imt) {
        this.imt = imt;
    }
}
