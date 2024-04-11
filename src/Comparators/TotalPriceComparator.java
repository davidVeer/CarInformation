package Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class TotalPriceComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Double.compare(rt1.getTotalPrice(), rt2.getTotalPrice());
	}

}
