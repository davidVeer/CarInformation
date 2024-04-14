package Comparators;

import Data.RefuelTank;
import java.util.Comparator;

public class KmplComparator
		implements Comparator<RefuelTank>
{

	public int compare(RefuelTank rt1, RefuelTank rt2) {
		return Double.compare(rt1.getKmpl(), rt2.getKmpl());
	}

}
