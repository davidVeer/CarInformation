package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveTotalTest extends PositiveValues{

	@Test
	public void refuelNumberTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void drivenKilometersTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_OUTCOME = 248;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void litersTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.LITERS);
		double EXPECTED_OUTCOME = 33.79;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void refuelPriceTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_OUTCOME = 74;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void LiterPriceTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Test
	public void kilometersPerLiterTotal() {
		setup();
		double CALCULATED_TOTAL = super.getCalculator().totalValueRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

}
