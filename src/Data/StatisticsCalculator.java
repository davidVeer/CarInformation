package Data;

import comparators.*;

import java.util.ArrayList;

public class StatisticsCalculator {


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

    //statistics returning RefuleTanks
    public RefuleTank highestRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        RefuleTank highestValue = refuleTanks.get(0);

        for (RefuleTank refuleTank : refuleTanks) {
            switch (wantedInformation) {
                case LITERS:
                    if (refuleTank.getLiters() > highestValue.getLiters())
                        highestValue = refuleTank;
                    break;
                case TOTALPRICE:
                    if (refuleTank.getTotalPrice() > highestValue.getTotalPrice())
                        highestValue = refuleTank;
                    break;
                case KILOMETERSDRIVEN:
                    if (refuleTank.getKilometersDriven() > highestValue.getKilometersDriven())
                        highestValue = refuleTank;
                    break;
                case LITERPRICE:
                    if (refuleTank.getLiterPrice() > highestValue.getLiterPrice())
                        highestValue = refuleTank;
                    break;
                case KMPL:
                    if (refuleTank.getKmpl() > highestValue.getKmpl())
                        highestValue = refuleTank;
                    break;
            }
        }
        return highestValue;
    }

    public RefuleTank lowestRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        RefuleTank lowestValue = refuleTanks.get(0);

        for (RefuleTank refuleTank : refuleTanks) {
            switch (wantedInformation) {
                case LITERS:
                    if (refuleTank.getLiters() < lowestValue.getLiters())
                        lowestValue = refuleTank;
                    break;
                case TOTALPRICE:
                    if (refuleTank.getTotalPrice() < lowestValue.getTotalPrice())
                        lowestValue = refuleTank;
                    break;
                case KILOMETERSDRIVEN:
                    if (refuleTank.getKilometersDriven() < lowestValue.getKilometersDriven())
                        lowestValue = refuleTank;
                    break;
                case LITERPRICE:
                    if (refuleTank.getLiterPrice() < lowestValue.getLiterPrice())
                        lowestValue = refuleTank;
                    break;
                case KMPL:
                    if (refuleTank.getKmpl() < lowestValue.getKmpl())
                        lowestValue = refuleTank;
                    break;
            }
        }
        return lowestValue;
    }

    public ArrayList<RefuleTank> medianRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        ArrayList<RefuleTank> medianRefuleTanks = new ArrayList<>();
        int standardMedian = refuleTanks.size() / 2;

        switch (wantedInformation) {
            case LITERS:
                refuleTanks.sort(new LitersComparator());
                break;
            case TOTALPRICE:
                refuleTanks.sort(new TotalPriceComparator());
                break;
            case KILOMETERSDRIVEN:
                refuleTanks.sort(new KilometersComparator());
                break;
            case LITERPRICE:
                refuleTanks.sort(new LiterPriceComparator());
                break;
            case KMPL:
                refuleTanks.sort(new KmplComparator());
                break;
        }

        if (refuleTanks.size() % 2 == 1)
            medianRefuleTanks.add(refuleTanks.get(standardMedian));
        else {
            medianRefuleTanks.add(refuleTanks.get(standardMedian));
            medianRefuleTanks.add(refuleTanks.get(standardMedian - 1));
        }

        return medianRefuleTanks;
    }

    //statistics returning doubles
    public double modeRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }

    public double averageRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }

    public double standardDeviationRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }
}
