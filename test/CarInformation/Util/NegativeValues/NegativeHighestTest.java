package CarInformation.Util.NegativeValues;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;
import CarInformation.Util.StatisticsCalculator;
import CarInformation.Util.TestFoundations.CalculatorHighestTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeHighestTest extends NegativeValues implements CalculatorHighestTest {


	@Override
	@Test
	public void refuelNumberHighest() {
		setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.REFUEL_NUMBER));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();
	}

	@Override
	@Test
	public void drivenKilometersHighest() {
		super.setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.KILOMETERS_DRIVEN));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();
	}

	@Override
	@Test
	public void litersHighest() {
		super.setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.LITERS));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void refuelPriceHighest() {
		super.setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.REFUEL_PRICE));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void LiterPriceHighest() {
		setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.LITER_PRICE));

		assertEquals("all values were invalid",expectedException.getMessage());

		breakdown();

	}

	@Override
	@Test
	public void kilometersPerLiterHighest() {
		setup();
		NullPointerException expectedException = assertThrows(NullPointerException.class ,() ->
				calculator.highestRefuelTank(InformationType.KILOMETERS_PER_LITER));

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
