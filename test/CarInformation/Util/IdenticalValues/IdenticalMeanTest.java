package CarInformation.Util.IdenticalValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorMeanTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IdenticalMeanTest extends IdenticalValues implements CalculatorMeanTest {

	@Override
	@Test
	public void refuelNumberMean() {
		setup();
		double CALCULATED_VALUE = calculator.meanRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = 1.0;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersMean() {
		setup();
		double CALCULATED_VALUE = calculator.meanRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 20;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();
	}

	@Override
	@Test
	public void litersMean() {
		setup();
		double CALCULATED_VALUE = calculator.meanRefuelTank(InformationType.LITERS);
		double EXPECTED_VALUE = 8.69;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}

	@Override
	@Test
	public void refuelPriceMean() {
		setup();
		double CALCULATED_VALUE = calculator.meanRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_VALUE = 18.21;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}

	@Override
	@Test
	public void LiterPriceMean() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.meanRefuelTank(InformationType.LITER_PRICE) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.095;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}

	@Override
	@Test
	public void kilometersPerLiterMean() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.meanRefuelTank(InformationType.KILOMETERS_PER_LITER) * 1000) / 1000.0;
		double EXPECTED_VALUE = 2.301;

		assertEquals(EXPECTED_VALUE, CALCULATED_VALUE);
		breakdown();

	}


}
