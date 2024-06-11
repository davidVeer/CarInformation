package Data;

import Util.InformationType;
import Util.StatisticsCalculator;
import Util.Comparators.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class CarData {

    private ArrayList<RefuelTank> refuelTanks;
    private ArrayList<RepairJob> repairJobs;
    private final StatisticsCalculator statisticsCalculator;

    public CarData() {
        load();
        kilometerDrivenInitialiser();
        statisticsCalculator = new StatisticsCalculator();
    }

    //initialiser for kilometers driven
    private void kilometerDrivenInitialiser() {
        RefuelTank previousRefuel = refuelTanks.get(0);

        for (RefuelTank refuelTank : refuelTanks) {
            int deltaKilometers = refuelTank.getOdometer() - previousRefuel.getOdometer();
            refuelTank.setKilometersDriven(deltaKilometers);
            previousRefuel = refuelTank;
        }
    }

    //todo: add testcode here if necessary, remove before commit to main (version-release)

    public CarData(ArrayList<RefuelTank> customTanks){
        refuelTanks = customTanks;
        kilometerDrivenInitialiser();
        statisticsCalculator = new StatisticsCalculator();
    }

    public void printAsArray(InformationType wantedInformation) {
        System.out.print("\n");
        System.out.print("{ ");
        for (RefuelTank refuelTank : refuelTanks) {
            System.out.print( ", "+ refuelTank.getType(wantedInformation));
        }
        System.out.print(" }");
    }

    public void printHighest(InformationType wantedInformation) {
        System.out.println("highest " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.highestRefuelTank(this.refuelTanks, wantedInformation));
    }

    public void printLowest(InformationType wantedInformation) {
        System.out.println("lowest " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.lowestRefuelTank(this.refuelTanks, wantedInformation));
    }

    public void printMedians(InformationType wantedInformation) {
        System.out.println("median for " + wantedInformation + " is/are : ");
        System.out.println(statisticsCalculator.medianRefuelTank(this.refuelTanks, wantedInformation));
    }

    public void printAverage(InformationType wantedInformation) {
        System.out.println("average " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.meanRefuelTank(this.refuelTanks, wantedInformation) + "\n");
    }

    public void printMode(InformationType wantedInformation) {
        System.out.println("Modal value(s) for " + wantedInformation + " is/are : ");
        for (Double mostCommonValue : statisticsCalculator.modeRefuelTank(this.refuelTanks,wantedInformation)) {
            System.out.println(mostCommonValue);
        }
    }

    public void printTotalValue(InformationType wantedInformation) {
        System.out.println("total " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.totalValueRefuleTank(this.refuelTanks, wantedInformation));
    }

    public void printVariance(InformationType wantedInformation) {
        System.out.println("variance of " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.populationVarianceRefuelTank(this.refuelTanks, wantedInformation));
    }

    public void printStandardDeviation(InformationType wantedInformation) {
        System.out.println("standard deviation of " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.populationStandardDeviationRefuelTank(this.refuelTanks, wantedInformation));
    }

    public void printRefuelTanks() {
        for (RefuelTank refuelTank : refuelTanks) {
            System.out.println(refuelTank);
        }
    }

    public void printRepairJobs() {

    }

    //methods to order list in diffrerent ways

    public void orderBy(InformationType wantedInformation) {
        switch (wantedInformation) {
            case LITERS:
                refuelTanks.sort(new LitersComparator());
                break;
            case REFUEL_PRICE:
                refuelTanks.sort(new TotalPriceComparator());
                break;
            case KILOMETERS_DRIVEN:
                refuelTanks.sort(new KilometersComparator());
                break;
            case LITER_PRICE:
                refuelTanks.sort(new LiterPriceComparator());
                break;
            case KILOMETERS_PER_LITER:
                refuelTanks.sort(new KmplComparator());
                break;
            case REFUEL_NUMBER:
                refuelTanks.sort(new RefuelNumberComparator());
                break;
        }
    }

    //save and load functionalities
    //todo: add proper saving functionality
    public void save() {

    }

    //todo: add proper loading functionality

    public void load() {
        this.refuelTanks = new ArrayList<>();
        this.repairJobs = new ArrayList<>();

        refuelTanks.add(new RefuelTank(2, 2, 4, 1, LocalDate.of(2023, Month.SEPTEMBER, 6)));
        refuelTanks.add(new RefuelTank(3, 10, 4, 1, LocalDate.of(2023, Month.SEPTEMBER, 11)));
        refuelTanks.add(new RefuelTank(4, 3, 30, 1, LocalDate.of(2023, Month.SEPTEMBER, 15)));
        refuelTanks.add(new RefuelTank(5, 4, 9, 1, LocalDate.of(2023, Month.SEPTEMBER, 19)));
        refuelTanks.add(new RefuelTank(6, 4, 7, 1, LocalDate.of(2023, Month.SEPTEMBER, 24)));
        refuelTanks.add(new RefuelTank(7, 4, 1, 1, LocalDate.of(2023, Month.OCTOBER, 6)));
        refuelTanks.add(new RefuelTank(8, 2, 10, 1, LocalDate.of(2023, Month.OCTOBER, 7)));
    }
}
