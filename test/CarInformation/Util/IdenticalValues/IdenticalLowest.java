package CarInformation.Util.IdenticalValues;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorLowestTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdenticalLowest extends IdenticalValues implements CalculatorLowestTest {

	@Override
	@Test
	public void refuelNumberLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void drivenKilometersLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void litersLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.LITERS);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void refuelPriceLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void LiterPriceLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.LITER_PRICE);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank1);
		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

	@Override
	@Test
	public void kilometersPerLiterLowest() {
		super.setup();
		ArrayList<RefuelTank> CALCULATED_VALUES = calculator.lowestRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<RefuelTank> EXPECTED_VALUES = new ArrayList<>();

		EXPECTED_VALUES.add(testTank2);
		EXPECTED_VALUES.add(testTank3);
		EXPECTED_VALUES.add(testTank4);
		EXPECTED_VALUES.add(testTank5);

		assertEquals(EXPECTED_VALUES, CALCULATED_VALUES);

	}

}
