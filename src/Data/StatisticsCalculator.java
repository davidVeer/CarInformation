package Data;

import comparators.*;

import java.util.ArrayList;

public class StatisticsCalculator {

    /**
     * todo : other statistics
     * - totalRefuel tank
     */


    //statistics returning RefuelTanks
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

    //statistics returning doubles
    public double averageRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        double total = 0;
        for (RefuelTank refuelTank : refuelTanks) {
            total += refuelTank.getType(wantedInformation);
        }
        return total / refuelTanks.size();
    }

    public double modeRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        return 0;
    }

    public double standardDeviationRefuelTank(ArrayList<RefuelTank> refuelTanks, InformationType wantedInformation) {
        return 0;
    }

    //helper methods
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

    //empty switch-case
//        switch (wantedInformation){
//            case LITERS:
//
//                break;
//            case TOTALPRICE:
//
//                break;
//            case KILOMETERSDRIVEN:
//
//                break;
//            case LITERPRICE:
//
//                break;
//            case KMPL:
//
//                break;
//        }


}
