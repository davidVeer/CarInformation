import Data.CarData;
import GUI.GuiMain;
import comparators.KilometersComparator;
import comparators.LiterPriceComparator;
import comparators.TotalPriceComparator;

public class Main {
    public static void main(String[] args) {
//        GuiMain.main(args);
        CarData carData = new CarData();

        carData.orderBy(new LiterPriceComparator());
        carData.printRefuleTanks();
    }
}