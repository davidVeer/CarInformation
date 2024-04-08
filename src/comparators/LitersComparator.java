package comparators;

import Data.RefuleTank;
import java.util.Comparator;

public class LitersComparator
		implements Comparator<RefuleTank>
{

	public int compare(RefuleTank rt1, RefuleTank rt2) {
		return Double.compare(rt1.getLiters(),rt2.getLiters());
	}

}
