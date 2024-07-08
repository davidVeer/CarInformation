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
    public StatisticsCalculator calculator;
    public ArrayList<RefuelTank> testTanks = new ArrayList<>();
    public ArrayList<InformationType> testTypes = new ArrayList<>(Arrays.asList(
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


    //TODO: work on filling in all these values
    public void setupAllValidValues(){
        testTanks.clear();

        // tank1 : kilometersDriven = -1, liter price = , kilometers per Liter = -1
        RefuelTank testTank1 = new RefuelTank(1,100, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank2 : kilometersDriven = 30, liter price = , kilometers per Liter =
        RefuelTank testTank2 = new RefuelTank(2,130, 3.99, 5.75, LocalDate.of(2024,Month.JANUARY,3));
        // tank3 : kilometersDriven = 110, liter price = , kilometers per Liter =
        RefuelTank testTank3 = new RefuelTank(3,240, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,4));
        // tank4 : kilometersDriven = 170, liter price = , kilometers per Liter =
        RefuelTank testTank4 = new RefuelTank(4,410, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,10));
        // tank5 : kilometersDriven = 210, liter price = , kilometers per Liter =
        RefuelTank testTank5 = new RefuelTank(5,620, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,14));
        // tank6 : kilometersDriven = 20, liter price = , kilometers per Liter =
        RefuelTank testTank6 = new RefuelTank(6,640, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,17));
        // tank7 : kilometersDriven = 265, liter price = , kilometers per Liter =
        RefuelTank testTank7 = new RefuelTank(7,905, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank8 : kilometersDriven = 95, liter price = , kilometers per Liter =
        RefuelTank testTank8 = new RefuelTank(8,1000, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank9 : kilometersDriven = 234, liter price = , kilometers per Liter =
        RefuelTank testTank9 = new RefuelTank(9,1234, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank10 : kilometersDriven = 196, liter price = , kilometers per Liter =
        RefuelTank testTank10 = new RefuelTank(10,1430, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));

        // tank11 : kilometersDriven = 10, liter price = , kilometers per Liter =
        RefuelTank testTank11 = new RefuelTank(11,1440, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank12 : kilometersDriven = 90, liter price = , kilometers per Liter =
        RefuelTank testTank12 = new RefuelTank(12,1530, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank13 : kilometersDriven = 320, liter price = , kilometers per Liter =
        RefuelTank testTank13 = new RefuelTank(13,1850, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank14 : kilometersDriven = 150, liter price = , kilometers per Liter =
        RefuelTank testTank14 = new RefuelTank(14,2000, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank15 : kilometersDriven = 5, liter price = , kilometers per Liter =
        RefuelTank testTank15 = new RefuelTank(15,2005, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank16 : kilometersDriven = 50, liter price = , kilometers per Liter =
        RefuelTank testTank16 = new RefuelTank(16,2055, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank17 : kilometersDriven = 11, liter price = , kilometers per Liter =
        RefuelTank testTank17 = new RefuelTank(17,2066, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank18 : kilometersDriven = 24, liter price = , kilometers per Liter =
        RefuelTank testTank18 = new RefuelTank(18,2090, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank19 : kilometersDriven = 250, liter price = , kilometers per Liter =
        RefuelTank testTank19 = new RefuelTank(19,2340, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));
        // tank20 : kilometersDriven = 155, liter price = , kilometers per Liter =
        RefuelTank testTank20 = new RefuelTank(20,2595, 10.25, 22.50, LocalDate.of(2024,Month.JANUARY,1));

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


    /*
    getting/calculating median values
    calculating mode values (can return multiple values)
    calculating (population) standard deviation
    calculating (population) variance
     */
}