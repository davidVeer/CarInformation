import Data.CarData;

import Data.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.KILOMETERSDRIVEN;

        carData.orderBy(testType);
        carData.printRefuleTanks();

        //highest and lowest test
        carData.printHighest(testType);
        carData.printLowest(testType);

        //median test
        carData.printMedians(testType);


    }
}