package Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class LitersComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Double.compare(rt1.getLiters(),rt2.getLiters());
	}

}
