package CarInformation.Data;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class CarData {

    private ArrayList<RefuelTank> refuelTanks;
    private ArrayList<RepairJob> repairJobs;

    public CarData() {
        load();
        kilometerDrivenInitialiser();
    }

    public CarData(ArrayList<RefuelTank> customTanks){
        refuelTanks = customTanks;
        kilometerDrivenInitialiser();
    }

    private void kilometerDrivenInitialiser() {
        try {
            if (refuelTanks.isEmpty())
                throw new NullPointerException();
        } catch (NullPointerException exception){
            System.out.println("the list is empty");
            return;
        }

        RefuelTank previousRefuel = refuelTanks.get(0);
        int deltaKilometers;

        for (RefuelTank refuelTank : refuelTanks) {
            if (previousRefuel.getOdometer() <= 0 ||
                    refuelTank.getOdometer() - previousRefuel.getOdometer() <= 0
            )
                deltaKilometers = -1;

            else
                deltaKilometers = refuelTank.getOdometer() - previousRefuel.getOdometer();

            refuelTank.setKilometersDriven(deltaKilometers);
            previousRefuel = refuelTank;
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
        refuelTanks.add(new RefuelTank(4, 4, 30, 1, LocalDate.of(2023, Month.SEPTEMBER, 15)));
        refuelTanks.add(new RefuelTank(5, 2, 9, 1, LocalDate.of(2023, Month.SEPTEMBER, 19)));
        refuelTanks.add(new RefuelTank(6, 4, 7, 1, LocalDate.of(2023, Month.SEPTEMBER, 24)));
        refuelTanks.add(new RefuelTank(7, 4, 1, 1, LocalDate.of(2023, Month.OCTOBER, 6)));
        refuelTanks.add(new RefuelTank(8, 2, 10, 1, LocalDate.of(2023, Month.OCTOBER, 7)));
    }

    public ArrayList<RefuelTank> getRefuelTanks() {
        return refuelTanks;
    }

    public ArrayList<RepairJob> getRepairJobs() {
        return repairJobs;
    }

}
