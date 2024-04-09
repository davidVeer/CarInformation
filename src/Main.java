import Data.CarData;

import Data.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        InformationType testType = InformationType.LITERPRICE;

        carData.orderBy(testType);
        carData.printRefuleTanks();

        //highest and lowest test
        carData.printHighest(testType);
        carData.printLowest(testType);

        //median test
        System.out.println("index 5");
        carData.printIndex(5);
        carData.printIndex(4);
        carData.printMedians(testType);


    }
}