package service;


import Parse.*;
import Parse.HeartRate.EnergyInDescription;
import Parse.HeartRate.EnergyOutDescription;
import Parse.HeartRate.HeartRateDescription;
import Parse.HeartRate.StepsDescription;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Service {
    private double energyBurned = 0;
    private double energyIntake = 0;
    private double proteinIntake = 0;
    private double fatIntake = 0;
    private double cbhIntake = 0;
    private int steps = 0;
    private double minHeartRate = 1000;
    private double maxHeartRate = -1;
    private double avgHeartRate = 0;
    private double count = 0;

    private Integer prevDateDay = 0;
    private String prevTime = "";
    private String prevDateMonth = "";
    private SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
    private SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
    private ArrayList<Map> weightJSON = new ArrayList<>();
    ResultElem energyConsumedForDay = new ResultElem();
    ResultElem energyBurnedForDay = new ResultElem();
    ResultElem stepsForDay = new ResultElem();
    ResultElem heartRateForDay = new ResultElem();
    private ForMonth energyIntakeForMonth = new ForMonth();
    private ForMonth energyBurnedForMonth = new ForMonth();
    private ForMonth stepsForMonth = new ForMonth();
    private ForMonth heartRateForMonth = new ForMonth();
    private Result result = new Result();
    private ArrayList<Description> energyInDescription = new ArrayList<>();
    private ArrayList<Description> energyOutDescription = new ArrayList<>();
    private ArrayList<Description> stepsDescription = new ArrayList<>();
    private ArrayList<Description> heartRateDescription = new ArrayList<>();



    //Map<String, Double> energyConsumedForDay = new HashMap<>();




    public Result getFinalJSON(Inf inf) throws IOException, ParseException {
        parseShortSummary(inf.getShort_summary());
        //getJSONFromWeight(inf.getWeight());


        result.setEnergyIn(energyIntakeForMonth.getResultByMonth());
        result.setHeartRate(energyIntakeForMonth.getResultByMonth());
        result.setEnergyOut(stepsForMonth.getResultByMonth());
        result.setSteps(heartRateForMonth.getResultByMonth());

//        //map.put("weight", weightJSON);

        return result;
    }

    public void parseShortSummary(List<ShortSummaryElem> shortSummary) throws java.text.ParseException {
        int length = shortSummary.size();
        for (int i = 0; i < length; i++) {
            Double energy_in = shortSummary.get(i).getEnergy_in();
            Double energy_out = shortSummary.get(i).getEnergy_out();
            Integer heart_rate = shortSummary.get(i).getHeart_rate();
            String stringDate = shortSummary.get(i).getAdd_date();

            Date date = dateFormatter.parse(stringDate);
            String time = stringDate.split(" ")[1];
            Integer day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);

            if (!prevTime.equals(time)) {
                if (energy_in != 0) {
                    energyInDescription.add(new EnergyInDescription(time, energy_in, heart_rate));
                }

                if (energy_out != 0) {
                    energyOutDescription.add(new EnergyOutDescription(time, energy_out, heart_rate));
                }

                if (steps != 0) {
                    stepsDescription.add(new StepsDescription(time, steps));
                }

                if (heart_rate != 0) {
                    heartRateDescription.add(new HeartRateDescription(time, heart_rate));
                }
            }

            if ((!day.equals(prevDateDay) && prevDateDay != 0) || i == length - 1) {
                avgHeartRate /= count;

                energyConsumedForDay.addElem(prevDateDay, energyIntake, energyInDescription);

                energyBurnedForDay.addElem(prevDateDay, energyBurned, energyOutDescription);

                stepsForDay.addElem(prevDateDay, (double) steps, stepsDescription);

                heartRateForDay.addElem(prevDateDay, avgHeartRate, heartRateDescription);

                if (!month.equals(prevDateMonth) || i == (length - 1)) {
                    energyIntakeForMonth.addElem(prevDateMonth, energyConsumedForDay);
                    energyBurnedForMonth.addElem(prevDateMonth, energyBurnedForDay);
                    stepsForMonth.addElem(prevDateMonth, stepsForDay);
                    heartRateForMonth.addElem(prevDateMonth, heartRateForDay);

                    resetValues();
                }

                energyIntake = 0;
                energyBurned = 0;
                avgHeartRate = 0;
                steps = 0;
                count = 0;
            }

            steps += shortSummary.get(i).getSteps();
            energyIntake += energy_in;
            energyBurned += energy_out;
            avgHeartRate += heart_rate;

            if (heart_rate != 0) {
                count++;
            }

            if (heart_rate > maxHeartRate) {
                maxHeartRate = heart_rate;
            } else if (heart_rate < minHeartRate) {
                minHeartRate = heart_rate;
            }

            prevDateDay = day;
            prevDateMonth = month;
            prevTime = time;
        }

    }

    public void parseFullSummary(List<FullSummaryElem> fullSummary) throws java.text.ParseException {
        int length = fullSummary.size();
        for (int i = 0; i < length; i++) {
            Double proteinIn = fullSummary.get(i).getPt_in();
            Double cbhIn = fullSummary.get(i).getCbh_in();
            Double fatIn = fullSummary.get(i).getWt_in();

            proteinIntake += proteinIn;
            cbhIntake += cbhIntake;
            fatIntake += fatIn;

            String stringDate = fullSummary.get(i).getDt();

            Date date = dateFormatter.parse(stringDate);
            String time = stringDate.split(" ")[1];
            Integer day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);
        }
    }

    private void resetValues() {
        energyConsumedForDay = new ResultElem();
        energyBurnedForDay = new ResultElem();
        stepsForDay = new ResultElem();
        heartRateForDay = new ResultElem();
    }
    
    public void getJSONFromWeight(List<WeightElem> weights) throws ParseException {
        dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");

        int length = weights.size();
        prevDateDay = 0;

        for (int i = 0; i < length; i++) {
            double weight = weights.get(i).getWeight();
            String stringDate = weights.get(i).getAdd_time();
            Date date = dateFormatter.parse(stringDate);
            int day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);

            if ((day != prevDateDay && prevDateDay != 0) || i == length - 1) {
                if (prevDateDay == 0) {
                    prevDateDay = day;
                }
                Map<String, Double> weightForMonth = new HashMap<>();
               //weightForMonth.put(prevDateDay, weight);

                HashMap<Integer, Map> forMonth = new HashMap<>();

                forMonth.put(Integer.valueOf(month), weightForMonth);
                weightJSON.add(forMonth);
            }
            prevDateDay = day;
        }

    }

}
