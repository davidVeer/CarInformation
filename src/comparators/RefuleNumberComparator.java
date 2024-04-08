package comparators;

import Data.RefuleTank;
import java.util.Comparator;

public class RefuleNumberComparator
		implements Comparator<RefuleTank>
{

	public int compare(RefuleTank rt1, RefuleTank rt2) {
		return Integer.compare(rt1.getRefuleNumber(),rt2.getRefuleNumber());
	}

}
