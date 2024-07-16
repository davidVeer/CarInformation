package CarInformation.Util.PositiveValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorMedianTest;
import CarInformation.Util.StatisticsCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PositiveMedianTest extends PositiveValues implements CalculatorMedianTest {


	@Override
	@Test
	public void refuelNumberMedianOdd() {
		setup();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_MEDIAN = 3;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void drivenKilometersMedianOdd() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_MEDIAN = 40;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void litersMedianOdd() {
		setup();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.LITERS);
		double EXPECTED_MEDIAN = 3;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void refuelPriceMedianOdd() {
		setup();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_MEDIAN = 7.10;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void LiterPriceMedianOdd() {
		setup();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_MEDIAN = 2.50;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void kilometersPerLiterMedianOdd() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_MEDIAN = 11;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void refuelNumberMedianEven() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_MEDIAN = 3.5;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void drivenKilometersMedianEven() {
		setup();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_MEDIAN = 49;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void litersMedianEven() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.LITERS);
		double EXPECTED_MEDIAN = 2.8;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void refuelPriceMedianEven() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_MEDIAN = 6.8;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void LiterPriceMedianEven() {
		setupEven();
		double CALCULATED_MEDIAN = calculator.medianRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_MEDIAN = 2.25;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}


	@Override
	@Test
	public void kilometersPerLiterMedianEven() {
		setup();
		double CALCULATED_MEDIAN = (int)(calculator.medianRefuelTank(InformationType.KILOMETERS_PER_LITER) * 100) / 100.0;
		double EXPECTED_MEDIAN = 12.39;

		assertEquals(EXPECTED_MEDIAN, CALCULATED_MEDIAN);

		breakdown();
	}

	public void setupEven() {
		// Kilometers driven: -1 , literPrice : 2.684 , kilometers/Liter : -0.091
		super.testTank1 = new RefuelTank(1, 100, 10.99,29.50, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven: 10 , literPrice : 3.087 , kilometers/Liter : 4.348
		super.testTank2 = new RefuelTank(2, 110, 2.30,7.10, LocalDate.of(2005, Month.SEPTEMBER,4));
		// Kilometers driven: 140 , literPrice : 1.879 , kilometers/Liter : 9.396
		super.testTank3 = new RefuelTank(3, 250, 14.90,28.00, LocalDate.of(2005, Month.SEPTEMBER,20));
		// Kilometers driven: 40 , literPrice : 2.50, kilometers/Liter : 15.385
		super.testTank4 = new RefuelTank(4, 290, 2.60,6.50, LocalDate.of(2005, Month.OCTOBER,1));
		// Kilometers driven: 58 , literPrice : 0.967, kilometers/Liter : 19.33
		super.testTank5 = new RefuelTank(5, 348, 3.00,2.90, LocalDate.of(2005, Month.OCTOBER,3));
		// Kilometers driven: 22 , literPrice : 2.0 , kilometers/Liter : 11
		RefuelTank testTank6 = new RefuelTank(6,370,2.0,4.0, LocalDate.of(2005, Month.OCTOBER, 5));

		super.testTanks = new ArrayList<>();
		testTanks.add(testTank1);
		testTanks.add(testTank2);
		testTanks.add(testTank3);
		testTanks.add(testTank4);
		testTanks.add(testTank5);
		testTanks.add(testTank6);

		super.calculator = new StatisticsCalculator(new CarData(super.testTanks).getRefuelTanks());
	}
}
