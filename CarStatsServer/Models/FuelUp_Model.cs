using CarStatsServer.Calculators;

namespace CarStatsServer.Models
{
    public class FuelUp_Model : DatabaseObject<ushort>
    {
        public override ushort ObjectKey { get; init; }
        public ushort KilometersDriven { get; init; }
        public uint OdometerReading { get; init; }
        public DateTime FuelUpDate { get; init; }
        public float LitersRefueled { get; init; }
        public float FuelUpCost { get; init; }
        public float FuelEfficiency { get; init; }
        public float LiterPrice { get; init; }
        public float CarbonEmissions { get; init; }


        public FuelUp_Model() {
        }

        public FuelUp_Model(ushort fuelUpId, ushort kilometersDriven, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, float fuelEfficiency, float literPrice, float carbonEmissions) {
            ObjectKey = fuelUpId;
            KilometersDriven = kilometersDriven;
            OdometerReading = odometerReading;
            FuelUpDate = fuelUpDate;
            LitersRefueled = litersRefueled;
            FuelUpCost = fuelUpCost;
            FuelEfficiency = fuelEfficiency;
            LiterPrice = literPrice;
            CarbonEmissions = carbonEmissions;
        }

        public FuelUp_Model(ushort fuelUpNumber, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, uint oldOdometerReading)
        {
            ObjectKey = fuelUpNumber;
            OdometerReading = odometerReading;
            FuelUpDate = fuelUpDate;
            LitersRefueled = litersRefueled;
            FuelUpCost = fuelUpCost;

            KilometersDriven = DataCalculator.CalculateKilometerDriven(oldOdometerReading,odometerReading);
            FuelEfficiency = DataCalculator.CalculateFuelEfficiency(KilometersDriven,litersRefueled);
            LiterPrice = DataCalculator.CalculatePricePerLiter(litersRefueled,fuelUpCost);
        }
    }
}
