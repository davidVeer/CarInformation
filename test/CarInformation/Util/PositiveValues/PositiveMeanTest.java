package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveMeanTest extends PositiveValues{

	@Test
	public void refuelNumberMean() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().meanRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = 3;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void drivenKilometersMean() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().meanRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_OUTCOME = 62;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void litersMean() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().meanRefuelTank(InformationType.LITERS);
		double EXPECTED_OUTCOME = 6.758;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void refuelPriceMean() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().meanRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_OUTCOME = 14.8;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void LiterPriceMean() {
		setup();
		double CALCULATED_TOTAL = (int)(super.getCalculator().meanRefuelTank(InformationType.LITER_PRICE) * 10000)/10000.0;
		double EXPECTED_OUTCOME = 2.2234;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void kilometersPerLiterMean() {
		setup();
		double CALCULATED_TOTAL = (int)(super.getCalculator().meanRefuelTank(InformationType.KILOMETERS_PER_LITER) * 10000)/10000.0;
		double EXPECTED_OUTCOME = 12.1154;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}
}
