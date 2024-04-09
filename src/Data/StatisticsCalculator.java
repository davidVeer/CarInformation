package Data;

import comparators.*;

import java.util.ArrayList;

public class StatisticsCalculator {

    //todo: catch 0 values of first RefuleTank with lowest value calculator


    //statistics returning RefuleTanks
    public RefuleTank highestRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {

        //sorting list based on information being asked
        orderByType(refuleTanks, wantedInformation);

        //returning last (and therefore highest) item of the sorted list
        return refuleTanks.get(refuleTanks.size() - 1);
    }

    public RefuleTank lowestRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {

        //sorting list based on information being asked
        orderByType(refuleTanks,wantedInformation);

        //returning first (and therefore lowest) item of the sorted list
        return refuleTanks.get(0);
    }

    public ArrayList<RefuleTank> medianRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {

        //initialisation for method
        ArrayList<RefuleTank> medianRefuleTanks = new ArrayList<>();
        int standardMedian = refuleTanks.size() / 2;

        //sorting list based on information being asked
        orderByType(refuleTanks,wantedInformation);

        //getting the medians and adding them to an ArrayList
        if (refuleTanks.size() % 2 == 1)
            medianRefuleTanks.add(refuleTanks.get(standardMedian));
        else {
            medianRefuleTanks.add(refuleTanks.get(standardMedian));
            medianRefuleTanks.add(refuleTanks.get(standardMedian - 1));
        }

        return medianRefuleTanks;
    }

    //statistics returning doubles
    public double averageRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }

    public double modeRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }

    public double standardDeviationRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return 0;
    }

    //helper methods
    private void orderByType(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation){
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
}
