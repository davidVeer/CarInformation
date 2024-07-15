package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
		fail();
	}

	@Test
	public void litersMedian() {
		fail();
	}

	@Test
	public void refuelPriceMedian() {
		fail();
	}

	@Test
	public void LiterPriceMedian() {
		fail();
	}

	@Test
	public void kilometersPerLiterMedian() {
		fail();
	}

}
