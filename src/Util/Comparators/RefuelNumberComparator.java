package Util.Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class RefuelNumberComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Integer.compare(rt1.getRefuelNumber(),rt2.getRefuelNumber());
	}

}
