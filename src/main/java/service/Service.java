package service;


import entities.*;
import entities.descriptions.*;
import entities.elements.*;
import entities.response.*;

import javax.sound.midi.Soundbank;
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
    private Integer maxSleepTime = 0;

    private Integer prevDateDay = 0;
    private String prevTime = "";
    private String prevDateMonth = "";
    private Integer prevSleepTime = 0;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
    private SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
    private ArrayList<Map> weightJSON = new ArrayList<>();
    ResultElem energyConsumedForDay = new ResultElem();
    ResultElem energyBurnedForDay = new ResultElem();
    ResultElem stepsForDay = new ResultElem();
    ResultElem heartRateForDay = new ResultElem();
    ResultElem sleepTimeForDay = new ResultElem();
    ResultElem weightForDay = new ResultElem();
    ResultElem pfcForDay = new ResultElem();
    private ForMonth energyIntakeForMonth = new ForMonth();
    private ForMonth energyBurnedForMonth = new ForMonth();
    private ForMonth stepsForMonth = new ForMonth();
    private ForMonth heartRateForMonth = new ForMonth();
    private ForMonth sleepTimeForMonth = new ForMonth();
    private ForMonth weightForMonth = new ForMonth();
    private ForMonth pfcForMonth = new ForMonth();
    private Result result = new Result();
    private ArrayList<Description> energyInDescription = new ArrayList<>();
    private ArrayList<Description> energyOutDescription = new ArrayList<>();
    private ArrayList<Description> stepsDescription = new ArrayList<>();
    private ArrayList<Description> heartRateDescription = new ArrayList<>();
    private ArrayList<Description> pfcDescription = new ArrayList<>();
    private UserInfo userInfo;
    private StandartResult standartResult;
    private Standard standart = new Standard();
    private int userWeight;
    private int userHeight;
    private boolean userSex;
    private int userAge;

    public Result getFinalJSON(Inf inf) throws IOException, ParseException {
        System.out.println("Hello");

        parseShortSummary(inf.getShort_summary());
        parseFullSummary(inf.getFull_summary());
        //parseSleepData(inf.getSleep_data());
        parseWeight(inf.getWeight());
        parseUserInfo(inf.getUser());

        result.setEnergyIn(energyConsumedForDay.getElements());
        result.setHeartRate(heartRateForDay.getElements());
        result.setEnergyOut(energyBurnedForDay.getElements());
        result.setSteps(stepsForDay.getElements());
        result.setUser(userInfo);
        result.setPfcInfo(pfcForDay.getElements());
        standartResult = new StandartResult(standart.countEnergyInStandart(userWeight, userAge, userSex), standart.countIMT(userWeight, userHeight));
        result.setStandartResult(standartResult);
        result.setWeight(weightForDay.getElements());

        return result;
    }

    public void parseShortSummary(List<ShortSummaryElem> shortSummary) throws java.text.ParseException {
        Collections.sort(shortSummary);
        String prevHour = "";
        Double energyInForHour = 0.0;
        Double energyOutForHour = 0.0;
        Integer stepsForHour = 0;
        int length = shortSummary.size();
        for (int i = 0; i < length; i++) {
            Double energy_in = shortSummary.get(i).getEnergy_in();
            Double energy_out = shortSummary.get(i).getEnergy_out();
            Integer heart_rate = shortSummary.get(i).getHeart_rate();
            Integer stepsIn = shortSummary.get(i).getSteps();

            String stringDate = shortSummary.get(i).getAdd_date();

            Date date = dateFormatter.parse(stringDate);
            String time = stringDate.split(" ")[1];
            Integer day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);

            System.out.println(stringDate);

            if (!prevTime.equals(time)) {
                String currentHour = time.substring(0, 2);
                if (!currentHour.equals(prevHour) && !prevHour.equals("")) {
                    energyInDescription.add(new EnergyInDescription(prevHour, energyInForHour, heart_rate));

                    energyOutDescription.add(new EnergyOutDescription(prevHour, energyOutForHour, heart_rate));

                    stepsDescription.add(new StepsDescription(prevHour, stepsForHour));

                    heartRateDescription.add(new HeartRateDescription(prevHour, heart_rate));

                    energyInForHour = 0.0;
                    energyOutForHour = 0.0;
                    stepsForHour = 0;
                }

                prevHour = currentHour;
            }

            energyInForHour += energy_in;
            energyOutForHour += energy_out;
            stepsForHour += stepsIn;

            if ((!day.equals(prevDateDay) && prevDateDay != 0) || i == length - 1) {
                avgHeartRate /= count;

                energyConsumedForDay.addElem(prevDateDay, energyIntake, energyInDescription);

                energyBurnedForDay.addElem(prevDateDay, energyBurned, energyOutDescription);

                stepsForDay.addElem(prevDateDay, (double) steps, stepsDescription);

                heartRateForDay.addElem(prevDateDay, (double) Math.round(avgHeartRate), heartRateDescription);

                resetDescriptions();

                if (!month.equals(prevDateMonth) || i == (length - 1)) {
                    energyIntakeForMonth.addElem(prevDateMonth, energyConsumedForDay);
                    energyBurnedForMonth.addElem(prevDateMonth, energyBurnedForDay);
                    stepsForMonth.addElem(prevDateMonth, stepsForDay);
                    heartRateForMonth.addElem(prevDateMonth, heartRateForDay);
                    break;
                    //resetValues();
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

    public int getDay(String dt) {
        Date reference = null;
        Date time = null;
        String testTime = dt.split(" ")[1];

        try {
            reference = timeFormatter.parse("00:00:00");
            time = timeFormatter.parse(testTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        long seconds = (time.getTime() - reference.getTime()) / 1000L;

        Date date = null;
        try {
            date = dateFormatter.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int month = Integer.parseInt(monthFormatter.format(date));

        return Integer.parseInt(dayFormatter.format(date)) + (month * 30) + (int) seconds;
    }

    public void parseFullSummary(List<FullSummaryElem> fullSummary) throws java.text.ParseException {
        Collections.sort(fullSummary, Comparator.comparingInt(a -> getDay(a.getDt())));
        int length = fullSummary.size();
        prevDateDay = 0;
        prevDateMonth = "";
        for (int i = 0; i < length; i++) {
            Double proteinIn = fullSummary.get(i).getPt_in();
            Double cbhIn = fullSummary.get(i).getCbh_in();
            Double fatIn = fullSummary.get(i).getFat_in();

            String stringDate = fullSummary.get(i).getDt();
            Date date = dateFormatter.parse(stringDate);
            String time = stringDate.split(" ")[1];
            Integer day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);

            if (proteinIn > proteinIntake) {
                proteinIntake = proteinIn;
            }

            if (cbhIn > cbhIntake) {
                cbhIntake = cbhIn;
            }

            if (fatIn > fatIntake) {
                fatIntake += fatIn;
            }

            if ((!day.equals(prevDateDay) && prevDateDay != 0) || i == length - 1) {
                pfcForDay.addElem(new pfcElement(prevDateDay, -1.0, proteinIntake, fatIntake, cbhIntake));

                if (!month.equals(prevDateMonth) || i == (length - 1)) {
                    pfcForMonth.addElem(prevDateMonth, pfcForDay);
                    //pfcForDay = new ResultElem();

                    break;
                }

            }

            prevDateDay = day;
            prevDateMonth = month;

        }
    }

    public void parseSleepData(List<SleepDataElem> sleepData) throws java.text.ParseException {
        int length = sleepData.size();
        for (int i = 0; i < length; i++) {
            Integer timeInBed = sleepData.get(i).getTotal_time_in_bed();
            Integer sleep_quality = sleepData.get(i).getSleep_quality();

            String stringDate = sleepData.get(i).getDt();

            Date date = dateFormatter.parse(stringDate);
            String time = stringDate.split(" ")[1];
            Integer day = Integer.parseInt(dayFormatter.format(date));
            String month = monthFormatter.format(date);

            if (sleep_quality != 0 || i == length - 1) {
                sleepTimeForDay.addElem(day - 1, (double) maxSleepTime);

                if (!prevDateMonth.equals(month) || i == length - 1) {
                    sleepTimeForMonth.addElem(prevDateMonth, sleepTimeForDay);

                    sleepTimeForDay = new ResultElem();
                }

                maxSleepTime = 0;
            }

            if (maxSleepTime < timeInBed) {
                maxSleepTime = timeInBed;
            }

            prevDateDay = day;
            prevDateMonth = month;
            prevSleepTime = timeInBed;
        }
    }

    private void resetDescriptions() {
        energyInDescription = new ArrayList<>();
        energyOutDescription = new ArrayList<>();
        stepsDescription = new ArrayList<>();
        heartRateDescription = new ArrayList<>();
        pfcDescription = new ArrayList<>();
    }


    private void resetValues() {
        energyConsumedForDay = new ResultElem();
        energyBurnedForDay = new ResultElem();
        stepsForDay = new ResultElem();
        heartRateForDay = new ResultElem();
    }

    public void parseWeight(List<WeightElem> weights) throws ParseException {
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

                weightForDay.addElem(prevDateDay, weight);

                if (!prevDateMonth.equals(month) || i == length - 1) {
                    weightForMonth.addElem(prevDateMonth, weightForDay);

                   //weightForDay = new ResultElem();

                    break;
                }

            }

            userWeight = (int) weight;

            prevDateDay = day;
            prevDateMonth = month;
        }

    }

    public void parseUserInfo(List<UserElement> inf) {

        int length = inf.size();
        for (int i = 0; i < length; i++) {
            int height = inf.get(i).getUserHeight();
            Integer birthdayDay = inf.get(i).getUserBirthdayDay();
            Integer birthdayMonth = inf.get(i).getUserBirthdayMonth();
            Integer birthdayYear = inf.get(i).getUserBirthdayYear();
            Integer stepLength = inf.get(i).getUserStepLength();
            boolean sex = inf.get(i).getUserSex();

            //userHeight = Integer.parseInt(height);

//            if (sex.equals("false")) {
//                userSex = false;
//            } else {
//                userSex = true;
//            }


            userInfo = new UserInfo(height, birthdayDay, birthdayMonth, birthdayYear, stepLength, sex);
        }
    }

}
