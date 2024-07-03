import CarInformation.Data.CarData;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.StatisticsCalculator;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.KILOMETERS_DRIVEN;
        StatisticsCalculator calculator = new StatisticsCalculator(carData.getRefuelTanks());

        for (RefuelTank refuelTank : carData.getRefuelTanks()) {
            System.out.println(refuelTank);
        }

        System.out.println(calculator.lowestRefuelTank(testType));
    }
}