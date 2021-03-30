package entities.response;

public class StandartResult {
    double energyInStandart;
    String imt;
    String pulseStandart;

    public String getPulseStandart() {
        return pulseStandart;
    }

    public void setPulseStandart(String pulseStandart) {
        this.pulseStandart = pulseStandart;
    }

    public StandartResult(double energyInStandart, String imt) {
        this.energyInStandart = 2010.0;
        this.imt = imt;
        pulseStandart = "73-78";
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
