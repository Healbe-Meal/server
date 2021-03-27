package entities.response;

import entities.descriptions.Description;

import java.util.ArrayList;

public class Element {
    Integer x;
    Double y;
    ArrayList<Description> description;

    public Element(Integer x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Element(Integer x, Double y, ArrayList<Description> description) {
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public ArrayList<Description> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<Description> description) {
        this.description = description;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}

