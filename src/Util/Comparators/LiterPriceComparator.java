package Util.Comparators;

import Data.RefuelTank;

import java.util.Comparator;

public class LiterPriceComparator
        implements Comparator<RefuelTank>
{
    @Override
    public int compare(RefuelTank rt1, RefuelTank rt2) {
        return Double.compare(rt1.getLiterPrice(),rt2.getLiterPrice());
    }
}
