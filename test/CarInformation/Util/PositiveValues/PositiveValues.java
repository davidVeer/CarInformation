package CarInformation.Util.PositiveValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.Values;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class PositiveValues extends Values {

    public void setup() {
        // Kilometers driven: -1 , literPrice : 2.684 , kilometers/Liter : -0.091
        testTank1 = new RefuelTank(1, 100, 10.99,29.50, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven: 10 , literPrice : 3.087 , kilometers/Liter : 4.348
        testTank2 = new RefuelTank(2, 110, 2.30,7.10, LocalDate.of(2005, Month.SEPTEMBER,4));
        // Kilometers driven: 140 , literPrice : 1.879 , kilometers/Liter : 9.396
        testTank3 = new RefuelTank(3, 250, 14.90,28.00, LocalDate.of(2005, Month.SEPTEMBER,20));
        // Kilometers driven: 40 , literPrice : 2.50, kilometers/Liter : 15.385
        testTank4 = new RefuelTank(4, 290, 2.60,6.50, LocalDate.of(2005, Month.OCTOBER,1));
        // Kilometers driven: 58 , literPrice : 0.967, kilometers/Liter : 19.33
        testTank5 = new RefuelTank(5, 348, 3.00,2.90, LocalDate.of(2005, Month.OCTOBER,3));

        testTanks = new ArrayList<>();
        testTanks.add(testTank1);
        testTanks.add(testTank2);
        testTanks.add(testTank3);
        testTanks.add(testTank4);
        testTanks.add(testTank5);

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }
}
