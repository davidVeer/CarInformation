using CarStatsServer.Calculators;

namespace CarStatsServer.Models
{
    public class FuelUp_Model
    {
        public ushort fuelUpNumber { get; }
        public ushort kilometersDriven { get; }
        public uint odometerReading { get; }
        public DateTime fuelUpDate { get; }
        public float litersRefueled { get; }
        public float fuelUpCost { get; }
        public float fuelEfficiency { get; }
        public float literPrice { get; }
        public float carbonEmissions { get; }

        public FuelUp_Model(ushort fuelUpNumber, ushort kilometersDriven, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, float fuelEfficiency, float literPrice, float carbonEmissions)
        {
            this.fuelUpNumber = fuelUpNumber;
            this.kilometersDriven = kilometersDriven;
            this.odometerReading = odometerReading;
            this.fuelUpDate = fuelUpDate;
            this.litersRefueled = litersRefueled;
            this.fuelUpCost = fuelUpCost;
            this.fuelEfficiency = fuelEfficiency;
            this.literPrice = literPrice;
            this.carbonEmissions = carbonEmissions;
        }

        public FuelUp_Model(ushort fuelUpNumber, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, uint oldOdometerReading)
        {
            this.fuelUpNumber = fuelUpNumber;
            this.odometerReading = odometerReading;
            this.fuelUpDate = fuelUpDate;
            this.litersRefueled = litersRefueled;
            this.fuelUpCost = fuelUpCost;

            kilometersDriven = DataCalculator.CalculateKilometerDriven(oldOdometerReading,odometerReading);
            fuelEfficiency = DataCalculator.CalculateFuelEfficiency(kilometersDriven,litersRefueled);
            literPrice = DataCalculator.CalculatePricePerLiter(litersRefueled,fuelUpCost);
        }
    }
}
