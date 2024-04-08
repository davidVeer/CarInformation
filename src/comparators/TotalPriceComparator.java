package comparators;

import Data.RefuleTank;
import java.util.Comparator;

public class TotalPriceComparator
		implements Comparator<RefuleTank>
{

	public int compare(RefuleTank rt1, RefuleTank rt2) {
		return Double.compare(rt1.getTotalPrice(), rt2.getTotalPrice());
	}

}
