package CarInformation.Util.NegativeValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.Values;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class NegativeValues extends Values {

    public void setup() {
        // Kilometers driven:  , literPrice :  , kilometers/Liter :
        super.testTank1 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  , literPrice :  , kilometers/Liter :
        super.testTank2 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  , literPrice :  , kilometers/Liter :
        super.testTank3 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  , literPrice : , kilometers/Liter :
        super.testTank4 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven:  , literPrice : , kilometers/Liter :
        super.testTank5 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));

        super.testTanks = new ArrayList<>();
        testTanks.add(testTank1);
        testTanks.add(testTank2);
        testTanks.add(testTank3);
        testTanks.add(testTank4);
        testTanks.add(testTank5);

        super.calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

}
