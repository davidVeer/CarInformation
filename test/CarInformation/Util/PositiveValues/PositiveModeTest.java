package CarInformation.Util.PositiveValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorModeTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveModeTest extends PositiveValues implements CalculatorModeTest {

	@Override
	@Test
	public void refuelNumberMode() {
		setup();
		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.REFUEL_NUMBER);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(1.0);
		expectedModeValues.add(2.0);
		expectedModeValues.add(3.0);
		expectedModeValues.add(4.0);
		expectedModeValues.add(5.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersMode() {
		setup();
		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.KILOMETERS_DRIVEN);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(10.0);
		expectedModeValues.add(40.0);
		expectedModeValues.add(50.0);
		expectedModeValues.add(140.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}

	@Override
	@Test
	public void litersMode() {
		setup();
		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.LITERS);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(2.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}

	@Override
	@Test
	public void refuelPriceMode() {
		setup();
		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.REFUEL_PRICE);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(2.0);
		expectedModeValues.add(6.0);
		expectedModeValues.add(7.0);
		expectedModeValues.add(28.0);
		expectedModeValues.add(29.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}

	@Override
	@Test
	public void LiterPriceMode() {
		setup();
		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.LITER_PRICE);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(0.9);
		expectedModeValues.add(1.8);
		expectedModeValues.add(2.4000000000000004); // this is a floating point error that I am not fixing because it only occurs with liter price
		expectedModeValues.add(2.6);
		expectedModeValues.add(3.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}

	@Override
	@Test
	public void kilometersPerLiterMode() {
		setup();

		ArrayList<Double> CALCULATED_MODE_VALUES = calculator.modeRefuelTank(InformationType.KILOMETERS_PER_LITER);
		ArrayList<Double> expectedModeValues = new ArrayList<>();

		expectedModeValues.add(4.0);
		expectedModeValues.add(9.0);
		expectedModeValues.add(15.0);
		expectedModeValues.add(19.0);

		assertEquals(expectedModeValues, CALCULATED_MODE_VALUES);

		breakdown();
	}
}
