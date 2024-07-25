package CarInformation.Util.IdenticalValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorModeTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdenticalModeTest extends IdenticalValues implements CalculatorModeTest {

	@Override
	@Test
	public void refuelNumberMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(1.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);
	}

	@Override
	@Test
	public void drivenKilometersMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(20.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);

	}

	@Override
	@Test
	public void litersMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.LITERS);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(8.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);

	}

	@Override
	@Test
	public void refuelPriceMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(18.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);

	}

	@Override
	@Test
	public void LiterPriceMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.LITER_PRICE);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(2.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);

	}

	@Override
	@Test
	public void kilometersPerLiterMode() {
		setup();
		ArrayList<Double> CALUCATED_VALUE = calculator.modeRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<Double> EXPECTED_VALUE = new ArrayList<>();

		EXPECTED_VALUE.add(2.0);

		assertEquals(EXPECTED_VALUE, CALUCATED_VALUE);
	}


}
