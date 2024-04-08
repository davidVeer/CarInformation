package Data;

import java.util.ArrayList;

public class CarData {

	private ArrayList<RefuleTank> refuleTanks;

	private ArrayList<RepairJob> repairJobs;

	public CarData() {
		load();
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

	public void save() {

	}

	public void load() {
		this.refuleTanks = new ArrayList<>();
		this.repairJobs = new ArrayList<>();
	}

}
