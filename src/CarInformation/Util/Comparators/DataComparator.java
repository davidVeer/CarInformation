package CarInformation.Util.Comparators;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.InformationType;

import java.util.Comparator;

public class DataComparator
    implements Comparator<RefuelTank>
{
    private final InformationType type;

    public DataComparator(InformationType type) {
        this.type = type;
    }

    @Override
    public int compare(RefuelTank rt1, RefuelTank rt2) {
        return Double.compare(rt1.getType(type), rt2.getType(type));
    }
}
