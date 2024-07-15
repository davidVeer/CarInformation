package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveMedianTest extends PositiveValues{

	@Test
	public void refuelNumberMedian() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().medianRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = 1;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void drivenKilometersMedian() {

	}

	@Test
	public void litersMedian() {

	}

	@Test
	public void refuelPriceMedian() {

	}

	@Test
	public void LiterPriceMedian() {

	}

	@Test
	public void kilometersPerLiterMedian() {

	}

}
