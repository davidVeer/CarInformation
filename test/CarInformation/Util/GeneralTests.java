package CarInformation.Util;

import CarInformation.Data.CarData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeneralTests {

	@Test
	public void emptyListTest() {
		Exception initialisationExeption = assertThrows(
				NullPointerException.class,
				() -> new StatisticsCalculator(new CarData(new ArrayList<>()).getRefuelTanks()));
		assertEquals(
				"StatisticsCalculator cannot be initialised with empty an ArrayList<RefuelTank>",
				initialisationExeption.getMessage());
	}

	public void originalListTest() {

	}

}
