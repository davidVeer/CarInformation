import Data.CarData;

import Util.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.KILOMETERS_DRIVEN;

        carData.orderBy(testType);
        carData.printRefuelTanks();

        //highest and lowest test

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printHighest(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printLowest(testType);

        //median test

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printMedians(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printAverage(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printMode(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printTotalValue(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printStandardDeviation(testType);

        carData.orderBy(InformationType.REFUEL_NUMBER);
        carData.printVariance(testType);

        carData.orderBy(testType);
        carData.printAsArray(testType);
    }
}