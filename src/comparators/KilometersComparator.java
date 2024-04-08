package comparators;

import Data.RefuleTank;
import java.util.Comparator;

public class KilometersComparator
		implements Comparator<RefuleTank>
{

	public int compare(RefuleTank rt1, RefuleTank rt2) {
		return Integer.compare(rt1.getKilometersDriven(), rt2.getKilometersDriven());
	}

}
