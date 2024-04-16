package Util;

import Data.CarData;
import Data.RefuelTank;
import org.junit.Assert;

import java.lang.reflect.Array;
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
    void testEmptyList() {
        testTanks = new ArrayList<>();
        testData = new CarData(testTanks);
        try {
            calculator.highestRefuelTank(testTanks, InformationType.LITERS);
        } catch (NullPointerException ex) {
            return;
        }
        fail();
    }

    @org.junit.jupiter.api.Test
    void negativeNumbers() {
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(-1, -100, -10, -25.2, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = -140, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_2 = new RefuelTank(-2, -240, -15.5, -30.46, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = -120, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_3 = new RefuelTank(-3, -360, -12.95, -27.83, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = -86, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_4 = new RefuelTank(-4, -446, -8.12, -19.52, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = -546, literPrice = 0.3968, km/l = 0.0
        RefuelTank TEST_TANK_5 = new RefuelTank(-5, -992, -30.6, 56.99, LocalDate.of(2024, Month.SEPTEMBER, 3));
        testTanks.add(TEST_TANK_1);
        testTanks.add(TEST_TANK_2);
        testTanks.add(TEST_TANK_3);
        testTanks.add(TEST_TANK_4);
        testTanks.add(TEST_TANK_5);

        try {
            for (RefuelTank testTank : testTanks) {
                for (InformationType testType : testTypes) {
                    if (testTank.getType(testType) <= 0)
                        throw new IllegalArgumentException("items cannot equal or be less then 0");
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }

    }


    void filetersInvalidNumbers() {

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
                RefuelTank CALCULATED_HIGHEST_REFUEL_TANK = calculator.highestRefuelTank(testTanks, testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_HIGHEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the highest " + testType + " should be " + highestTypeData +
                            " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }


    }

    @org.junit.jupiter.api.Test
    void highestFarAppartNumbers() {
        testTanks.clear();
        // tank 1 has values of : kilometersDriven = 0.0, literPrice = 2.0789, km/l = 0.0
        RefuelTank TEST_TANK_1 = new RefuelTank(54, 5004, 16.54, 31.6, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 2 has values of : kilometersDriven = 3034, literPrice = 2.0666, km/l = 10.0
        RefuelTank TEST_TANK_2 = new RefuelTank(22, 8038, 302.25, 31, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 3 has values of : kilometersDriven = -4864 (invalid), literPrice = 2.101, km/l = -78.7 (invalid)
        RefuelTank TEST_TANK_3 = new RefuelTank(17, 3174, 61.80, 30.68, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 4 has values of : kilometersDriven = 2214, literPrice = 2.366, km/l = 14.6
        RefuelTank TEST_TANK_4 = new RefuelTank(68, 5388, 152.12, 28.4, LocalDate.of(2024, Month.SEPTEMBER, 3));
        // tank 5 has values of : kilometersDriven = 201, literPrice = 2.0710, km/l = 19.2
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
                RefuelTank CALCULATED_HIGHEST_REFUEL_TANK = calculator.highestRefuelTank(testTanks, testType);
                RefuelTank highestValueRefuelTank = expectedOutcome.get(testType);
                double highestTypeData = highestValueRefuelTank.getType(testType);

                if (!CALCULATED_HIGHEST_REFUEL_TANK.equals(highestValueRefuelTank))
                    throw new IllegalArgumentException("the highest " + testType + " should be " + highestTypeData +
                            " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }

    }

    @org.junit.jupiter.api.Test
    void highestMixedNumbers() {

    }

}