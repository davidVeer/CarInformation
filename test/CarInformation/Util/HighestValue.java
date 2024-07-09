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

        for (InformationType type : super.getTestTypes()) {
            RefuelTank CalculatedHighest = super.getCalculator().highestRefuelTank(type);

            switch (type){
                case REFUEL_NUMBER:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
                case KILOMETERS_DRIVEN:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
                case LITERS:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
                case REFUEL_PRICE:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
                case LITER_PRICE:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
                case KILOMETERS_PER_LITER:
                    assertEquals(super.getTestTanks().get(19) , CalculatedHighest);
                    break;
            }
        }
    }

    @Test
    void noValid(){

    }

    @Test
    void mixedValidity(){

    }


}
