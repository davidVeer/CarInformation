package CarInformation.Util;

import CarInformation.Data.RefuelTank;
import CarInformation.Util.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HighestValue extends StatisticsCalculatorTest{


    @Test
    void allValid(){
        super.setupAllValidValues();
        RefuelTank CalculatedHighest = super.calculator.highestRefuelTank(InformationType.REFUEL_NUMBER);

        assertEquals(super.testTanks.get(19) , CalculatedHighest);
    }

    @Test
    void noValid(){

    }

    @Test
    void mixedValidity(){

    }


}
