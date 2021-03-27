package entities.response;

import entities.descriptions.Description;
import entities.descriptions.EnergyInPFCDescription;

import java.util.ArrayList;

public class pfcElement extends Element {
    Double pt_in;
    Double wt_in;
    Double cbh_in;

    public pfcElement(Integer x, Double y, Double pt_in, Double wt_in, Double cbh_in) {
        super(x, y);
        this.pt_in = pt_in;
        this.wt_in = wt_in;
        this.cbh_in = cbh_in;
    }

    public pfcElement(Integer x, Double y, ArrayList<Description> description, Double pt_in, Double wt_in, Double cbh_in) {
        super(x, y, description);
        this.pt_in = pt_in;
        this.wt_in = wt_in;
        this.cbh_in = cbh_in;
    }

    public Double getPt_in() {
        return pt_in;
    }

    public void setPt_in(Double pt_in) {
        this.pt_in = pt_in;
    }

    public Double getWt_in() {
        return wt_in;
    }

    public void setWt_in(Double wt_in) {
        this.wt_in = wt_in;
    }

    public Double getCbh_in() {
        return cbh_in;
    }

    public void setCbh_in(Double cbh_in) {
        this.cbh_in = cbh_in;
    }
}
