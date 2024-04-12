package Util;

import Data.InformationType;
import Data.RefuelTank;
import Comparators.*;

import java.util.*;

public class StatisticsCalculator {

    public RefuelTank highestRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        RefuelTank HIGHEST;

        orderListByType(refuelTanks, wantedInformation);
        HIGHEST = refuelTanks.get(refuelTanks.size() - 1);

        return HIGHEST;
    }

    public RefuelTank lowestRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        int lowestNonZeroIndex = 0;
        RefuelTank LOWEST_NON_ZERO;

        orderListByType(refuelTanks, wantedInformation);
        while (refuelTanks.get(lowestNonZeroIndex).getType(wantedInformation) == 0) {
            lowestNonZeroIndex++;
        }
        LOWEST_NON_ZERO = refuelTanks.get(lowestNonZeroIndex);

        return LOWEST_NON_ZERO;
    }

    public ArrayList<RefuelTank> medianRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        ArrayList<RefuelTank> medianRefuelTanks = new ArrayList<>();

        orderListByType(refuelTanks, wantedInformation);
        RefuelTank STANDARD_MEDIAN = refuelTanks.get(refuelTanks.size() / 2);
        RefuelTank EVEN_SECONDARY_MEDIAN = refuelTanks.get((refuelTanks.size() / 2) - 1);

        medianRefuelTanks.add(STANDARD_MEDIAN);
        if (refuelTanks.size() % 2 == 0) {
            medianRefuelTanks.add(EVEN_SECONDARY_MEDIAN);
        }

        return medianRefuelTanks;
    }

    public ArrayList<Double> modeRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        HashMap<Double, Integer> frequencyTable;
        ArrayList<Double> MODE_VALUES;
        double STEP_SIZE;

        orderListByType(refuelTanks, wantedInformation);

        switch (wantedInformation) {
            case LITER_PRICE:
                STEP_SIZE = 0.5;
                break;
            case KILOMETERS_DRIVEN:
                STEP_SIZE = 10;
                break;
            default:
                STEP_SIZE = 1;
                break;
        }
        frequencyTable = calculateFrequencyByStep(refuelTanks, wantedInformation, STEP_SIZE);
        MODE_VALUES = findMostFrequent(frequencyTable);

        return MODE_VALUES;
    }

    public double averageRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        double total = 0.0;
        double AVERAGE_VALUE;

        for (RefuelTank refuelTank : refuelTanks) {
            double REFUEL_TANK_TYPE_VALUE = refuelTank.getType(wantedInformation);

            total += REFUEL_TANK_TYPE_VALUE;
        }
        AVERAGE_VALUE = total / refuelTanks.size();

        return AVERAGE_VALUE;
    }

    public double totalValueRefuleTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        double totalValue = 0.0;

        if (
                wantedInformation.equals(InformationType.LITER_PRICE) ||
                wantedInformation.equals(InformationType.KILOMETERS_PER_LITER) ||
                wantedInformation.equals(InformationType.REFUEL_NUMBER)
        )
            return Double.NEGATIVE_INFINITY;

        for (RefuelTank refuelTank : refuelTanks) {
            double REFUEL_TANK_TYPE_VALUE = refuelTank.getType(wantedInformation);

            totalValue += REFUEL_TANK_TYPE_VALUE;
        }

        return totalValue;
    }

    /**
     * this method calculates the population standard deviation using the formula: σ = √(Σ(x[i]-μ)^2/n)
     * <p>
     * the standard deviation represents how far apart numbers in a set are from each other
     * </p><p>
     * source: "Standard Deviation Formula, Statistics, Variance, Sample and Population Mean",
     * by: The Organic Chemistry Tutor (12 feb 2017),
     * YouTube : <a href="https://www.youtube.com/watch?v=deIQeQzPK08">...</a>
     *  <p/>
     *
     * @author David van der Veer
     * @return population standard deviation
     */
    public double populationStandardDeviationRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        double SAMPLE_MEAN = averageRefuelTank(refuelTanks,wantedInformation);
        double SET_SIZE = refuelTanks.size();
        double sumOfEntries = 0.0;
        double STANDARD_DEVIATION;

        for (RefuelTank refuelTank : refuelTanks) {
            double CURRENT_INDEX = refuelTank.getType(wantedInformation);
            double ENTRY = Math.pow((CURRENT_INDEX - SAMPLE_MEAN), 2);

            sumOfEntries += ENTRY;
        }
        STANDARD_DEVIATION = Math.sqrt(sumOfEntries/SET_SIZE);

        return STANDARD_DEVIATION;
    }

    /**
     * a simple method that calculates the population variance using the formula: σ^2 = Σ(x[i]-μ)^2/n.
     * <p>
     * this is slightly different from the sample variance (s^2 = Σ(x[i]-x̄)^2/n-1)
     * which takes into account the deviation created as a result of having a low sample size.
     * this however is fine as the current program wil only calculate the entire set of measurements.
     * the feature of calculating sample values might be added later if required.
     * </p><p>
     * regardless the variance represents how far numbers in a set are relative to the mean and is simply stated the
     * standard deviation squared.
     * </p><p>
     * source: "Standard Deviation Formula, Statistics, Variance, Sample and Population Mean",
     * by: The Organic Chemistry Tutor (12 feb 2017),
     * YouTube : <a href="https://www.youtube.com/watch?v=deIQeQzPK08">...</a>
     * </p>
     *
     * @author David van der Veer
     * @return population variance
     */
    public double populationVarianceRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation){
        double VARIANCE;
        double STANDARD_DEVIATION = populationStandardDeviationRefuelTank(refuelTanks,wantedInformation);

        VARIANCE = Math.pow(STANDARD_DEVIATION , 2);

        return VARIANCE;
    }

    private void orderListByType(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        switch (wantedInformation) {
            case LITERS:
                refuelTanks.sort(new LitersComparator());
                break;
            case TOTAL_PRICE:
                refuelTanks.sort(new TotalPriceComparator());
                break;
            case KILOMETERS_DRIVEN:
                refuelTanks.sort(new KilometersComparator());
                break;
            case LITER_PRICE:
                refuelTanks.sort(new LiterPriceComparator());
                break;
            case KILOMETERS_PER_LITER:
                refuelTanks.sort(new KmplComparator());
                break;
        }
    }

    private HashMap<Double, Integer> calculateFrequencyByStep(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation, double STEP_SIZE) {
        HashMap<Double, Integer> frequencies = new HashMap<>();

        for (RefuelTank refuelTank : refuelTanks) {
            double currentValue = refuelTank.getType(wantedInformation);
            double STEP = currentValue - (currentValue % STEP_SIZE);
            boolean HAS_ENTRY = frequencies.containsKey(STEP);
            int updatedFrequency;

            if (HAS_ENTRY) {
                int CURRENT_FREQUENCY = frequencies.get(STEP);

                updatedFrequency = CURRENT_FREQUENCY + 1;
            }
            else
                updatedFrequency = 1;

            frequencies.put(STEP, updatedFrequency);
        }

        return frequencies;
    }

    private ArrayList<Double> findMostFrequent(HashMap<Double, Integer> frequencies) {
        ArrayList<Double> mostCommonValues = new ArrayList<>(Collections.singletonList(0.0));
        int mostCommonFrequency = 0;


        for (Map.Entry<Double, Integer> frequency : frequencies.entrySet()) {
            Double STEP = frequency.getKey();
            Integer STEP_FREQUENCY = frequency.getValue();

            if (STEP_FREQUENCY > mostCommonFrequency) {
                mostCommonValues.clear();
                mostCommonValues.add(STEP);
                mostCommonFrequency = STEP_FREQUENCY;
            } else if (STEP_FREQUENCY == mostCommonFrequency) {
                mostCommonValues.add(STEP);
            }
        }

        return mostCommonValues;
    }

}
