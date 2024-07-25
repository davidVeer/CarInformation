package CarInformation.Util.IdenticalValues;

import CarInformation.Util.InformationType;
import CarInformation.Util.TestFoundations.CalculatorTotalTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IdenticalTotalTest extends IdenticalValues implements CalculatorTotalTest {

	@Override
	@Test
	public void refuelNumberTotal() {
		setup();
		double CALCULATED_VALUE = calculator.totalValueRefuelTank(InformationType.REFUEL_NUMBER);
		double EXPECTED_VALUE = Double.NaN;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersTotal() {
		setup();
		double CALCULATED_VALUE = calculator.totalValueRefuelTank(InformationType.KILOMETERS_DRIVEN);
		double EXPECTED_VALUE = 80;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void litersTotal() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.totalValueRefuelTank(InformationType.LITERS) * 1000) / 1000.0;
		double EXPECTED_VALUE = 43.449;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void refuelPriceTotal() {
		setup();
		double CALCULATED_VALUE = (int)(calculator.totalValueRefuelTank(InformationType.REFUEL_PRICE) * 100) / 100.0;
		double EXPECTED_VALUE = 91.05;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void LiterPriceTotal() {
		setup();
		double CALCULATED_VALUE = calculator.totalValueRefuelTank(InformationType.LITER_PRICE);
		double EXPECTED_VALUE = Double.NaN;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}

	@Override
	@Test
	public void kilometersPerLiterTotal() {
		setup();
		double CALCULATED_VALUE = calculator.totalValueRefuelTank(InformationType.KILOMETERS_PER_LITER);
		double EXPECTED_VALUE = Double.NaN;

		assertEquals(EXPECTED_VALUE,CALCULATED_VALUE);

		breakdown();

	}


}
