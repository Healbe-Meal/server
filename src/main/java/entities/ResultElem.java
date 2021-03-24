package entities;

import java.util.ArrayList;

public class ResultElem {
    ArrayList<Element> elements = new ArrayList<>();

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public void addElem(Integer a, Double b, ArrayList<Description> c) {
        elements.add(new Element(a, b, c));
    }

    public void addElem(Integer a, Double b) {
        elements.add(new Element(a, b));
    }
}
