import Data.CarData;

import Data.InformationType;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

//        carData.orderBy(new LitersComparator());
//        carData.orderBy(new KmplComparator());
        carData.orderBy(InformationType.REFULENUMBER);
        carData.printRefuleTanks();

        System.out.println("index 5");
        carData.printIndex(5);
//        carData.printMedians(InformationType.LITERS);
//        carData.printMedians(InformationType.KMPL);
//        carData.printMedians(InformationType.KILOMETERSDRIVEN);
    }
}