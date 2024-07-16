package CarInformation.Util.PositiveValues;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.CalculatorLowestTest;
import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PositiveLowestTest extends PositiveValues implements CalculatorLowestTest {

	@Override
	@Test
	public void refuelNumberLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank1);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Override
	@Test
	public void drivenKilometersLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank2);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Override
	@Test
	public void litersLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.LITERS);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank2);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Override
	@Test
	public void refuelPriceLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank5);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Override
	@Test
	public void LiterPriceLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.LITER_PRICE);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank5);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Override
	@Test
	public void kilometersPerLiterLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.calculator.lowestRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.testTank2);

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}


}
