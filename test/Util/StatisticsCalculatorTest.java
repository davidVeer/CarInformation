package Util;

import Data.CarData;
import Data.RefuelTank;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCalculatorTest {
    StatisticsCalculator calculator = new StatisticsCalculator();
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


    @org.junit.jupiter.api.Test
    void highestNumbers() {
        standardSetup();

        try {
            for (InformationType testType : testTypes) {
                calculator.orderListByType(testTanks, testType);
                RefuelTank VALUE_OF_LAST_INDEX = testTanks.get(testTanks.size() - 1);
                RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testTanks, testType);

                if (VALUE_OF_LAST_INDEX != CALCULATED_HIGHEST_VALUE) {
                    throw new IllegalArgumentException(
                            "the highest " + testType + " should be " + VALUE_OF_LAST_INDEX +
                            " but is: " + CALCULATED_HIGHEST_VALUE.getType(testType));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void lowestNumbers() {
        standardSetup();

        try {
            for (InformationType testType : testTypes) {
                calculator.orderListByType(testTanks, testType);
                RefuelTank VALUE_OF_FIRST_INDEX = testTanks.get(0);
                RefuelTank CALCULATED_HIGHEST_VALUE = calculator.highestRefuelTank(testTanks, testType);

                if (VALUE_OF_FIRST_INDEX != CALCULATED_HIGHEST_VALUE) {
                    fail();
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void medianSmallLiSt() {
        standardSetup();


        for (InformationType testType : testTypes) {
            double EXPECTED_OUTCOME = expectedOutcomes.get(testType);
            double CALCULATED_OUTCOME = calculator.medianRefuelTank(testTanks, testType);

            if (CALCULATED_OUTCOME != EXPECTED_OUTCOME)
                try {
                    throw new Exception("median for " + testType + " should be: " + EXPECTED_OUTCOME + " but is: " + CALCULATED_OUTCOME);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    fail();
                }
        }

    }

    void medianLargeList() {
        testTanks.clear();


        testData = new CarData(testTanks);
        HashMap<InformationType, Double> expectedOutcomes = new HashMap<>();
        expectedOutcomes.put(InformationType.REFUEL_NUMBER, 3.0);
        expectedOutcomes.put(InformationType.REFUEL_PRICE, 31.0);
        expectedOutcomes.put(InformationType.KILOMETERS_DRIVEN, 12.5);
        expectedOutcomes.put(InformationType.LITERS, 15.0);
        expectedOutcomes.put(InformationType.KILOMETERS_PER_LITER, 1.787);
        expectedOutcomes.put(InformationType.LITER_PRICE, 2.079);


        for (InformationType testType : testTypes) {
            double EXPECTED_OUTCOME = expectedOutcomes.get(testType);
            double CALCULATED_OUTCOME = Math.round(calculator.medianRefuelTank(testTanks, testType) * 1000) / 1000.0;

            if (CALCULATED_OUTCOME != EXPECTED_OUTCOME)
                try {
                    throw new Exception("median for " + testType + " should be: " + EXPECTED_OUTCOME + " but is: " + CALCULATED_OUTCOME);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    fail();
                }
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
    void testForEmptyList() {
        try {
            testTanks = new ArrayList<>();
            testData = new CarData(testTanks);
            calculator.highestRefuelTank(testTanks, InformationType.LITERS);
        } catch (NullPointerException ex) {
            return;
        }
        fail();
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
        testForEmptyList();
        filtersInvalidNumbers();
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