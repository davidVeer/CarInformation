import Data.CarData;

import comparators.*;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        carData.orderBy(new LiterPriceComparator());
        carData.printRefuleTanks();

        carData.printHighest();
    }
}