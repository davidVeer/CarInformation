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
        public static ushort CalculateKilometerDriven(uint oldOdometerReading, uint newOdometerReading)
        {
            if (oldOdometerReading < newOdometerReading) return ushort.MaxValue;

            return (ushort)(newOdometerReading - oldOdometerReading);
        }

        public static float CalculateFuelEfficiency(ushort kilometersDriven, float litersUsed)
        {
            float kilometersPerLiter = (float)kilometersDriven / litersUsed;

            if (kilometersPerLiter < 0.0f ||
                kilometersPerLiter > 50.0f) return float.MaxValue;

            return kilometersPerLiter;
        }

        public static float CalculatePricePerLiter(float litersUsed, float fuelUpCost)
        {
            float pricePerLiter = fuelUpCost / litersUsed;

            if (pricePerLiter < 0.0f ||
                pricePerLiter > 4.0f) return float.MaxValue;

            return pricePerLiter;
        }

        public static float CalculateEmissions(ushort kilometersDriven, float fuelConsumption, FuelType fuelType )
        {
            throw new NotImplementedException();
        }      
    }
}
