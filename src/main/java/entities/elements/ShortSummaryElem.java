package entities.elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ShortSummaryElem implements Comparable<ShortSummaryElem> {
    Double energy_in;
    Double energy_out;
    Integer heart_rate;
    String add_date;
    Integer steps;
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public int compareTo(ShortSummaryElem o) {

        try {
            return dateFormatter.parse(getAdd_date()).compareTo(dateFormatter.parse(o.getAdd_date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
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
