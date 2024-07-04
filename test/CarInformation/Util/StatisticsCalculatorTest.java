package CarInformation.Util;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void highestNumbers() {
        standardSetup();
        int initialSize = testTanks.size();

        for (InformationType testType : testTypes) {
            RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);
            assertEquals(initialSize, testTanks.size());

            for (RefuelTank testTank : testTanks)
                assertFalse(CALCULATED_HIGHEST_VALUE.getType(testType) < testTank.getType(testType),
                        "found a value higher then calculated highest. " +
                                "\nCalculated Highest: " + CALCULATED_HIGHEST_VALUE.getType(testType) +
                                "\nHigher value: " + testTank.getType(testType)
                        );
        }
    }

    @org.junit.jupiter.api.Test
    void lowestNumbers() {
        standardSetup();
        int initialSize = testTanks.size();

        for (InformationType testType : testTypes) {
            RefuelTank CALCULATED_LOWEST_VALUE = calculator.lowestRefuelTank(testType);
            assertEquals(initialSize, testTanks.size());


            for (RefuelTank testTank : testTanks)
                assertFalse(
                        CALCULATED_LOWEST_VALUE.getType(testType) > 0 && CALCULATED_LOWEST_VALUE.getType(testType) > testTank.getType(testType),
                        "found a value lower then calculated lowest. " +
                                "\nCalculated lowest: " + CALCULATED_LOWEST_VALUE.getType(testType) +
                                "\nLower value: " + testTank.getType(testType)
                );
        }
    }

    public RefuelTank generateRandomRefuelTank(RefuelTank previousTank) {
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

    void filtersInvalidNumbers() {
        try {
            for (InformationType testType : testTypes) {
                check_0(testType);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail();
        }

    }

    private void check_0(InformationType testType) {
        for (RefuelTank testTank : testTanks) {
            double ITEM_TO_CHECK = testTank.getType(testType);
            String ERROR_MESSAGE = "items cannot equal or be less then 0 but " + testType +
                    " from tank number: " + testTank.getType(InformationType.REFUEL_NUMBER) +
                    " is: " + testTank.getType(testType);

            if (ITEM_TO_CHECK <= 0)
                throw new IllegalArgumentException(ERROR_MESSAGE);
        }
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
            RefuelTank currentTank = generateRandomRefuelTank(previousTank);
            testTanks.add(currentTank);

            previousTank = currentTank;
        }

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }

    /*
    getting/ calculating median values
    calculating total (population) values
    calculating mean/average values
    calculating mode values (can return multiple values)
    calculating (population) standard deviation
    calculating (population) variance
     */
}