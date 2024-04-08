package Data;

import java.time.LocalDate;

public class RefuleTank {

	private int refuleNumber;

	private LocalDate date;

	private int odometer;

	private double liters;

	private double totalPrice;

	private int kilometersDriven;

	private double literPrice;

	private double kmpl;


	public RefuleTank(int refuleNumber,int odometer, double liters, double totalPrice, LocalDate date) {
		this.refuleNumber = refuleNumber;
		this.odometer = odometer;
		this.liters = liters;
		this.totalPrice = totalPrice;
		this.date = date;
		this.kilometersDriven = -1;
		this.kmpl = -1.0;
		this.literPrice = calculateLiterPrice();
	}

	public double calculateLpkm() {
		return kilometersDriven / liters;
	}

	public double calculateLiterPrice() {
		return totalPrice/liters;
	}

	public void setKilometersDriven(int kilometersDriven) {
		this.kilometersDriven = kilometersDriven;
		this.kmpl = calculateLpkm();
	}

}
