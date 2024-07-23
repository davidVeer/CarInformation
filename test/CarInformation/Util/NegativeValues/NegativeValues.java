package CarInformation.Util.NegativeValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.TestFoundations.Values;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class NegativeValues extends Values {

    public void setup() {
        // Kilometers driven: -1 , literPrice :  , kilometers/Liter :
        super.testTank1 = new RefuelTank(-1, 300, -30,-62.2, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven: -30 (-1) , literPrice :  , kilometers/Liter :
        super.testTank2 = new RefuelTank(-2, 270, -26.6,-43.44, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven: -170 (-1) , literPrice :  , kilometers/Liter :
        super.testTank3 = new RefuelTank(-3, 100, -91.18,-83.32, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven: -110 (-1) , literPrice : , kilometers/Liter :
        super.testTank4 = new RefuelTank(-4, -10, -0.87,-1.2, LocalDate.of(2005, Month.SEPTEMBER,3));
        // Kilometers driven: -70 (-1) , literPrice : , kilometers/Liter :
        super.testTank5 = new RefuelTank(-5, -80, -6.94,-12.0, LocalDate.of(2005, Month.SEPTEMBER,3));

        super.testTanks = new ArrayList<>();
        testTanks.add(testTank1);
        testTanks.add(testTank2);
        testTanks.add(testTank3);
        testTanks.add(testTank4);
        testTanks.add(testTank5);

        super.calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

}
