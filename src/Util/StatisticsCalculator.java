package Util;

import Data.RefuelTank;
import Util.Comparators.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * a class that is responsible for calculating all the statistical data utilised in the application
 * <p>
 * overview of calculations (all of these return the calculation for the requested InformationType data):
 * Refuel tank with highest value,
 * Refuel tank with lowest value,
 * median value,
 * mean/average value,
 * mode value(s),
 * total value,
 * population standard deviation,
 * population variance.
 * </p>
 * <p>
 * InformationType overview (anything in the InformationType Enum):
 * amount of liters tanked,
 * price of the tank,
 * kilometers driven since last tank,
 * liter price,
 * fuel economy (km/l),
 * refuel number (sequential numbering of amount of refuels).
 * </p>
 * @author David van der Veer
 * @version 1.1
 */
public class StatisticsCalculator {

    ArrayList<RefuelTank> originalList;
    public StatisticsCalculator(ArrayList<RefuelTank> tankList){
        this.originalList = tankList;
    }

    /**
     * this method finds the last value of provided InformationType in a list sorted by that InformationType
     *
     * @author David van der Veer
     * @return lowest non zero RefuelTank
     */
    public RefuelTank highestRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        RefuelTank HIGHEST;

        orderListByType(refuelTanks, wantedInformation);
        HIGHEST = refuelTanks.get(refuelTanks.size() - 1);

        return HIGHEST;
    }

    /**
     * this method finds the first non 0 value of provided InformationType in a list sorted by that InformationType
     *
     * @author David van der Veer
     * @return lowest non zero RefuelTank
     */
    public RefuelTank lowestRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        int lowestNonZeroIndex = 0;
        RefuelTank LOWEST_NON_ZERO;

        orderListByType(refuelTanks, wantedInformation);
        while (refuelTanks.get(lowestNonZeroIndex).getType(wantedInformation) == 0) {
            lowestNonZeroIndex++;
        }
        LOWEST_NON_ZERO = refuelTanks.get(lowestNonZeroIndex);

        return LOWEST_NON_ZERO;
    }

    /**
     * this method calculates the mean value in a set using the formula: μ = Σ ( X[i] ) / n
     * <p>
     * this simply stated is the total value divided by the number of items in the set
     * </p>
     *
     * @author David van der Veer
     * @return mean (average)
     */
    public double meanRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        double total = 0.0;
        double MEAN;

        for (RefuelTank refuelTank : refuelTanks) {
            double REFUEL_TANK_TYPE_VALUE = refuelTank.getType(wantedInformation);

            total += REFUEL_TANK_TYPE_VALUE;
        }
        MEAN = total / refuelTanks.size();

        return MEAN;
    }

    /**
     * this method finds the median RefuelTanks in a sorted set of RefuelTanks
     * todo: make method return a single double as the median
     *
     * @author David van der Veer
     * @return median value
     */
    public double medianRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        double median;

        orderListByType(refuelTanks, wantedInformation);
        double STANDARD_MEDIAN = refuelTanks.get(refuelTanks.size() / 2).getType(wantedInformation);
        double EVEN_SECONDARY_MEDIAN = refuelTanks.get((refuelTanks.size() / 2) - 1).getType(wantedInformation);

        median = STANDARD_MEDIAN;
        if (refuelTanks.size() % 2 == 0) {
            median += EVEN_SECONDARY_MEDIAN;
            median /= 2;
        }

        return median;
    }

    /**
     * this method calculates the mean by first creating a frequency table and subsequently comparing every frequency
     * and finding which one(s) are the highest.
     *
     * @author David van der Veer
     * @return mode value(s)
     */
    public ArrayList<Double> modeRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        ArrayList<Double> mostCommonValues = new ArrayList<>(Collections.singletonList(0.0));
        int mostCommonFrequency = 0;
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


        for (Map.Entry<Double, Integer> frequency : frequencyTable.entrySet()) {
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
        MODE_VALUES = mostCommonValues;

        return MODE_VALUES;
    }

    /**
     * this method calculates the total value of a set using the formula: X[total] = Σ (X[i]).
     * <p>
     * basically this means adding up every value in the set to get a total
     * </p>
     *
     * @author David van der Veer
     * @return total value
     */
    public double totalValueRefuleTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
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
     * this method calculates the population standard deviation using the formula: σ = √ (Σ (x[i] - μ)^2 / n)
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
    public double populationStandardDeviationRefuelTank(InformationType wantedInformation) {
        ArrayList<RefuelTank> refuelTanks = originalList;
        double SAMPLE_MEAN = meanRefuelTank(wantedInformation);
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
     * this method that calculates the population variance using the formula: σ^2 = Σ (x[i] - μ)^2 / n.
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
    public double populationVarianceRefuelTank(InformationType wantedInformation){
        double VARIANCE;
        double STANDARD_DEVIATION = populationStandardDeviationRefuelTank(wantedInformation);

        VARIANCE = Math.pow(STANDARD_DEVIATION , 2);

        return VARIANCE;
    }

    /**
     * this method sorts a list by the InformationType specified in the parameter and removes any negative or 0 objects.
     * it's a helper method that is used multiple times in the class for calculations that require
     * a sorted and assending list. the lists are sorted using custom comparators that can be found in /comparators.
     * this practical method can potentially be used elsewhere (in different classes)
     *
     * @author David van der Veer
     */
    public void orderListByType(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        switch (wantedInformation) {
            case LITERS:
                refuelTanks.sort(new LitersComparator());
                break;
            case REFUEL_PRICE:
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
            case REFUEL_NUMBER:
                refuelTanks.sort(new RefuelNumberComparator());
        }

        refuelTanks.removeIf(refuelTank -> refuelTank.getType(wantedInformation) < 0);
    }
    /**
     * this method creates a frequency table (HashMap) of every step along with its frequency as long
     * as the step has a frequency higher than 0.
     *
     * @author David van der Veer
     * @return frequency table
     */
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

}
