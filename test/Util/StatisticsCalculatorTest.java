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

    @org.junit.jupiter.api.Test
    void testEmptyList() {

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
    void filtersInvalidNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(1, -100, -10, -25.2, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 340, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_2 = new RefuelTank(2, 240, 15.5, 30.46, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = -480, literPrice = -0.3968, km/l = 0.0
        RefuelTank TEST_TANK_3 = new RefuelTank(3, -360, -12.95, 27.83, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = -86, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_4 = new RefuelTank(4, -446, 8.12, 19.52, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = -546, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_5 = new RefuelTank(5, -992, -30.6, 56.99, LocalDate.of(2024, Month.SEPTEMBER, 3));
        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        try {
            for (InformationType testType : testTypes) {
                calculator.orderListByType(testTanks, testType);
                do_0_Check(testType);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }

    }

    private void do_0_Check(InformationType testType) {
        for (RefuelTank testTank : testTanks) {
            double ITEM_TO_CHECK = testTank.getType(testType);
            String ERROR_MESSAGE = "items cannot equal or be less then 0 but " + testType +
                " from tank number: " + testTank.getType(InformationType.REFUEL_NUMBER) +
                " is: " + testTank.getType(testType);

            if (ITEM_TO_CHECK <= 0)
                throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    @org.junit.jupiter.api.Test
    void highestCloseNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(1, 100, 15.20, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 10, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_2 = new RefuelTank(2, 110, 15.00, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = 5, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_3 = new RefuelTank(3, 115, 14.6, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 15, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_4 = new RefuelTank(4, 130, 12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 17, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_5 = new RefuelTank(5, 147, 15.21, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));

        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        testData = new CarData(testTanks);
        HashMap<InformationType, RefuelTank> expectedOutcome = new HashMap<>();
        expectedOutcome.put(InformationType.REFUEL_NUMBER, TEST_TANK_5);
        expectedOutcome.put(InformationType.REFUEL_PRICE, TEST_TANK_1);
        expectedOutcome.put(InformationType.KILOMETERS_DRIVEN, TEST_TANK_5);
        expectedOutcome.put(InformationType.LITERS, TEST_TANK_5);
        expectedOutcome.put(InformationType.KILOMETERS_PER_LITER, TEST_TANK_4);
        expectedOutcome.put(InformationType.LITER_PRICE, TEST_TANK_4);

        try {
            for (InformationType testType : testTypes) {
                RefuelTank CALCULATED_HIGHEST_REFUEL_TANK = calculator.highestRefuelTank(testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_HIGHEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the highest " + testType + " should be " + highestTypeData +
                            " but is: " + CALCULATED_HIGHEST_REFUEL_TANK.getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void highestFarAppartNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 1.910, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(54, 5004, 16.54, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 3034, literPrice = 0.103, km/l = 10.0
        RefuelTank TEST_TANK_2 = new RefuelTank(22, 8038, 302.25, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = -4864 (invalid), literPrice = 0.496, km/l = -78.7 (invalid)
        RefuelTank TEST_TANK_3 = new RefuelTank(17, 3174, 61.80, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 2214, literPrice = 0.187, km/l = 14.6
        RefuelTank TEST_TANK_4 = new RefuelTank(68, 5388, 152.12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 201, literPrice = 3.014, km/l = 19.2
        RefuelTank TEST_TANK_5 = new RefuelTank(48, 5589, 10.45, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));

        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        testData = new CarData(testTanks);
        HashMap<InformationType, RefuelTank> expectedOutcome = new HashMap<>();
        expectedOutcome.put(InformationType.REFUEL_NUMBER, TEST_TANK_4);
        expectedOutcome.put(InformationType.REFUEL_PRICE, TEST_TANK_1);
        expectedOutcome.put(InformationType.KILOMETERS_DRIVEN, TEST_TANK_2);
        expectedOutcome.put(InformationType.LITERS, TEST_TANK_2);
        expectedOutcome.put(InformationType.KILOMETERS_PER_LITER, TEST_TANK_5);
        expectedOutcome.put(InformationType.LITER_PRICE, TEST_TANK_5);

        try {
            for (InformationType testType : testTypes) {
                RefuelTank CALCULATED_HIGHEST_REFUEL_TANK = calculator.highestRefuelTank(testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_HIGHEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the highest " + testType + " should be " + highestTypeData +
                            " but is: " + CALCULATED_HIGHEST_REFUEL_TANK.getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void lowestCloseNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(1, 100, 15.20, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 10, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_2 = new RefuelTank(2, 110, 15.00, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = 5, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_3 = new RefuelTank(3, 115, 14.6, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 15, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_4 = new RefuelTank(4, 130, 12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 17, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_5 = new RefuelTank(5, 147, 15.21, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));

        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        testData = new CarData(testTanks);
        HashMap<InformationType, RefuelTank> expectedOutcome = new HashMap<>();
        expectedOutcome.put(InformationType.REFUEL_NUMBER, TEST_TANK_1);
        expectedOutcome.put(InformationType.REFUEL_PRICE, TEST_TANK_4);
        expectedOutcome.put(InformationType.KILOMETERS_DRIVEN, TEST_TANK_3);
        expectedOutcome.put(InformationType.LITERS, TEST_TANK_4);
        expectedOutcome.put(InformationType.KILOMETERS_PER_LITER, TEST_TANK_3);
        expectedOutcome.put(InformationType.LITER_PRICE, TEST_TANK_2);

        try {
            for (InformationType testType : testTypes) {
                RefuelTank CALCULATED_LOWEST_REFUEL_TANK = calculator.lowestRefuelTank(testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_LOWEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the lowest " + testType + " should be " + highestTypeData +
                            " but is: " + CALCULATED_LOWEST_REFUEL_TANK.getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void lowestFarAppartNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 1.910, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(54, 5004, 16.54, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 3034, literPrice = 0.103, km/l = 10.0
        RefuelTank TEST_TANK_2 = new RefuelTank(22, 8038, 302.25, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = -4864 (invalid), literPrice = 0.496, km/l = -78.7 (invalid)
        RefuelTank TEST_TANK_3 = new RefuelTank(17, 3174, 61.80, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 2214, literPrice = 0.187, km/l = 14.6
        RefuelTank TEST_TANK_4 = new RefuelTank(68, 5388, 152.12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 201, literPrice = 3.014, km/l = 19.2
        RefuelTank TEST_TANK_5 = new RefuelTank(48, 5589, 10.45, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));

        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        testData = new CarData(testTanks);
        HashMap<InformationType, RefuelTank> expectedOutcome = new HashMap<>();
        expectedOutcome.put(InformationType.REFUEL_NUMBER, TEST_TANK_3);
        expectedOutcome.put(InformationType.REFUEL_PRICE, TEST_TANK_4);
        expectedOutcome.put(InformationType.KILOMETERS_DRIVEN, TEST_TANK_5);
        expectedOutcome.put(InformationType.LITERS, TEST_TANK_5);
        expectedOutcome.put(InformationType.KILOMETERS_PER_LITER, TEST_TANK_2);
        expectedOutcome.put(InformationType.LITER_PRICE, TEST_TANK_2);

        try {
            for (InformationType testType : testTypes) {
                RefuelTank CALCULATED_LOWEST_REFUEL_TANK = calculator.lowestRefuelTank(testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_LOWEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the highest " + testType + " should be " + highestTypeData +
                            " but is: " + CALCULATED_LOWEST_REFUEL_TANK.getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }

    }

    @org.junit.jupiter.api.Test
    void medianSmallLiSt(){
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(1, 100, 15.20, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 10, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_2 = new RefuelTank(2, 110, 15.00, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = 5, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_3 = new RefuelTank(3, 115, 14.6, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 15, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_4 = new RefuelTank(4, 130, 12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 17, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_5 = new RefuelTank(5, 147, 15.21, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));

        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

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
            double CALCULATED_OUTCOME = Math.round(calculator.medianRefuelTank(testType) * 1000) / 1000.0;

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
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(1, 100, 15.20, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 20, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_2 = new RefuelTank(2, 120, 2.00, 4.50, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = 15, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_3 = new RefuelTank(3, 135, 1.23, 3.04, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 35, literPrice = -, km/l = -
        RefuelTank TEST_TANK_4 = new RefuelTank(4, 170, -1, 5.00, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 8, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_5 = new RefuelTank(5, 178, 0.65, 1.20, LocalDate.of(2024, Month.SEPTEMBER, 3));

        // tank 6 has values of : kilometersDriven = 23, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_6 = new RefuelTank(6, 201, 2.32, 5.17, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 7 has values of : kilometersDriven = -1 , literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_7 = new RefuelTank(7, -1, 5.31, 10.98, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 8 has values of : kilometersDriven = -1, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_8 = new RefuelTank(8, 350, 2.92, 7.32, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 9 has values of : kilometersDriven = 210, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_9 = new RefuelTank(9, 560, 12.00, 27.21, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 10 has values of : kilometersDriven = 10, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_10 = new RefuelTank(10, 570, 1.03, 2.4, LocalDate.of(2024, Month.SEPTEMBER, 3));

        // tank 11 has values of : kilometersDriven = 10, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_11 = new RefuelTank(11, 580, 0.87, 1.52, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 12 has values of : kilometersDriven = -1, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_12 = new RefuelTank(12, -1, -1, -1, LocalDate.of(1, 1, 1));
        // tank 13 has values of : kilometersDriven = -1, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_13 = new RefuelTank(13, 625, 2.45, 4.5, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 14 has values of : kilometersDriven = 15, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_14 = new RefuelTank(14, 640, 1.34, 2.71, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 15 has values of : kilometersDriven = 20, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_15 = new RefuelTank(15, 660, 1.76, 3.00, LocalDate.of(2024, Month.SEPTEMBER, 3));

        // tank 16 has values of : kilometersDriven = 8, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_16 = new RefuelTank(16, 668, 0.7, 1.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 17 has values of : kilometersDriven = 5, literPrice = 2.0666, km/l = 0.66666
        RefuelTank TEST_TANK_17 = new RefuelTank(17, 673, 0.3, 0.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 18 has values of : kilometersDriven = 19, literPrice = 2.101, km/l = 0.342
        RefuelTank TEST_TANK_18 = new RefuelTank(18, 692, 14.6, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 19 has values of : kilometersDriven = 58, literPrice = 2.366, km/l = 1.25
        RefuelTank TEST_TANK_19 = new RefuelTank(19, 750, 12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 20 has values of : kilometersDriven = 50, literPrice = 2.0710, km/l = 1.12
        RefuelTank TEST_TANK_20 = new RefuelTank(20, 800, 15.21, 31.5, LocalDate.of(2024, Month.SEPTEMBER, 3));


        // ordered kilometers driven list
        // {5,8,8,10,10,15,15,19,20,20,23,35,50,59,210} list size : 15 (median index 7 = 19)
        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);
        testTanks.add(TEST_TANK_6);
        testTanks.add(TEST_TANK_7);
        testTanks.add(TEST_TANK_8);
        testTanks.add(TEST_TANK_9);
        testTanks.add(TEST_TANK_10);
        testTanks.add(TEST_TANK_11);
        testTanks.add(TEST_TANK_12);
        testTanks.add(TEST_TANK_13);
        testTanks.add(TEST_TANK_14);
        testTanks.add(TEST_TANK_15);
        testTanks.add(TEST_TANK_16);
        testTanks.add(TEST_TANK_17);
        testTanks.add(TEST_TANK_18);
        testTanks.add(TEST_TANK_19);
        testTanks.add(TEST_TANK_20);

        testData = new CarData(testTanks);
        HashMap<InformationType, Double> expectedOutcomes = new HashMap<>();
        expectedOutcomes.put(InformationType.REFUEL_NUMBER, 3.0);
        expectedOutcomes.put(InformationType.REFUEL_PRICE, 31.0);
        expectedOutcomes.put(InformationType.KILOMETERS_DRIVEN, 19.0);
        expectedOutcomes.put(InformationType.LITERS, 15.0);
        expectedOutcomes.put(InformationType.KILOMETERS_PER_LITER, 1.787);
        expectedOutcomes.put(InformationType.LITER_PRICE, 2.079);


        for (InformationType testType : testTypes) {
            double EXPECTED_OUTCOME = expectedOutcomes.get(testType);
            double CALCULATED_OUTCOME = Math.round(calculator.medianRefuelTank(testType) * 1000) / 1000.0;

            if (CALCULATED_OUTCOME != EXPECTED_OUTCOME)
                try {
                    throw new Exception("median for " + testType + " should be: " + EXPECTED_OUTCOME + " but is: " + CALCULATED_OUTCOME);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    fail();
                }
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