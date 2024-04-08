package Data;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepairJob {

	private int repairNumber;
	private ArrayList<LocalDate> dates;

	private ArrayList<String> newParts;

	public RepairJob(ArrayList<LocalDate> dates, ArrayList<String> newParts) {
		this.dates = dates;
		this.newParts = newParts;
	}


	public ArrayList<LocalDate> getDates(){
		return dates;
	}
	public ArrayList<String> getNewParts(){
		return newParts;
	}

}
