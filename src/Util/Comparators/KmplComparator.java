package Util.Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class KmplComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Double.compare(rt1.getKilometersPerLiter(), rt2.getKilometersPerLiter());
	}

}
