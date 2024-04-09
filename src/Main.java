import Data.CarData;

import Data.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.KMPL;

        carData.orderBy(testType);
        carData.printRefuleTanks();

        //highest and lowest test

        carData.orderBy(InformationType.REFULENUMBER);
        carData.printHighest(testType);

        carData.orderBy(InformationType.REFULENUMBER);
        carData.printLowest(testType);

        //median test

        carData.orderBy(InformationType.REFULENUMBER);
        carData.printMedians(testType);

        carData.orderBy(InformationType.REFULENUMBER);
        carData.printAverage(testType);
    }
}