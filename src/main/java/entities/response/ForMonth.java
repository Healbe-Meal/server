package entities.response;

import java.util.*;

public class ForMonth {
    Map<String, ArrayList<Element>> resultByMonth = new HashMap<>();

    public Map<String, ArrayList<Element>> getResultByMonth() {
        return resultByMonth;
    }

    public void setResultByMonth(Map<String, ArrayList<Element>> resultByMonth) {
        this.resultByMonth = resultByMonth;
    }

    public void addElem(String month, ResultElem elem) {
        resultByMonth.put(month, elem.getElements());
    }
}
