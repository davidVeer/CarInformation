package Data;

import java.util.ArrayList;

public class StatisticsCalculator {

    //statistics returning RefuleTanks
    public RefuleTank highestRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        RefuleTank highestValue = refuleTanks.get(0);

        for (RefuleTank refuleTank : refuleTanks) {
            switch (wantedInformation){
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
            switch (wantedInformation){
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
    public RefuleTank averageRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return null;
    }
    public RefuleTank medianRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return null;
    }
    public RefuleTank modeRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return null;
    }
    public RefuleTank standardDeviationRefuleTank(ArrayList<RefuleTank> refuleTanks, InformationType wantedInformation) {
        return null;
    }
}
