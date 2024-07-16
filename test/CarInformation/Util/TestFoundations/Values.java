package CarInformation.Util.TestFoundations;

import CarInformation.Data.CarData;
import CarInformation.Data.RefuelTank;
import CarInformation.Util.StatisticsCalculator;

import java.util.ArrayList;

public abstract class Values {

	protected RefuelTank testTank1;

	protected RefuelTank testTank2;

	protected RefuelTank testTank3;

	protected RefuelTank testTank4;

	protected RefuelTank testTank5;

	protected StatisticsCalculator calculator;

	protected ArrayList<RefuelTank> testTanks;

	public abstract void setup();

	public void breakdown() {
		testTanks = new ArrayList<>();
		calculator = new StatisticsCalculator(new CarData(testTanks).getRefuelTanks());
	}

}
