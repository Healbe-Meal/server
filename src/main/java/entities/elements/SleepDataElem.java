package entities.elements;

public class SleepDataElem {
    String dt;
    Integer total_time_in_bed;
    Integer sleep_quality;

    public Integer getSleep_quality() {
        return sleep_quality;
    }

    public void setSleep_quality(Integer sleep_quality) {
        this.sleep_quality = sleep_quality;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Integer getTotal_time_in_bed() {
        return total_time_in_bed;
    }

    public void setTotal_time_in_bed(Integer total_time_in_bed) {
        this.total_time_in_bed = total_time_in_bed;
    }
}
