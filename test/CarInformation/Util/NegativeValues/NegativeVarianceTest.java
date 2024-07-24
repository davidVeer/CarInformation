package CarInformation.Util.NegativeValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.TestFoundations.CalculatorVarianceTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeVarianceTest extends NegativeValues implements CalculatorVarianceTest {

	@Override
	@Test
	public void refuelNumberVariance() {
		super.setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.REFUEL_NUMBER));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void drivenKilometersVariance() {
		super.setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_DRIVEN));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();
	}

	@Override
	@Test
	public void litersVariance() {
		super.setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.LITERS));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void refuelPriceVariance() {
		super.setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.REFUEL_PRICE));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void LiterPriceVariance() {
		setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.LITER_PRICE));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void kilometersPerLiterVariance() {
		setup();

		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.populationVarianceRefuelTank(InformationType.KILOMETERS_PER_LITER));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	public void setup() {
		// Kilometers driven: -1, literPrice :  , kilometers/Liter :
		super.testTank1 = new RefuelTank(-1, 300, 30,-62.2, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven: 30 , literPrice :  , kilometers/Liter :
		super.testTank2 = new RefuelTank(-2, 330, -26.6,43.44, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven: 170 , literPrice :  , kilometers/Liter :
		super.testTank3 = new RefuelTank(-3, 500, -91.18,83.32, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven: 110 , literPrice : , kilometers/Liter :
		super.testTank4 = new RefuelTank(-4, 610, -0.87,1.2, LocalDate.of(2005, Month.SEPTEMBER,3));
		// Kilometers driven: 70 , literPrice : , kilometers/Liter :
		super.testTank5 = new RefuelTank(-5, 780, -6.94,12.0, LocalDate.of(2005, Month.SEPTEMBER,3));

		super.testTanks = new ArrayList<>();
		testTanks.add(testTank1);
		testTanks.add(testTank2);
		testTanks.add(testTank3);
		testTanks.add(testTank4);
		testTanks.add(testTank5);

		super.calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());

	}
}
