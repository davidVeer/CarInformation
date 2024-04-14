package Util.Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class KilometersComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Integer.compare(rt1.getKilometersDriven(), rt2.getKilometersDriven());
	}

}
