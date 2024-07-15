package CarInformation.Util.PositiveValues;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveLowestTest extends PositiveValues{

	@Test
	public void refuelNumberLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank1());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Test
	public void drivenKilometersLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank2());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Test
	public void litersLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.LITERS);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank2());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Test
	public void refuelPriceLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank5());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Test
	public void LiterPriceLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.LITER_PRICE);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank5());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}

	@Test
	public void kilometersPerLiterLowest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_OUTCOME = super.getCalculator().lowestRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<RefuelTank> expectedOutcome = new ArrayList<>();

		expectedOutcome.add(super.getTestTank2());

		assertEquals(expectedOutcome, CALCULATED_OUTCOME);
	}


}
