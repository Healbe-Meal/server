package entities.elements;

public class FullSummaryElem {
    String dt;
    Double pt_in;
    Double fat_in;
    Double cbh_in;

    public Double getFat_in() {
        return fat_in;
    }

    public void setFat_in(Double fat_in) {
        this.fat_in = fat_in;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Double getPt_in() {
        return pt_in;
    }

    public void setPt_in(Double pt_in) {
        this.pt_in = pt_in;
    }


    public Double getCbh_in() {
        return cbh_in;
    }

    public void setCbh_in(Double cbh_in) {
        this.cbh_in = cbh_in;
    }
}
