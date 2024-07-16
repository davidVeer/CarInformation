package CarInformation.Util.SimilarValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.Values;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class SimilarValues extends Values {

	public void setup() {
		// Kilometers driven:  , literPrice :  , kilometers/Liter :
		testTank1 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  , literPrice :  , kilometers/Liter :
		testTank2 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  , literPrice :  , kilometers/Liter :
		testTank3 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  , literPrice : , kilometers/Liter :
		testTank4 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  , literPrice : , kilometers/Liter :
		testTank5 = new RefuelTank(0, 0, 0,0, LocalDate.of(2005, Month.SEPTEMBER,3));

		testTanks = new ArrayList<>();
		testTanks.add(testTank1);
		testTanks.add(testTank2);
		testTanks.add(testTank3);
		testTanks.add(testTank4);
		testTanks.add(testTank5);

		calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
	}
}
