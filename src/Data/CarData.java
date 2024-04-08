package Data;

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
			int deltaKilometers = refuleTank.getKilometersDriven() - previousRefule.getKilometersDriven();
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
		ArrayList<RefuleTank> orderedRefules = new ArrayList<>();

		return orderedRefules;
	}

	public ArrayList<RefuleTank> orderByTotalPrice() {
		ArrayList<RefuleTank> orderedTotalPrices = new ArrayList<>();

		return orderedTotalPrices;
	}

	public ArrayList<RefuleTank> orderByLiterPrice() {
		ArrayList<RefuleTank> orderedLiterPrices = new ArrayList<>();

		return orderedLiterPrices;
	}

	public ArrayList<RefuleTank> orderByLiters() {
		ArrayList<RefuleTank> orderedLiters = new ArrayList<>();

		return orderedLiters;
	}

	public ArrayList<RefuleTank> orderByKmpl() {
		ArrayList<RefuleTank> orderedKmpl = new ArrayList<>();

		return orderedKmpl;
	}

	public ArrayList<RefuleTank> orderByKilometers() {
		ArrayList<RefuleTank> orderedKilometers = new ArrayList<>();

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


	}

}
