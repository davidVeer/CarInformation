package CarInformation.Util.PositiveValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.StatisticsCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PositiveMedianTest extends PositiveValues{

	@Test
	public void refuelNumberMedian() {
		super.setup();
		double CALCULATED_TOTAL = super.getCalculator().medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = 3;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void drivenKilometersMedian() {
		fail();
	}

	@Test
	public void litersMedian() {
		fail();
	}

	@Test
	public void refuelPriceMedian() {
		fail();
	}

	@Test
	public void LiterPriceMedian() {
		fail();
	}

	@Test
	public void kilometersPerLiterMedian() {
		fail();
	}

	public void setupEven() {
		// Kilometers driven: -1 , literPrice : 2.684 , kilometers/Liter : -0.091
		super.setTestTank1(new RefuelTank(1, 100, 10.99,29.50, LocalDate.of(2005, Month.SEPTEMBER,3)));
		// Kilometers driven: 10 , literPrice : 3.087 , kilometers/Liter : 4.348
		super.setTestTank2(new RefuelTank(2, 110, 2.30,7.10, LocalDate.of(2005, Month.SEPTEMBER,4)));
		// Kilometers driven: 140 , literPrice : 1.879 , kilometers/Liter : 9.396
		super.setTestTank3(new RefuelTank(3, 250, 14.90,28.00, LocalDate.of(2005, Month.SEPTEMBER,20)));
		// Kilometers driven: 40 , literPrice : 2.50, kilometers/Liter : 15.385
		super.setTestTank4(new RefuelTank(4, 290, 2.60,6.50, LocalDate.of(2005, Month.OCTOBER,1)));
		// Kilometers driven: 58 , literPrice : 0.967, kilometers/Liter : 19.33
		super.setTestTank5(new RefuelTank(5, 348, 3.00,2.90, LocalDate.of(2005, Month.OCTOBER,3)));
		RefuelTank testTank6 = new RefuelTank(6,370,2.0,4.0, LocalDate.of(2005, Month.OCTOBER, 5));

		super.setTestTanks(new ArrayList<>());
		super.getTestTanks().add(super.getTestTank1());
		super.getTestTanks().add(super.getTestTank2());
		super.getTestTanks().add(super.getTestTank3());
		super.getTestTanks().add(super.getTestTank4());
		super.getTestTanks().add(super.getTestTank5());

		super.setCalculator(new StatisticsCalculator(new CarData(super.getTestTanks()).getRefuelTanks()));
	}
}
