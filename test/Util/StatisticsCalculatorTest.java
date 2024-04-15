package Util;

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

    @org.junit.jupiter.api.Test
    void testEmptyList() {
        testTanks = new ArrayList<>();
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
                    if (testTank.getType(testType) >= 0)
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
    }

    @org.junit.jupiter.api.Test
    void highestFarAppartNumbers() {
    }

    @org.junit.jupiter.api.Test
    void highestMixedNumbers() {

    }

}