package CarInformation.Util.IdenticalValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorStandardDeviation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdenticalStandardDeviationTest extends IdenticalValues implements CalculatorStandardDeviation {

	@Override
	@Test
	public void refuelNumberStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void litersStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.LITERS);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void refuelPriceStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void LiterPriceStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void kilometersPerLiterStandardDeviation() {
		setup();
		double CALCULATED_VALUE = calculator.populationStandardDeviationRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

}
