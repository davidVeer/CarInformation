package CarInformation.Util.PositiveValues;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.CalculatorHighestTest;
import CarInformation.Util.InformationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveHighestTest extends PositiveValues implements CalculatorHighestTest {



	@Override
	@Test
	public void refuelNumberHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank5);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}

	@Override
	@Test
	public void drivenKilometersHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank3);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}

	@Override
	@Test
	public void litersHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.LITERS);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank3);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}

	@Override
	@Test
	public void refuelPriceHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank1);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}

	@Override
	@Test
	public void LiterPriceHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.LITER_PRICE);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank2);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}

	@Override
	@Test
	public void kilometersPerLiterHighest() {
		setup();
		ArrayList<RefuelTank> CALCULATED_HIGHEST_TANKS = super.calculator.highestRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<RefuelTank> EXPECTED_OUTCOME = new ArrayList<>();

		EXPECTED_OUTCOME.add(super.testTank5);

		assertEquals(EXPECTED_OUTCOME,CALCULATED_HIGHEST_TANKS);
	}



}
