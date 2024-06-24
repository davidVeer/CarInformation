package Util;

import Data.CarData;
import Data.RefuelTank;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCalculatorTest {
    StatisticsCalculator calculator = new StatisticsCalculator(new ArrayList<RefuelTank>());
    ArrayList<RefuelTank> testTanks = new ArrayList<>();
    ArrayList<InformationType> testTypes = new ArrayList<>(Arrays.asList(
            InformationType.REFUEL_NUMBER,
            InformationType.REFUEL_PRICE,
            InformationType.KILOMETERS_DRIVEN,
            InformationType.LITERS,
            InformationType.KILOMETERS_PER_LITER,
            InformationType.LITER_PRICE
    ));
    CarData testData;

    @Test
    void testForEmptyList() {
        testTanks.clear();

        try {
            testTanks = new ArrayList<>();
            testData = new CarData(testTanks);
            calculator.highestRefuelTank(InformationType.LITERS);
        } catch (NullPointerException ex) {
            return;
        }
        fail();
    }

    @org.junit.jupiter.api.Test
    void highestNumbers() {
        standardSetup();

        for (InformationType testType : testTypes) {
            calculator.orderListByType(testTanks, testType);
            RefuelTank VALUE_OF_LAST_INDEX = testTanks.get(testTanks.size() - 1);
            RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);

            assertEquals(VALUE_OF_LAST_INDEX, CALCULATED_HIGHEST_VALUE);
        }

    }

    @org.junit.jupiter.api.Test
    void lowestNumbers() {
        standardSetup();


        for (InformationType testType : testTypes) {
            calculator.orderListByType(testTanks, testType);
            RefuelTank VALUE_OF_FIRST_INDEX = testTanks.get(0);
            RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testType);

            assertEquals(VALUE_OF_FIRST_INDEX, CALCULATED_HIGHEST_VALUE);
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
                calculator.orderListByType(testTanks, testType);
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
        int RANDOM_LENGTH = (int) (Math.random() * 50);
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