package Data;

import comparators.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

public class CarData {

	private ArrayList<RefuleTank> refuleTanks;
	private ArrayList<RepairJob> repairJobs;
	private StatisticsCalculator statisticsCalculator;

	public CarData() {
		load();
		kilometerDrivenInitialiser();
		statisticsCalculator = new StatisticsCalculator();
	}

	//initialiser for kilometers driven
	private void kilometerDrivenInitialiser(){
		RefuleTank previousRefule = refuleTanks.get(0);

		for (RefuleTank refuleTank : refuleTanks) {
			int deltaKilometers = refuleTank.getOdometer() - previousRefule.getOdometer();
			refuleTank.setKilometersDriven(deltaKilometers);
			previousRefule = refuleTank;
		}
	}

	//todo: add testcode here if necessary, remove before commit to main (version-release)
	public void printHighest(InformationType wantedInformation) {
		System.out.println(statisticsCalculator.highestRefuleTank(this.refuleTanks, wantedInformation));
	}

	public void printLowest(InformationType wantedInformation){
		System.out.println(statisticsCalculator.lowestRefuleTank(this.refuleTanks, wantedInformation));
	}

	public void printRefuleTanks(){
		for (RefuleTank refuleTank : refuleTanks) {
			System.out.println(refuleTank);
		}
	}

	//methods to order list in diffrerent ways

	public void orderBy(Comparator<RefuleTank> comparator) {
		refuleTanks.sort(comparator);
	}

	public void printRepairJobs(){

	}


	//save and load functionalities
	//todo: add proper saving functionality
	public void save() {

	}
	//todo: add proper loading functionality

	public void load() {
		this.refuleTanks = new ArrayList<>();
		this.repairJobs = new ArrayList<>();

		refuleTanks.add(new RefuleTank(1,57888,33.23,69.75, LocalDate.of(2023, Month.SEPTEMBER,4)));
		refuleTanks.add(new RefuleTank(2,58130,20.45,42.52, LocalDate.of(2023, Month.SEPTEMBER,6)));
		refuleTanks.add(new RefuleTank(3,58474,30.70,64.13, LocalDate.of(2023, Month.SEPTEMBER,11)));
		refuleTanks.add(new RefuleTank(4,58727,8.50,20.00, LocalDate.of(2023, Month.SEPTEMBER,15)));
		refuleTanks.add(new RefuleTank(5,58822,19.02,40.60, LocalDate.of(2023, Month.SEPTEMBER,19)));
		refuleTanks.add(new RefuleTank(6,59149,25.92,52.92, LocalDate.of(2023, Month.SEPTEMBER,24)));
		refuleTanks.add(new RefuleTank(7,59525,35.28,72.64, LocalDate.of(2023, Month.OCTOBER,6)));
		refuleTanks.add(new RefuleTank(8,59645,10.62,21.65, LocalDate.of(2023, Month.OCTOBER,7)));
		refuleTanks.add(new RefuleTank(9,59693,8.37,16.48, LocalDate.of(2023, Month.NOVEMBER,16)));
		refuleTanks.add(new RefuleTank(10,60032,25.43,49.82, LocalDate.of(2023, Month.NOVEMBER,17)));
		refuleTanks.add(new RefuleTank(11,60278,23.80,46.15, LocalDate.of(2023, Month.NOVEMBER,22)));
	}
}
