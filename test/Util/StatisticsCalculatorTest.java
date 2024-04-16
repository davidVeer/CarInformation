package Util;

import Data.CarData;
import Data.RefuelTank;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCalculatorTest {
    StatisticsCalculator calculator = new StatisticsCalculator();
    ArrayList<RefuelTank> testTanks = new ArrayList<>();
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
    void negativeNumbers(){
        ArrayList<InformationType> testTypes = new ArrayList<>();

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

        testTypes.add(InformationType.REFUEL_NUMBER);
        testTypes.add(InformationType.REFUEL_PRICE);
        testTypes.add(InformationType.KILOMETERS_DRIVEN);
        testTypes.add(InformationType.LITERS);
        testTypes.add(InformationType.KILOMETERS_PER_LITER);
        testTypes.add(InformationType.LITER_PRICE);

        try {
            for (RefuelTank testTank : testTanks) {
                for (InformationType testType : testTypes) {
                    if (testTank.getType(testType) <= 0)
                        throw new IllegalArgumentException("items cannot equal or be less then 0");
                }
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            fail();
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

        InformationType testType = InformationType.REFUEL_NUMBER;

        try {
            for (int i = 0; i < 5; i++) {
                RefuelTank HIGHEST_VALUE_REFUEL_TANK;
                double HIGHEST_TYPE_DATA;

                switch (testType) {
                    case REFUEL_NUMBER:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_5;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            testType = InformationType.LITERS;
                            continue;
                        }
                        throw new IllegalArgumentException("the highest refuel number should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));

                    case LITERS:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_5;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            testType = InformationType.REFUEL_PRICE;
                            continue;
                        }
                        throw new IllegalArgumentException("the highest liters should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));

                    case REFUEL_PRICE:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_1;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            testType = InformationType.LITER_PRICE;
                            continue;
                        }
                        throw new IllegalArgumentException("the highest refuel price should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));

                    case LITER_PRICE:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_4;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            testType = InformationType.KILOMETERS_DRIVEN;
                            continue;
                        }
                        throw new IllegalArgumentException("the highest liter price should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));

                    case KILOMETERS_DRIVEN:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_5;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            testType = InformationType.KILOMETERS_PER_LITER;
                            continue;
                        }
                        throw new IllegalArgumentException("the highest km driven should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));

                    case KILOMETERS_PER_LITER:
                        HIGHEST_VALUE_REFUEL_TANK = TEST_TANK_5;
                        HIGHEST_TYPE_DATA = HIGHEST_VALUE_REFUEL_TANK.getType(testType);

                        if (calculator.highestRefuelTank(testTanks, testType).equals(HIGHEST_VALUE_REFUEL_TANK)) {
                            continue;
                        }
                        throw new IllegalArgumentException("the highest km/l should be " + HIGHEST_TYPE_DATA +
                                " but is: " + calculator.highestRefuelTank(testTanks, testType).getType(testType));
                }
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            fail();
        }

    }

    @org.junit.jupiter.api.Test
    void highestFarAppartNumbers() {
    }

    @org.junit.jupiter.api.Test
    void highestMixedNumbers() {

    }

}