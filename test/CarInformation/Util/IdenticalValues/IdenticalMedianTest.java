package CarInformation.Util.IdenticalValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.TestFoundations.CalculatorMedianTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class IdenticalMedianTest extends IdenticalValues implements CalculatorMedianTest {


	@Override
	@Test
	public void refuelNumberMedianOdd() {
		setup();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = 1;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();
	}


	@Override
	@Test
	public void drivenKilometersMedianOdd() {
		setupEven();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 20;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void litersMedianOdd() {
		setup();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.LITERS);
		double EXPECTED_VALUE = 8.69;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void refuelPriceMedianOdd() {
		setup();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_VALUE = 18.21;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void LiterPriceMedianOdd() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.medianRefuelTank(InformationType.LITER_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.095;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void kilometersPerLiterMedianOdd() {
		setupEven();
		double CALCULATED_VALUE = (int)(calculator.medianRefuelTank(InformationType.KILOMETERS_PER_LITER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.301;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void refuelNumberMedianEven() {
		setupEven();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = 1;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();
	}


	@Override
	@Test
	public void drivenKilometersMedianEven() {
		setup();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 20;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void litersMedianEven() {
		setupEven();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.LITERS);
		double EXPECTED_VALUE = 8.69;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void refuelPriceMedianEven() {
		setupEven();
		double CALCULATED_VALUE = calculator.medianRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_VALUE = 18.21;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void LiterPriceMedianEven() {
		setupEven();
		double CALCULATED_VALUE = (int)(calculator.medianRefuelTank(InformationType.LITER_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.095;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


	@Override
	@Test
	public void kilometersPerLiterMedianEven() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.medianRefuelTank(InformationType.KILOMETERS_PER_LITER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.301;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}

	@Override

	public void setupEven() {
		// Kilometers driven: -1 , literPrice : 2.095512083, kilometers/Liter : -0.1150747986
		testTank1 = new RefuelTank(1, 100, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
		testTank2 = new RefuelTank(1, 120, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
		testTank3 = new RefuelTank(1, 140, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
		testTank4 = new RefuelTank(1, 160, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
		testTank5 = new RefuelTank(1, 180, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven:  20, literPrice : 2.095, kilometers/Liter : 2.301
		RefuelTank testTank6 = new RefuelTank(1, 180, 8.69,18.21, LocalDate.of(2005, Month.SEPTEMBER,3));

		testTanks = new ArrayList<>();
		testTanks.add(testTank1);
		testTanks.add(testTank2);
		testTanks.add(testTank3);
		testTanks.add(testTank4);
		testTanks.add(testTank5);
		testTanks.add(testTank6);

		calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());

	}

}
