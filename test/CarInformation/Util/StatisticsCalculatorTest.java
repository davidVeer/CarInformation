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

    private RefuelTank testTank1;
    private RefuelTank testTank2;
    private RefuelTank testTank3;
    private RefuelTank testTank4;
    private RefuelTank testTank5;
    private RefuelTank testTank6;
    private RefuelTank testTank7;
    private RefuelTank testTank8;
    private RefuelTank testTank9;
    private RefuelTank testTank10;

    private RefuelTank testTank11;
    private RefuelTank testTank12;
    private RefuelTank testTank13;
    private RefuelTank testTank14;
    private RefuelTank testTank15;
    private RefuelTank testTank16;
    private RefuelTank testTank17;
    private RefuelTank testTank18;
    private RefuelTank testTank19;
    private RefuelTank testTank20;
    private StatisticsCalculator calculator;
    private ArrayList<RefuelTank> testTanks;
    private ArrayList<InformationType> testTypes;

    public StatisticsCalculatorTest() {
        testTanks = new ArrayList<>();
        testTanks.add(testTank1);
        testTanks.add(testTank2);
        testTanks.add(testTank3);
        testTanks.add(testTank4);
        testTanks.add(testTank5);
        testTanks.add(testTank6);
        testTanks.add(testTank7);
        testTanks.add(testTank8);
        testTanks.add(testTank9);
        testTanks.add(testTank10);

        testTanks.add(testTank11);
        testTanks.add(testTank12);
        testTanks.add(testTank13);
        testTanks.add(testTank14);
        testTanks.add(testTank15);
        testTanks.add(testTank16);
        testTanks.add(testTank17);
        testTanks.add(testTank18);
        testTanks.add(testTank19);
        testTanks.add(testTank20);

        testTypes = new ArrayList<>();
        testTypes.add(InformationType.REFUEL_NUMBER);
        testTypes.add(InformationType.KILOMETERS_DRIVEN);
        testTypes.add(InformationType.LITERS);
        testTypes.add(InformationType.REFUEL_PRICE);
        testTypes.add(InformationType.LITER_PRICE);
        testTypes.add(InformationType.KILOMETERS_PER_LITER);
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


    //TODO: work on filling in all these values
    public void setupAllValidValues(){

        // tank1 : kilometersDriven = -1, liter price = 2.5, kilometers per Liter = -1
        testTank1 = new RefuelTank(1,100, 10.25, 20.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank2 : kilometersDriven = 30, liter price = 1.75, kilometers per Liter =
        testTank2 = new RefuelTank(2,130, 3.99, 5.75, LocalDate.of(2024,Month.JANUARY,3));
        // tank3 : kilometersDriven = 110, liter price = 3.33, kilometers per Liter =
        testTank3 = new RefuelTank(3,240, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,4));
        // tank4 : kilometersDriven = 170, liter price = 2.65, kilometers per Liter =
        testTank4 = new RefuelTank(4,410, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,10));
        // tank5 : kilometersDriven = 210, liter price = 1.5, kilometers per Liter =
        testTank5 = new RefuelTank(5,620, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,14));
        // tank6 : kilometersDriven = 20, liter price = 3.85, kilometers per Liter =
        testTank6 = new RefuelTank(6,640, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,17));
        // tank7 : kilometersDriven = 265, liter price = 1.25, kilometers per Liter =
        testTank7 = new RefuelTank(7,905, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank8 : kilometersDriven = 95, liter price =  1.1, kilometers per Liter =
        testTank8 = new RefuelTank(8,1000, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank9 : kilometersDriven = 234, liter price = 2.78, kilometers per Liter =
        testTank9 = new RefuelTank(9,1234, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank10 : kilometersDriven = 196, liter price = 3.0, kilometers per Liter =
        testTank10 = new RefuelTank(10,1430, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));

        // tank11 : kilometersDriven = 10, liter price = 2.22, kilometers per Liter =
        testTank11 = new RefuelTank(11,1440, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank12 : kilometersDriven = 90, liter price = 2.3, kilometers per Liter =
        testTank12 = new RefuelTank(12,1530, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank13 : kilometersDriven = 320, liter price = 0.7, kilometers per Liter =
        testTank13 = new RefuelTank(13,1850, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank14 : kilometersDriven = 150, liter price = 0.05, kilometers per Liter =
        testTank14 = new RefuelTank(14,2000, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank15 : kilometersDriven = 5, liter price = 1.65, kilometers per Liter =
        testTank15 = new RefuelTank(15,2005, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank16 : kilometersDriven = 50, liter price = 3.52, kilometers per Liter =
        testTank16 = new RefuelTank(16,2055, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank17 : kilometersDriven = 11, liter price = 2.47, kilometers per Liter =
        testTank17 = new RefuelTank(17,2066, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank18 : kilometersDriven = 24, liter price = , kilometers per Liter =
        testTank18 = new RefuelTank(18,2090, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank19 : kilometersDriven = 250, liter price = , kilometers per Liter =
        testTank19 = new RefuelTank(19,2340, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank20 : kilometersDriven = 155, liter price = , kilometers per Liter =
        testTank20 = new RefuelTank(20,2595, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));

        calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
    }
    public void setupNoValidValues(){}
    public void setupAllIdenticalValues(){}
    public void setupMixedValidityValues(){}
    public void setupSimilarValues(){}
    public void setupAllValidNoIdenticalValues(){}


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

    public StatisticsCalculator getCalculator() {
        return calculator;
    }

    public ArrayList<RefuelTank> getTestTanks() {
        return testTanks;
    }

    public ArrayList<InformationType> getTestTypes() {
        return testTypes;
    }

    /*
    getting/calculating median values
    calculating mode values (can return multiple values)
    calculating (population) standard deviation
    calculating (population) variance
     */
}