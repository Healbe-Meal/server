package entities.descriptions;

public class EnergyInPFCDescription extends Description{
    Double proteinIn;
    Double cbhIn;
    Double fatIn;

    public EnergyInPFCDescription(String x, Double proteinIn, Double cbhIn, Double fatIn) {
        super(x);
        this.proteinIn = proteinIn;
        this.cbhIn = cbhIn;
        this.fatIn = fatIn;
    }

    public Double getProteinIn() {
        return proteinIn;
    }

    public void setProteinIn(Double proteinIn) {
        this.proteinIn = proteinIn;
    }

    public Double getCbhIn() {
        return cbhIn;
    }

    public void setCbhIn(Double cbhIn) {
        this.cbhIn = cbhIn;
    }

    public Double getFatIn() {
        return fatIn;
    }

    public void setFatIn(Double fatIn) {
        this.fatIn = fatIn;
    }
}
