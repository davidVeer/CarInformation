package CarInformation.Util.PositiveValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.TestFoundations.CalculatorMedianTest;
import CarInformation.Util.StatisticsCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class PositiveMedianTest extends PositiveValues implements CalculatorMedianTest {


	@Override
	@Test
	public void refuelNumberMedianOdd() {

	}


	@Override
	@Test
	public void drivenKilometersMedianOdd() {

	}


	@Override
	@Test
	public void litersMedianOdd() {

	}


	@Override
	@Test
	public void refuelPriceMedianOdd() {

	}


	@Override
	@Test
	public void LiterPriceMedianOdd() {

	}


	@Override
	@Test
	public void kilometersPerLiterMedianOdd() {

	}


	@Override
	@Test
	public void refuelNumberMedianEven() {

	}


	@Override
	@Test
	public void drivenKilometersMedianEven() {

	}


	@Override
	@Test
	public void litersMedianEven() {

	}


	@Override
	@Test
	public void refuelPriceMedianEven() {

	}


	@Override
	@Test
	public void LiterPriceMedianEven() {

	}


	@Override
	@Test
	public void kilometersPerLiterMedianEven() {

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
		RefuelTank testTank6 = new RefuelTank(6,370,2.0,4.0, LocalDate.of(2005, Month.OCTOBER, 5));

		super.testTanks = new ArrayList<>();
		super.testTanks.add(super.testTank1);
		super.testTanks.add(super.testTank2);
		super.testTanks.add(super.testTank3);
		super.testTanks.add(super.testTank4);
		super.testTanks.add(super.testTank5);

		super.calculator = new StatisticsCalculator(new CarData(super.testTanks).getRefuelTanks());
	}
}
