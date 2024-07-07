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
    void testForEmptyInitialisation() {
        try {
            calculator = new StatisticsCalculator(new CarData(new ArrayList<>()).getRefuelTanks());
            fail();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void highestNumbersMixedTest() {
        standardSetup();
        int initialSize = testTanks.size();

        for (InformationType testType : testTypes) {
            try {
                assertEquals(initialSize, testTanks.size());
                RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);
                assertHighestNumberInValidList(testType, CALCULATED_HIGHEST_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("highestNumbersMixed : all Items within " + testType + " are invalid");
            }
        }
    }
    @Test
    void highestNumbersNegativeTest() {
        standardSetup("negative");
        int initialSize = testTanks.size();

        for (InformationType testType : testTypes) {
            try {
                assertEquals(initialSize, testTanks.size());
                RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);
                assertHighestNumberInValidList(testType, CALCULATED_HIGHEST_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("highestNumbersNegative : all Items within " + testType + " are invalid");
            }
        }
    }
    @Test
    void highestNumbersPositiveTest() {
        standardSetup("positive");
        int initialSize = testTanks.size();

        for (InformationType testType : testTypes) {
                assertEquals(initialSize, testTanks.size());
                RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);
                assertHighestNumberInValidList(testType, CALCULATED_HIGHEST_VALUE);
        }
    }

    private void assertHighestNumberInValidList(InformationType testType, RefuelTank CALCULATED_HIGHEST_VALUE) {
        for (RefuelTank testTank : testTanks)
            assertFalse(CALCULATED_HIGHEST_VALUE.getType(testType) < testTank.getType(testType),
                    "found a value higher then calculated highest. " +
                            "\nCalculated Highest: " + CALCULATED_HIGHEST_VALUE.getType(testType) +
                            "\nHigher value: " + testTank.getType(testType)
            );
    }

    @Test
    void lowestNumbersMixedTest() {
        standardSetup();

        for (InformationType testType : testTypes) {
            try {
                RefuelTank CALCULATED_LOWEST_VALUE = calculator.lowestRefuelTank(testType);
                assertLowestValueInValidList(testType, CALCULATED_LOWEST_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("lowestNumbersMixed : all Items within " + testType + " are invalid");
            }
        }
    }

    @Test
    void lowestNumbersNegativeTest() {
        standardSetup("negative");

        for (InformationType testType : testTypes) {
            try {
                RefuelTank CALCULATED_LOWEST_VALUE = calculator.lowestRefuelTank(testType);
                assertLowestValueInValidList(testType, CALCULATED_LOWEST_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("lowestNumbersNegative : all Items within " + testType + " are invalid");
            }
        }
    }

    @Test
    void lowestNumbersPositiveTest() {
        standardSetup("positive");

        for (InformationType testType : testTypes) {
                RefuelTank CALCULATED_LOWEST_VALUE = calculator.lowestRefuelTank(testType);
                assertLowestValueInValidList(testType, CALCULATED_LOWEST_VALUE);
        }
    }

    private void assertLowestValueInValidList(InformationType testType, RefuelTank CALCULATED_LOWEST_VALUE) {
        for (RefuelTank testTank : testTanks)
            assertFalse(
                    testTank.getType(testType) > 0 && CALCULATED_LOWEST_VALUE.getType(testType) > testTank.getType(testType),
                    "\nfound a value lower then calculated lowest. " +
                            "\nCalculated lowest: " + CALCULATED_LOWEST_VALUE.getType(testType) +
                            "\nLower value: " + testTank.getType(testType)
            );
    }

    @Test
    public void totalValueMixedTest() {
        standardSetup();

        for (InformationType testType : testTypes) {
            try {
                double CALCULATED_TOTAL_VALUE = calculator.totalValueRefuelTank(testType);
                calculateAndAssertTotal(testType, CALCULATED_TOTAL_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("TotalValueMixed : all Items within " + testType + " are invalid");
            }

        }
    }

    @Test
    public void totalValueNegativeTest() {
        standardSetup("negative");

        for (InformationType testType : testTypes) {
            try {
                double CALCULATED_TOTAL_VALUE = calculator.totalValueRefuelTank(testType);
                calculateAndAssertTotal(testType, CALCULATED_TOTAL_VALUE);
            } catch (NullPointerException exception) {
                System.out.println("TotalValueNegative : all Items within " + testType + " are invalid");
            }

        }
    }

    @Test
    public void totalValuePositiveTest() {
        standardSetup("positive");

        for (InformationType testType : testTypes) {
                double CALCULATED_TOTAL_VALUE = calculator.totalValueRefuelTank(testType);
                calculateAndAssertTotal(testType, CALCULATED_TOTAL_VALUE);
        }
    }

    private void calculateAndAssertTotal(InformationType testType, double CALCULATED_TOTAL_VALUE) {
        double totalValue = 0.0;

        for (RefuelTank testTank : testTanks)
            if (testTank.getType(testType) > 0)
                totalValue += testTank.getType(testType);

        double CALCULATION_DELTA = Math.abs(totalValue - CALCULATED_TOTAL_VALUE);

        if (testType.equals(InformationType.LITER_PRICE) ||
                testType.equals(InformationType.KILOMETERS_PER_LITER) ||
                testType.equals(InformationType.REFUEL_NUMBER)
        )
            assertEquals(Double.NEGATIVE_INFINITY, CALCULATED_TOTAL_VALUE);
        else
            assertTrue(CALCULATION_DELTA < 0.000001,
                    "\nType being tested : " + testType +
                            "\nexpected outcome was : " + totalValue +
                            "\nactual outcome was : " + CALCULATED_TOTAL_VALUE
            );

    }

    @Test
    public void meanTest() {
        standardSetup();

        for (InformationType testType : testTypes) {
            try {
                double CALCULATED_MEAN = calculator.meanRefuelTank(testType);
                calculateAndAssertMean(testType, CALCULATED_MEAN);
            } catch (NullPointerException exception) {
                System.out.println("all Items within " + testType + " are invalid");
            }
        }
    }

    private void calculateAndAssertMean(InformationType testType, double CALCULATED_MEAN) {
        double totalValue = 0.0;
        int amountOfEntries = 0;

        for (RefuelTank testTank : testTanks)
            if (testTank.getType(testType) > 0) {
                totalValue += testTank.getType(testType);
                amountOfEntries++;
            }
        double PREDICTED_MEAN = totalValue / amountOfEntries;
        double CALCULATION_DELTA = Math.abs(PREDICTED_MEAN - CALCULATED_MEAN);

        assertTrue(CALCULATION_DELTA < 0.000001,
                "\nType being tested : " + testType +
                        "\nexpected outcome was : " + PREDICTED_MEAN +
                        "\nactual outcome was : " + CALCULATED_MEAN
        );
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