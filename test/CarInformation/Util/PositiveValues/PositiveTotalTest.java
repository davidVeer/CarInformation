package CarInformation.Util.PositiveValues;

import CarInformation.Util.CalculatorTotalTest;
import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveTotalTest extends PositiveValues implements CalculatorTotalTest {

	@Override
	@Test
	public void refuelNumberTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void drivenKilometersTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_OUTCOME = 248;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void litersTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.LITERS);
		double EXPECTED_OUTCOME = 33.79;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void refuelPriceTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.REFUEL_PRICE);
		double EXPECTED_OUTCOME = 74;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void LiterPriceTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

	@Override
	@Test
	public void kilometersPerLiterTotal() {
		setup();
		double CALCULATED_TOTAL = super.calculator.totalValueRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_OUTCOME = Double.NaN;

		assertEquals(EXPECTED_OUTCOME, CALCULATED_TOTAL);
	}

}
