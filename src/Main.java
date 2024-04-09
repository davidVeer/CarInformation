import Data.CarData;

import Data.InformationType;
import comparators.*;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        carData.orderBy(new LitersComparator());
        carData.printRefuleTanks();

        carData.printLowest(InformationType.KMPL);
        carData.printLowest(InformationType.LITERS);

    }
}