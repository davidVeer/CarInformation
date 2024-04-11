import Data.CarData;

import Data.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.LITER_PRICE;

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
    }
}