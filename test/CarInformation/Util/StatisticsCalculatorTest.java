package CarInformation.Util;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCalculatorTest {
    StatisticsCalculator calculator;
    ArrayList<RefuelTank> testTanks = new ArrayList<>();
    ArrayList<InformationType> testTypes = new ArrayList<>(Arrays.asList(
            InformationType.REFUEL_NUMBER,
            InformationType.REFUEL_PRICE,
            InformationType.KILOMETERS_DRIVEN,
            InformationType.LITERS,
            InformationType.KILOMETERS_PER_LITER,
            InformationType.LITER_PRICE
    ));

    @Test
    void testEmptyInitialisationCalculator() {
        Exception initialisationExeption = assertThrows(
                NullPointerException.class,
                () -> new StatisticsCalculator(new CarData(new ArrayList<>()).getRefuelTanks()));
        assertEquals(
                "StatisticsCalculator cannot be initialised with empty an ArrayList<RefuelTank>",
                initialisationExeption.getMessage());
    }

    @Test
    void highestNumbersMixedTest() {

    }
    @Test
    void highestNumbersNegativeTest() {

    }
    @Test
    void highestNumbersPositiveTest() {

    }

    @Test
    void lowestNumbersMixedTest() {

    }

    @Test
    void lowestNumbersNegativeTest() {

    }

    @Test
    void lowestNumbersPositiveTest() {

    }


    @Test
    public void totalValueMixedTest() {

    }

    @Test
    public void totalValueNegativeTest() {

    }

    @Test
    public void totalValuePositiveTest() {

    }

    @Test
    public void meanTest() {

    }

    @Test
    public void medianTest() {
    }

    public RefuelTank generateRandomAllNegativeRefuelTank(RefuelTank previousTank) {
        RefuelTank generatedTestTank;
        int REFUEL_NUMBER = previousTank.getRefuelNumber() - 1;
        int RANDOM_ODOMETER = (int) (previousTank.getOdometer() + (Math.random() * -1500));
        double RANDOM_LITERS = (Math.random() * -80);
        double RANDOM_PRICE = (Math.random() * -320);
        LocalDate RANDOM_DATE = LocalDate.of(2005, Month.SEPTEMBER, 3);


        generatedTestTank = new RefuelTank(
                REFUEL_NUMBER,
                RANDOM_ODOMETER,
                RANDOM_LITERS,
                RANDOM_PRICE,
                RANDOM_DATE);

        return generatedTestTank;
    }

    private RefuelTank generateRandomAllPositiveRefuelTank(RefuelTank previousTank) {
        RefuelTank generatedTestTank;
        int REFUEL_NUMBER = previousTank.getRefuelNumber() + 1;
        int RANDOM_ODOMETER = (int) (previousTank.getOdometer() + (Math.random() * 1500));
        double RANDOM_LITERS = (Math.random() * 80);
        double RANDOM_PRICE = (Math.random() * 320);
        LocalDate RANDOM_DATE = LocalDate.of(2005, Month.SEPTEMBER, 3);


        generatedTestTank = new RefuelTank(
                REFUEL_NUMBER,
                RANDOM_ODOMETER,
                RANDOM_LITERS,
                RANDOM_PRICE,
                RANDOM_DATE);

        return generatedTestTank;
    }

    public RefuelTank generateRandomMixedRefuelTank(RefuelTank previousTank) {
        RefuelTank generatedTestTank;
        int REFUEL_NUMBER = previousTank.getRefuelNumber() + 1;
        int RANDOM_ODOMETER = (int) (previousTank.getOdometer() - 500 + (Math.random() * 1500));
        double RANDOM_LITERS = -10 + (Math.random() * 80);
        double RANDOM_PRICE = -80 + (Math.random() * 320);
        LocalDate RANDOM_DATE = LocalDate.of(2005, Month.SEPTEMBER, 3);


        generatedTestTank = new RefuelTank(
                REFUEL_NUMBER,
                RANDOM_ODOMETER,
                RANDOM_LITERS,
                RANDOM_PRICE,
                RANDOM_DATE);

        return generatedTestTank;
    }

    void standardSetup() {
        int RANDOM_LENGTH = 10 + (int) (Math.random() * 50);
        RefuelTank previousTank = new RefuelTank(
                0,
                0,
                0,
                0,
                LocalDate.of(2005, Month.SEPTEMBER, 3)
        );

        testTanks.clear();
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            RefuelTank currentTank = generateRandomMixedRefuelTank(previousTank);
            testTanks.add(currentTank);

            previousTank = currentTank;
        }

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

    void standardSetup(String validity) {
        int RANDOM_LENGTH = 10 + (int) (Math.random() * 50);
        RefuelTank previousTank = new RefuelTank(
                0,
                0,
                0,
                0,
                LocalDate.of(2005, Month.SEPTEMBER, 3)
        );

        testTanks.clear();
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            RefuelTank currentTank;

            switch (validity) {
                case "negative":
                    currentTank = generateRandomAllNegativeRefuelTank(previousTank);
                    break;
                case "positive":
                    currentTank = generateRandomAllPositiveRefuelTank(previousTank);
                    break;
                default:
                    currentTank = generateRandomMixedRefuelTank(previousTank);
                    break;
            }
            testTanks.add(currentTank);

            previousTank = currentTank;
        }

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

    /*
    getting/calculating median values
    calculating mode values (can return multiple values)
    calculating (population) standard deviation
    calculating (population) variance
     */
}