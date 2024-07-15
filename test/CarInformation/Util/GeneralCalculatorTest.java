package CarInformation.Util;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeneralCalculatorTest {
    private ArrayList<RefuelTank> testTanks;

    public GeneralCalculatorTest() {
        testTanks = new ArrayList<>();
    }

    @Test
    void testEmptyInitialisationCalculator() {
        Exception initialisationExeption = assertThrows(
                NullPointerException.class,
                () -> new StatisticsCalculator(new CarData(new ArrayList<>()).getRefuelTanks()));
        assertEquals(
                "StatisticsCalculator cannot be initialised with empty an ArrayList<RefuelTank>",
                initialisationExeption.getMessage());
    }
}