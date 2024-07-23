package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorStandardDeviation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PositiveStandardDeviationTest extends PositiveValues implements CalculatorStandardDeviation {

	@Override
	@Test
	public void refuelNumberStandardDeviation() {
		setup();
		double CALCULATED_VALUE =
				(int)(calculator.populationStandardDeviationRefuelTank(InformationType.REFUEL_NUMBER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 1.414;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersStandardDeviation() {
		setup();
		double CALCULATED_VALUE =
				(int)(calculator.populationStandardDeviationRefuelTank(InformationType.KILOMETERS_DRIVEN) * 1000) / 1000.0;
		double EXPECTED_VALUE = 48.187;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void litersStandardDeviation() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationStandardDeviationRefuelTank(InformationType.LITERS) * 1000) / 1000.0;
		double EXPECTED_VALUE = 5.205;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void refuelPriceStandardDeviation() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationStandardDeviationRefuelTank(InformationType.REFUEL_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 11.490;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void LiterPriceStandardDeviation() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationStandardDeviationRefuelTank(InformationType.LITER_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 0.739;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void kilometersPerLiterStandardDeviation() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.populationStandardDeviationRefuelTank(InformationType.KILOMETERS_PER_LITER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 5.712;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);
		breakdown();
	}

}
