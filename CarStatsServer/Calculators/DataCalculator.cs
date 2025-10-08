using CarStatsServer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Calculators
{
    public class DataCalculator
    {
        public ushort CalculateKilometerDriven(uint oldOdometerReading, uint newOdometerReading)
        {
            throw new NotImplementedException();
        }

        public float CalculateFuelConsumption(ushort kilometersDriven, float litersUsed)
        {
            throw new NotImplementedException();
        }

        public float CalculatePricePerLiter(float litersUsed, float fuelUpCost)
        {
            throw new NotImplementedException();
        }

        public float CalculateEmissions(ushort kilometersDriven, float fuelConsumption, FuelType fuelType )
        {
            throw new NotImplementedException();
        }      
    }
}
