import CarInformation.Data.CarData;

import CarInformation.Util.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.KILOMETERS_DRIVEN;
        carData.printRefuelTanks();

        carData.printHighest(testType);
        carData.printLowest(testType);
        carData.printMedians(testType);
        carData.printAverage(testType);
        carData.printMode(testType);
        carData.printTotalValue(testType);
        carData.printStandardDeviation(testType);
        carData.printVariance(testType);
        carData.printAsArray(testType);
    }
}