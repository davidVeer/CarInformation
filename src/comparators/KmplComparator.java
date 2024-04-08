package comparators;

import Data.RefuleTank;
import java.util.Comparator;

public class KmplComparator
		implements Comparator<RefuleTank>
{

	public int compare(RefuleTank rt1, RefuleTank rt2) {
		return Double.compare(rt1.getKmpl(), rt2.getKmpl());
	}

}
