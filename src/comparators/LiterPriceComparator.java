package comparators;

import Data.RefuleTank;

import java.util.Comparator;

public class LiterPriceComparator
        implements Comparator<RefuleTank>
{
    @Override
    public int compare(RefuleTank rt1, RefuleTank rt2) {
        return Double.compare(rt1.getLiterPrice(),rt2.getLiterPrice());
    }
}
