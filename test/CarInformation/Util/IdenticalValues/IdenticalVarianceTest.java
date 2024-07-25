package CarInformation.Util.IdenticalValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorVarianceTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IdenticalVarianceTest extends IdenticalValues implements CalculatorVarianceTest {

	@Override
	@Test
	public void refuelNumberVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void drivenKilometersVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void litersVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.LITERS);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void refuelPriceVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void LiterPriceVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();
	}

	@Override
	@Test
	public void kilometersPerLiterVariance() {
		setup();
		double CALCULATED_VALUE = calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_VALUE = 0.0;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}
}
