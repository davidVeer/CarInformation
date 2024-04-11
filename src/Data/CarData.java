package Data;

import Util.StatisticsCalculator;
import Comparators.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class CarData {

    private ArrayList<RefuelTank> refuelTanks;
    private ArrayList<RepairJob> repairJobs;
    private StatisticsCalculator statisticsCalculator;

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

    public void printIndex(int index) {
        System.out.println(refuelTanks.get(index));
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
        System.out.println("median(s) of " + wantedInformation + " is/are : ");

        for (RefuelTank refuelTank : statisticsCalculator.medianRefuelTank(this.refuelTanks, wantedInformation)) {
            System.out.println(refuelTank);
        }
    }

    public void printAverage(InformationType wantedInformation) {
        System.out.println("average " + wantedInformation + " is : ");
        System.out.println(statisticsCalculator.averageRefuelTank(this.refuelTanks, wantedInformation) + "\n");
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
            case TOTAL_PRICE:
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

        refuelTanks.add(new RefuelTank(1, 57888, 33.23, 69.75, LocalDate.of(2023, Month.SEPTEMBER, 4)));
        refuelTanks.add(new RefuelTank(2, 58130, 21.45, 42.52, LocalDate.of(2023, Month.SEPTEMBER, 6)));
        refuelTanks.add(new RefuelTank(3, 58474, 34.70, 64.13, LocalDate.of(2023, Month.SEPTEMBER, 11)));
        refuelTanks.add(new RefuelTank(4, 58727, 10.50, 20.00, LocalDate.of(2023, Month.SEPTEMBER, 15)));
        refuelTanks.add(new RefuelTank(5, 58822, 20.02, 40.60, LocalDate.of(2023, Month.SEPTEMBER, 19)));
        refuelTanks.add(new RefuelTank(6, 59149, 25.92, 52.92, LocalDate.of(2023, Month.SEPTEMBER, 24)));
        refuelTanks.add(new RefuelTank(7, 59525, 34.28, 72.64, LocalDate.of(2023, Month.OCTOBER, 6)));
        refuelTanks.add(new RefuelTank(8, 59645, 8.62, 21.65, LocalDate.of(2023, Month.OCTOBER, 7)));
        refuelTanks.add(new RefuelTank(9, 59693, 8.37, 16.48, LocalDate.of(2023, Month.NOVEMBER, 16)));
        refuelTanks.add(new RefuelTank(10, 60032, 24.43, 49.82, LocalDate.of(2023, Month.NOVEMBER, 17)));
        refuelTanks.add(new RefuelTank(11, 60278, 24.80, 46.15, LocalDate.of(2023, Month.NOVEMBER, 22)));
//        refuelTanks.add(new RefuelTank(12, 60578, 23.80, 46.15, LocalDate.of(2023, Month.NOVEMBER, 22)));
//        refuelTanks.add(new RefuelTank(13, 60878, 7.80, 46.15, LocalDate.of(2023, Month.NOVEMBER, 22)));
//        refuelTanks.add(new RefuelTank(14, 61278, 3.80, 46.15, LocalDate.of(2023, Month.NOVEMBER, 22)));
//        refuelTanks.add(new RefuelTank(15, 61378, 3.80, 46.15, LocalDate.of(2023, Month.NOVEMBER, 22)));
    }
}
