package CarInformation.Util.IdenticalValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.TestFoundations.Values;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public class IdenticalValues extends Values {

    public void setup() {
        // Kilometers driven: -1 , literPrice : 2.095512083, kilometers/Liter : 2.301495972
        testTank1 = new RefuelTank(1, 100, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
        testTank2 = new RefuelTank(1, 120, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
        testTank3 = new RefuelTank(1, 140, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
        testTank4 = new RefuelTank(1, 160, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
        testTank5 = new RefuelTank(1, 180, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));

        testTanks = new ArrayList<>();
        testTanks.add(testTank1);
        testTanks.add(testTank2);
        testTanks.add(testTank3);
        testTanks.add(testTank4);
        testTanks.add(testTank5);

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

}
