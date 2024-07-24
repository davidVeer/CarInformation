package CarInformation.Util.IdenticalValues;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorHighestTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class IdenticalHighestTest extends IdenticalValues implements CalculatorHighestTest {

	@Override
	@Test
	public void refuelNumberHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);
	}

	@Override
	@Test
	public void drivenKilometersHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void litersHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.LITERS);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}


	@Override
	@Test
	public void refuelPriceHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void LiterPriceHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.LITER_PRICE);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void kilometersPerLiterHighest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.highestRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank5);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);
	}
}
