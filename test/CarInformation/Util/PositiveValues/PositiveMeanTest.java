package CarInformation.Util.PositiveValues;

import CarInformation.Util.CalculatorMeanTest;
import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveMeanTest extends PositiveValues implements CalculatorMeanTest {

	@Override
	@Test
	public void refuelNumberMean() {
		setup();
		double CALCULATED_TOTAL = super.calculator.meanRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = 3;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void drivenKilometersMean() {
		setup();
		double CALCULATED_TOTAL = super.calculator.meanRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_OUTCOME = 62;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void litersMean() {
		setup();
		double CALCULATED_TOTAL = super.calculator.meanRefuelTank(InformationType.LITERS);
		double EXPECTED_OUTCOME = 6.758;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void refuelPriceMean() {
		setup();
		double CALCULATED_TOTAL = super.calculator.meanRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_OUTCOME = 14.8;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void LiterPriceMean() {
		setup();
		double CALCULATED_TOTAL = (int)(super.calculator.meanRefuelTank(InformationType.LITER_PRICE) * 10000)/10000.0;
		double EXPECTED_OUTCOME = 2.2234;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void kilometersPerLiterMean() {
		setup();
		double CALCULATED_TOTAL = (int)(super.calculator.meanRefuelTank(InformationType.KILOMETERS_PER_LITER) * 10000)/10000.0;
		double EXPECTED_OUTCOME = 12.1154;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}
}
