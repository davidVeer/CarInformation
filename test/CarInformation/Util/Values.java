package CarInformation.Util;

import CarInformation.Data.RefuelTank;
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

	}

}
