package Data;

import comparators.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class CarData {

	private ArrayList<RefuleTank> refuleTanks;

	private ArrayList<RepairJob> repairJobs;

	public CarData() {
		load();
		kilometerDrivenInitialiser();
	}

	private void kilometerDrivenInitialiser(){
		RefuleTank previousRefule = refuleTanks.get(0);

		for (RefuleTank refuleTank : refuleTanks) {
			int deltaKilometers = refuleTank.getOdometer() - previousRefule.getOdometer();
			refuleTank.setKilometersDriven(deltaKilometers);
			previousRefule = refuleTank;
		}
	}

	public void printRefuleTanks(){
		for (RefuleTank refuleTank : refuleTanks) {
			System.out.println("\n" + refuleTank.getRefuleNumber() + " : ");
			System.out.println("date : " + refuleTank.getDate());
			System.out.println("odometer : km " + refuleTank.getOdometer());
			System.out.println("liters : l " + refuleTank.getLiters());
			System.out.println("totalPrice : €" + refuleTank.getTotalPrice());
			System.out.println("kilometersDriven : km " + refuleTank.getKilometersDriven());
			System.out.println("kilometers per liter : 1/" + refuleTank.getKmpl());
			System.out.println("literPrice : €" + refuleTank.getLiterPrice());
		}
	}

	public ArrayList<RefuleTank> orderByRefules() {
		ArrayList<RefuleTank> orderedRefules = refuleTanks;
		orderedRefules.sort(new RefuleNumberComparator());
		return orderedRefules;
	}

	public ArrayList<RefuleTank> orderByTotalPrice() {
		ArrayList<RefuleTank> orderedTotalPrices = refuleTanks;
		orderedTotalPrices.sort(new TotalPriceComparator());
		return orderedTotalPrices;
	}

	public ArrayList<RefuleTank> orderByLiterPrice() {
		ArrayList<RefuleTank> orderedLiterPrices = refuleTanks;
		orderedLiterPrices.sort(new LiterPriceComparator());
		return orderedLiterPrices;
	}

	public ArrayList<RefuleTank> orderByLiters() {
		ArrayList<RefuleTank> orderedLiters = refuleTanks;
		orderedLiters.sort(new LitersComparator());
		return orderedLiters;
	}

	public ArrayList<RefuleTank> orderByKmpl() {
		ArrayList<RefuleTank> orderedKmpl = refuleTanks;
		orderedKmpl.sort(new KmplComparator());
		return orderedKmpl;
	}

	public ArrayList<RefuleTank> orderByKilometers() {
		ArrayList<RefuleTank> orderedKilometers = refuleTanks;
		orderedKilometers.sort(new KilometersComparator());
		return orderedKilometers;
	}

	public void printRepairJobs(){

	}

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
