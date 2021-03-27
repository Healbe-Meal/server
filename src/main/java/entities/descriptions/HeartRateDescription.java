package entities.descriptions;

public class HeartRateDescription extends Description {
    Integer y;

    public HeartRateDescription(String x, Integer y) {
        super(x);
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
