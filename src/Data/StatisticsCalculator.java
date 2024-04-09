package Data;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.time.LocalDate;
import java.util.ArrayList;

public class StatisticsCalculator {

    private enum WantedInformation {
        LITERS,
        TOTALPRICE,
        KILOMETERSDRIVEN,
        LITERPRICE,
        KMPL
    }

    //statistic calculations with doubles
    private double highestDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double lowestDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double highestDeltaDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double averageDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double medianDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double modeDouble(ArrayList<Double> doubles) {
        return 0;
    }

    private double standardDeviationDouble(ArrayList<Double> doubles) {
        return 0;
    }


    //statistic calculations with integers
    private int highestInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int lowestInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int highestDeltaInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int averageInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int medianInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int modeInt(ArrayList<Integer> integers) {
        return 0;
    }

    private int standardDeviationInt(ArrayList<Integer> integers) {
        return 0;
    }

    //statistics returning RefuleTanks
    private RefuleTank highestRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank lowestRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank highestDeltaRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank averageRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank medianRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank modeRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }

    private RefuleTank standardDeviationRefuleTank(ArrayList<RefuleTank> refuleTanks, WantedInformation wantedInformation) {
        return null;
    }
}
