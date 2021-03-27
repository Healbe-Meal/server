package entities.descriptions;

public class StepsDescription  extends Description {
    Integer y;

    public StepsDescription(String x, Integer y) {
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
