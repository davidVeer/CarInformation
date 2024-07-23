package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorVarianceTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PositiveVarianceTest extends PositiveValues implements CalculatorVarianceTest {

	@Override
	@Test
	public void refuelNumberVariance() {
		setup();
		double CALCULATED_VALUE =
				(int)(calculator.populationVarianceRefuelTank(InformationType.REFUEL_NUMBER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.0 ;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersVariance() {
		setup();
		double CALCULATED_VALUE =
				(int)(calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_DRIVEN) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2322.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void litersVariance() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationVarianceRefuelTank(InformationType.LITERS) * 1000) / 1000.0;
		double EXPECTED_VALUE = 27.097;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void refuelPriceVariance() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationVarianceRefuelTank(InformationType.REFUEL_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 132.023;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void LiterPriceVariance() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationVarianceRefuelTank(InformationType.LITER_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 0.546;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void kilometersPerLiterVariance() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_PER_LITER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 32.629;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

}
