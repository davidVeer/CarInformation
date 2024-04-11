package Data;

import comparators.*;

import java.util.*;

public class StatisticsCalculator {

    /*
     todo : other statistics
     - totalRefuel tank
     */

    public RefuelTank highestRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        RefuelTank HIGHEST;

        orderByType(refuelTanks, wantedInformation);
        HIGHEST = refuelTanks.get(refuelTanks.size() - 1);

        return HIGHEST;
    }

    public RefuelTank lowestRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        RefuelTank LOWEST_NON_ZERO;

        orderByType(refuelTanks, wantedInformation);
        int lowestNonZeroIndex = 0;
        while (refuelTanks.get(lowestNonZeroIndex).getType(wantedInformation) == 0) {
            lowestNonZeroIndex++;
        }
        LOWEST_NON_ZERO = refuelTanks.get(lowestNonZeroIndex);

        return LOWEST_NON_ZERO;
    }

    public ArrayList<RefuelTank> medianRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        ArrayList<RefuelTank> medianRefuelTanks = new ArrayList<>();

        orderByType(refuelTanks, wantedInformation);
        RefuelTank STANDARD_MEDIAN = refuelTanks.get(refuelTanks.size() / 2);
        RefuelTank EVEN_SECONDARY_MEDIAN = refuelTanks.get((refuelTanks.size() / 2) - 1);

        medianRefuelTanks.add(STANDARD_MEDIAN);
        if (refuelTanks.size() % 2 == 0) {
            medianRefuelTanks.add(EVEN_SECONDARY_MEDIAN);
        }

        return medianRefuelTanks;
    }

    public double averageRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        double AVERAGE_VALUE;
        double total = 0;

        for (RefuelTank refuelTank : refuelTanks) {
            total += refuelTank.getType(wantedInformation);
        }
        AVERAGE_VALUE = total / refuelTanks.size();

        return AVERAGE_VALUE;
    }

    public ArrayList<Double> modeRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        HashMap<Double, Integer> frequencies;
        ArrayList<Double> MODE_VALUES;
        double COMPARISON_STEPS;

        orderByType(refuelTanks, wantedInformation);

        switch (wantedInformation) {
            case LITER_PRICE:
                COMPARISON_STEPS = 0.5;
                break;
            case KILOMETERS_DRIVEN:
                COMPARISON_STEPS = 10;
                break;
            default:
                COMPARISON_STEPS = 1;
                break;
        }
        frequencies = calculateFrequencyByStep(refuelTanks, wantedInformation, COMPARISON_STEPS);
        MODE_VALUES = findMostFrequent(frequencies);

        return MODE_VALUES;
    }

    public double standardDeviationRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        return 0;
    }

    private void orderByType(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
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
    private HashMap<Double,Integer> calculateFrequencyByStep(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation,double COMPARISON_STEPS){
        HashMap<Double, Integer> frequencies = new HashMap<>();

        for (RefuelTank refuelTank : refuelTanks) {
            double currentValue = refuelTank.getType(wantedInformation);
            double factor = currentValue - (currentValue % COMPARISON_STEPS);
            int updatedFrequency;

            if (!frequencies.containsKey(factor))
                updatedFrequency =  1;
            else
                updatedFrequency = frequencies.get(factor) + 1;

            frequencies.put(factor , updatedFrequency);
        }

        return frequencies;
    }
    private ArrayList<Double> findMostFrequent(HashMap<Double, Integer> frequencies){
        ArrayList<Double> mostCommonFactors = new ArrayList<>(Collections.singletonList(0.0));
        double mostCommonValue = 0.0;


        for (Map.Entry<Double, Integer> frequency : frequencies.entrySet()) {
            Double currentStep = frequency.getKey();
            Integer currentfrequency = frequency.getValue();

            if (currentfrequency > mostCommonValue) {
                mostCommonFactors.clear();
                mostCommonFactors.add(currentStep);
                mostCommonValue = currentfrequency;
            }
            else if (currentfrequency == mostCommonValue) {
                mostCommonFactors.add(currentStep);
            }
        }

        return mostCommonFactors;
    }
}
